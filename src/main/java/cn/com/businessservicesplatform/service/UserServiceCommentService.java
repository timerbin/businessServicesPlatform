package cn.com.businessservicesplatform.service;

import java.util.List;

import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.model.vo.UserServiceCommentVo;

public interface UserServiceCommentService {
	
	public int insert(UserServiceCommentVo vo);
	
	public UserServiceCommentVo getCommentSize(UserServiceCommentVo vo);
 
	public List<UserServiceCommentVo> queryPage(BasePage basePage,UserServiceCommentVo vo);
	
}
