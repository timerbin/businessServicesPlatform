package cn.com.businessservicesplatform.common.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.JstlView;

import cn.com.businessservicesplatform.service.SettingConfigService;

public class JspJstlView extends JstlView {
	
	SettingConfigService settingConfigService = SpringUtils.getBean(SettingConfigService.class);
	
	@Override
	protected void exposeHelpers(HttpServletRequest request) throws Exception {
		request.setAttribute("BASE_URL", settingConfigService.getBaseUrl());
		super.exposeHelpers(request);
		
	}
}
