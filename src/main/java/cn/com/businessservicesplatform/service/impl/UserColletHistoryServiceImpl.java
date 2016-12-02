package cn.com.businessservicesplatform.service.impl;

import cn.com.businessservicesplatform.dao.mysql.UserCollectHistoryMapper;
import cn.com.businessservicesplatform.model.vo.UserCollectHistoryVo;
import cn.com.businessservicesplatform.service.UserCollectHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserColletHistoryServiceImpl implements UserCollectHistoryService {

	@Autowired
	UserCollectHistoryMapper userCollectHistoryMapper;

	@Override
	public int addUserCollectHistory(UserCollectHistoryVo vo) {
		return userCollectHistoryMapper.insert(vo);
	}
}
