package cn.com.businessservicesplatform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.dao.mysql.BaseConfigDataMapper;
import cn.com.businessservicesplatform.model.mysql.BaseConfigData;
import cn.com.businessservicesplatform.model.vo.BaseConfigDataVo;
import cn.com.businessservicesplatform.service.BaseConfigDataService;

@Service
public class BaseConfigDataServiceImpl implements BaseConfigDataService{
	
	@Autowired
	BaseConfigDataMapper baseConfigDataMapper;

	public List<BaseConfigDataVo> queryPage(BasePage basePage, BaseConfigDataVo baseConfigDataVo) {
		List<BaseConfigDataVo>  result = null;
		List<BaseConfigData>  list = baseConfigDataMapper.queryPage(basePage, baseConfigDataVo);
		if(null != list && list.size()>0 ){
			result = new ArrayList<BaseConfigDataVo>();
			for(BaseConfigData data :list){
				result.add(new BaseConfigDataVo(data));
			}
		}
		return result;
	}

	@Override
	public List<BaseConfigData> queryList(BaseConfigDataVo baseConfigDataVo) {
		return baseConfigDataMapper.queryList(baseConfigDataVo);
	}

	@Override
	public int updateStatus(BaseConfigDataVo baseConfigDataVo) {
		int result = 0;
		if(null != baseConfigDataVo && baseConfigDataVo.getId() != null){
			BaseConfigData configData = baseConfigDataMapper.selectByPrimaryKey(baseConfigDataVo.getId());
			if(null != configData && configData.getId() != null){
				if(baseConfigDataVo.getUpdateCode().equals("Enabled")){
					configData.setStatus(1);
				}else if(baseConfigDataVo.getUpdateCode().equals("Disable")){
					configData.setStatus(-1);
				}
				result = baseConfigDataMapper.updateByPrimaryKey(configData);
			}
		}
		return result;
	}
	@Override
	public int insert(BaseConfigDataVo baseConfigDataVo){
		
		BaseConfigData data = new BaseConfigData(baseConfigDataVo);
		data.setStatus(1);
		data.setCreateTime(new Date());
		data.setModifyTime(new Date());
		int result = baseConfigDataMapper.insert(data);
		return result;
	}

}
