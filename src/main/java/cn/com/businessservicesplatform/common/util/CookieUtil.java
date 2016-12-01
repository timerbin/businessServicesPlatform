package cn.com.businessservicesplatform.common.util;

import javax.servlet.http.HttpServletRequest;

import cn.com.businessservicesplatform.model.mysql.BaseUser;

public class CookieUtil {

	/**
	 * @Description: 获取cookie中用户信息 <br>
	 * @Author: wangwenbin <br>
	 * @Date: 2016年12月1日 <br>
	 * @Time: 下午9:30:27 <br>
	 * @param request
	 * @return void <br>
	 * @throws
	 */
	public static BaseUser getCookieUser(HttpServletRequest request){
		return new BaseUser();
	}
	
	/**
	 * @Description: 将登录信息写入到cookie <br>
	 * @Author: wangwenbin <br>
	 * @Date: 2016年12月1日 <br>
	 * @Time: 下午9:32:11 <br>
	 * @param request
	 * @param baseUser
	 * @return
	 * @return Boolean <br>
	 * @throws
	 */
	public static Boolean setCookieUser(HttpServletRequest request,BaseUser baseUser){
		return Boolean.TRUE;
	}
	
}
