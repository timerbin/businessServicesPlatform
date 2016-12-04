package cn.com.businessservicesplatform.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.dao.mysql.UserServiceCommentMapper;
import cn.com.businessservicesplatform.dao.mysql.UserServiceCommentTagMapper;
import cn.com.businessservicesplatform.model.vo.UserServiceCommentVo;
import cn.com.businessservicesplatform.service.UserServiceCommentService;

@Service
public class UserServiceCommentServiceImpl implements UserServiceCommentService{
	
	@Autowired
	UserServiceCommentMapper userServiceCommentMapper;
	
	@Autowired
	UserServiceCommentTagMapper userServiceCommentTagMapper;

	@Override
	public int insert(UserServiceCommentVo vo) {
		return 0;
	}

	@Override
	public UserServiceCommentVo getCommentSize(UserServiceCommentVo vo) {
		return null;
	}

	@Override
	public List<UserServiceCommentVo> queryPage(BasePage basePage, UserServiceCommentVo vo) {
		return userServiceCommentMapper.queryPage(basePage, vo);
	}
 
}
