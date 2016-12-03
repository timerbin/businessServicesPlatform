package cn.com.businessservicesplatform.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.businessservicesplatform.common.util.CookieUtil;
import cn.com.businessservicesplatform.model.vo.BaseUserVo;
import cn.com.businessservicesplatform.service.SettingConfigService;

public class BaseController {
	
	@Autowired
	SettingConfigService settingConfigService;

	public static final Logger log = LoggerFactory.getLogger(BaseController.class);
	
	/**
	 * 公用 获取用户信息
	 * @param request
	 * @return
	 */
	protected BaseUserVo getUser(HttpServletRequest request) {
		BaseUserVo baseUser = null ;
		try {
			baseUser = (BaseUserVo) CookieUtil.getSession(request);
			if(null == baseUser){
				baseUser = CookieUtil.getCookieUser(request);
				if(null != baseUser){
					CookieUtil.setSession(request, baseUser);
				}
			}
		} catch (Exception e) {
			log.error("BaseController.getUser.is.error",e);
		}
		return baseUser;
	}
	
	
}
