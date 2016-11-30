package cn.com.businessservicesplatform.service;

import java.util.List;

import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.model.mysql.BaseConfigData;
import cn.com.businessservicesplatform.model.vo.BaseConfigDataVo;

public interface BaseConfigDataService {
	
	/**
	 * 分页查询基础信息
	 * @param basePage
	 * @param BaseConfigDataVo
	 * @return
	 */
	public List<BaseConfigData> queryPage(BasePage basePage,BaseConfigDataVo baseConfigDataVo);

}
