package cn.com.businessservicesplatform.service;

import java.util.List;

import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.model.vo.UserCollectHistoryVo;

public interface UserCollectHistoryService {
	
	public int addUserCollectHistory(UserCollectHistoryVo vo);
	
	public int delUserCollectHistory(UserCollectHistoryVo vo);
	
	public List<UserCollectHistoryVo> queryList(UserCollectHistoryVo userCollectHistoryVo);

	public List<UserCollectHistoryVo> queryPage(BasePage basePage, UserCollectHistoryVo userCollectHistoryVo);
}
