package cn.com.businessservicesplatform.common.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.view.JstlView;

import cn.com.businessservicesplatform.service.SettingConfigService;

public class JspJstlView extends JstlView {
	
	SettingConfigService settingConfigService = SpringUtils.getBean(SettingConfigService.class);
	
	@Override
	protected void exposeHelpers(HttpServletRequest request) throws Exception {
		String baseUrl = settingConfigService.getBaseUrl();
		if(StringUtils.isBlank(baseUrl)){
			baseUrl = request.getScheme()+"://"+request.getServerName();
		}
		request.setAttribute("BASE_URL",baseUrl );
		super.exposeHelpers(request);
		
	}
}
