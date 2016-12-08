package cn.com.businessservicesplatform.service;

import java.util.List;

import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.model.mysql.BaseConfigData;
import cn.com.businessservicesplatform.model.vo.BaseConfigDataVo;

public interface BaseConfigDataService {
	
	/**
	 * 分页查询基础信息
	 * @param basePage
	 * @param baseConfigDataVo
	 * @return
	 */
	public List<BaseConfigDataVo> queryPage(BasePage basePage,BaseConfigDataVo baseConfigDataVo);
	
	public List<BaseConfigData> queryList(BaseConfigDataVo baseConfigDataVo);
	
	public int updateStatus(BaseConfigDataVo baseConfigDataVo);
	
	public int insert(BaseConfigDataVo baseConfigDataVo);

}
