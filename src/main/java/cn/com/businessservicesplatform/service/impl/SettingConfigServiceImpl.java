package cn.com.businessservicesplatform.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import cn.com.businessservicesplatform.service.SettingConfigService;

@Service
public class SettingConfigServiceImpl implements SettingConfigService {

	@Value("${com.base.url}")
	private String baseUrl;

	@Override
	public String getBaseUrl() {
		return baseUrl;
	}

	 
}
