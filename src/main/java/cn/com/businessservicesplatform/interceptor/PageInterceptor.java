package cn.com.businessservicesplatform.interceptor;

import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.common.util.ReflectionUtils;

import org.apache.ibatis.executor.statement.BaseStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

@Intercepts( { @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PageInterceptor implements Interceptor {
	/** mapper.xml中需要拦截的ID(正则匹配) **/
	private static String PAGESQL_ID = "pageSqlId";
	
	private String pageSqlId;

	/**
	 * 分页拦截器。
	 * <p>功能主要是用来取总记录数和对SQL分页拦截。
	 * 
	 * @param invocation
	 * @return
	 * @throws Throwable
	 * @see org.apache.ibatis.plugin.Interceptor#intercept(org.apache.ibatis.plugin.Invocation)
	 */
	@SuppressWarnings("unchecked")
	public Object intercept(Invocation invocation) throws Throwable {
		RoutingStatementHandler routingStatementHandler = (RoutingStatementHandler) invocation
				.getTarget();
		BaseStatementHandler delegate = (BaseStatementHandler) ReflectionUtils
				.getFieldValue(routingStatementHandler, "delegate");

		MappedStatement mappedStatement = (MappedStatement) ReflectionUtils
				.getFieldValue(delegate, "mappedStatement");

		if (mappedStatement.getId().matches(pageSqlId)) {
			BoundSql boundSql = delegate.getBoundSql();
			Object parameterObject = boundSql.getParameterObject();
			
			if(parameterObject == null){
				throw new NullPointerException("参数对象尚未实例化！");
			}
			
			Map<String, Object> parameterMap = (Map<String, Object>) parameterObject;
			BasePage basePage = (BasePage) parameterMap.get("basePage");
			
			if(basePage == null){
				throw new NullPointerException("分页对象不存在！");
			}
			
			// 取得连接 
			Connection connection = (Connection) invocation.getArgs()[0];
			String sql = boundSql.getSql();
			
			//删除查询语句中的order by子句
			String newCountSql = "";
			
			newCountSql = delOrderbySQL(sql);
			int idx = newCountSql.toUpperCase().indexOf("FROM ");
			newCountSql = "select count(1) as cnt " + newCountSql.substring(idx);
			
			BoundSql newBoundSql = new BoundSql(mappedStatement
					.getConfiguration(), newCountSql, boundSql
					.getParameterMappings(), parameterObject);
			DefaultParameterHandler parameterHandler = new DefaultParameterHandler(
					mappedStatement, parameterObject, newBoundSql);

			
			PreparedStatement ps = null;
			int count = 0;
			try{
				ps = connection.prepareStatement(newCountSql);
				parameterHandler.setParameters(ps);
				ResultSet rs = ps.executeQuery();
				count = (rs.next()) ? rs.getInt("cnt") : 0;
				rs.close();
			}catch(SQLException e){
				throw new Exception("执行记录总数SQL时发生异常",e);
			}finally{
				try {
					if (ps != null) ps.close();
				} catch (SQLException e) {
					throw new Exception("关闭状态时发生异常", e);
				}
			}
			
			// 把记录总数放入对象pageBean中
			basePage.setCount(count);
			
			String pageSql = getLimitString(sql,basePage);
			
			//将分页sql语句反射回BoundSql. 
			ReflectionUtils.setFieldValue(boundSql, "sql", pageSql);  

		}
		
		return invocation.proceed();
	}

	/**
	 * 删除查询条件中的order by子句
	 * 
	 * @param queryString 查询SQL语句
	 * @return 删除查询语句中的order by子句后的查询语句
	 */
	private String delOrderbySQL(String queryString) {
		StringBuffer temp = new StringBuffer();
		queryString = "(" + queryString + ")";

		String[] strArray = queryString.split("order by");
		for (int i = 1; i < strArray.length; i++) {
			strArray[i] = ")";
		}
		for (int i = 0; i < strArray.length; i++) {
			temp.append(strArray[i]);
		}
		String result = temp.toString();
		if (temp.length() >= 2) {
			result = result.substring(1, result.length() - 1);
		}
		return result;
	}

	private String getLimitString(String sql, BasePage pageBean) {
		/** mysql创建临时表，消耗过大 */
		StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);
		pagingSelect.append(sql);
		pagingSelect.append(" limit ").append(pageBean.getStartNo()).append(",").append(pageBean.getPageSize());
	    return pagingSelect.toString();
	}
	
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties){
		pageSqlId = properties.getProperty(PAGESQL_ID);
		if (pageSqlId == null || pageSqlId.length() < 1) {
		}
	}

}
