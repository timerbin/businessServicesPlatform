package cn.com.businessservicesplatform.service;

import cn.com.businessservicesplatform.model.mysql.BaseUser;
import cn.com.businessservicesplatform.model.vo.BaseUserVo;

public interface BaseUserService {
	
	/**
	 * @Description: 注册 <br>
	 * @Author: wangwenbin <br>
	 * @Date: 2016年12月1日 <br>
	 * @Time: 下午8:51:57 <br>
	 * @param baseUserVo
	 * @return
	 * @return Integer <br>
	 * @throws
	 */
	public Integer register(BaseUserVo baseUserVo);
	/**
	 * 
	 * @Description: 查询用户信息 <br>
	 * @Author: wangwenbin <br>
	 * @Date: 2016年12月1日 <br>
	 * @Time: 下午8:51:52 <br>
	 * @param baseUserVo
	 * @return
	 * @return BaseUser <br>
	 * @throws
	 */
	public BaseUser findBaseUser(BaseUserVo baseUserVo);
	
	public int updatePassword(BaseUserVo baseUserVo);
	
	public int updateUserInfo(BaseUserVo baseUserVo);
	
	public BaseUser selectByPrimaryKey(Integer id);
}
