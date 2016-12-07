package cn.com.businessservicesplatform.controller;

import cn.com.businessservicesplatform.model.mysql.BaseUser;
import cn.com.businessservicesplatform.model.vo.BaseUserVo;
import cn.com.businessservicesplatform.model.vo.UserServiceCommentVo;
import cn.com.businessservicesplatform.service.BaseUserCompanyService;
import cn.com.businessservicesplatform.service.BaseUserService;
import cn.com.businessservicesplatform.service.UserServiceCommentService;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	BaseUserService baseUserService;
	@Autowired
	BaseUserCompanyService baseUserCompanyService;
	@Autowired
	UserServiceCommentService userServiceCommentService;
	
	
	/**
     * @Description: 跳转到修改密码页面 <br>
     * @Author: wangwenbin <br>
     * @Date: 2016年11月30日 <br>
     * @Time: 下午7:59:17 <br>
     * @return
     * @return ModelAndView <br>
     * @throws
     */
    @RequestMapping("/toEditPassword")
    public ModelAndView toEditPassword(HttpServletRequest request,String msg) {
    	ModelAndView model = new ModelAndView ( "/user/editPassword");
    	BaseUserVo baseUserVo = this.getUser(request);
    	model.addObject("user", baseUserVo);
    	if(StringUtils.isBlank(msg) && msg.equals("success")){
    		model.addObject("errorMsg", "修改成功");
    	}
    	return model;
    }
    @RequestMapping("/doEditPassword")
    public ModelAndView doEditPassword(HttpServletRequest request,HttpServletResponse response,BaseUserVo baseUserVo) {
    	ModelAndView model = new ModelAndView ( "/user/editPassword");
    	try {
    		BaseUserVo nowUser = this.getUser(request);
        	model.addObject("user", nowUser);
			String checkLogin = check(baseUserVo);
			if(!StringUtils.isBlank(checkLogin)){
				model.addObject("errorMsg", checkLogin);
				log.error(String.format("UserController.doEditPassword.check.error:%s", checkLogin));
				return model;
			}
			baseUserVo.setId(nowUser.getId());
			int result = baseUserService.updatePassword(baseUserVo);
			if(result > 0){
				model = new ModelAndView ( "redirect:/user/toEditUserInfo.html?msg=success");
				return model;
			}else{
				if(result == -2){
					model.addObject("errorMsg", "原密码输入错误,请重新输入");
					log.error(String.format("LoginController.doEditPassword.oldUserPwd.is.error:%s","原密码输入错误,请重新输入"));
					return model;
				}
				model.addObject("errorMsg", "修改失败,请稍后再试");
				log.error(String.format("LoginController.doEditPassword.error:%s","修改失败，请稍后再试"));
			}
		} catch (Exception e) {
			log.error(String.format("LoginController.doEditPassword.system.error:%s","系统繁忙，请稍后再试"),e);
			model.addObject("errorMsg", "系统繁忙，请稍后再试");
			return model;
		}
    	return model;
    }
    private String check(BaseUserVo baseUserVo){
    	if(null == baseUserVo){
    		return "密码信息为空";
    	}
    	if(StringUtils.isBlank(baseUserVo.getOldLoginPwd())){
    		return "原密码为空";
    	}
    	if(StringUtils.isBlank(baseUserVo.getLoginPwd())){
    		return "新密码为空";
    	}
    	if(StringUtils.isBlank(baseUserVo.getLoginPwd2())){
    		return "确认新为空";
    	}
    	if(!baseUserVo.getLoginPwd().equals(baseUserVo.getLoginPwd2())){
    		return "新密码与确认新密码不相同";
    	}
    	return null;
    }
    
     
    @RequestMapping("/toEditUserInfo")
    public ModelAndView toEditUserInfo(HttpServletRequest request,String msg) {
    	ModelAndView model = new ModelAndView ( "/user/editUserinfo");
    	BaseUserVo baseUserVo = this.getUser(request);
    	BaseUser baseUser = baseUserService.selectByPrimaryKey(baseUserVo.getId());
    	model.addObject("vo", baseUser);
    	return model;
    }
    @RequestMapping("/doEditUserInfo")
    public ModelAndView doEditUserInfo(HttpServletRequest request,HttpServletResponse response,BaseUserVo baseUserVo) {
    	ModelAndView model = new ModelAndView ( "/user/editUserinfo");
    	try {
    		BaseUserVo nowUser = this.getUser(request);
        	model.addObject("user", nowUser);
        	BaseUserVo userVo = this.getUser(request);
        	BaseUser baseUser = baseUserService.selectByPrimaryKey(userVo.getId());
        	model.addObject("vo", baseUser);
			String checkLogin = checkUserInfo(baseUserVo);
			if(!StringUtils.isBlank(checkLogin)){
				model.addObject("errorMsg", checkLogin);
				log.error(String.format("UserController.doEditUserInfo.check.error:%s", checkLogin));
				return model;
			}
			baseUserVo.setId(nowUser.getId());
			int result = baseUserService.updateUserInfo(baseUserVo);
			if(result > 0){
				 model = new ModelAndView ( "redirect:/user/toEditUserInfo.html");
				 return model;
			}else{
				model.addObject("errorMsg", "修改失败,请稍后再试");
				log.error(String.format("LoginController.doEditUserInfo.error:%s","修改失败，请稍后再试"));
			}
		} catch (Exception e) {
			log.error(String.format("LoginController.doEditUserInfo.system.error:%s","系统繁忙，请稍后再试"),e);
			model.addObject("errorMsg", "系统繁忙，请稍后再试");
			return model;
		}
    	return model;
    }
    private String checkUserInfo(BaseUserVo baseUserVo){
    	if(null == baseUserVo){
    		return "修改信息为空";
    	}
    	if(StringUtils.isBlank(baseUserVo.getRaleName())){
    		return "姓名为空";
    	}
    	if(StringUtils.isBlank(baseUserVo.getMobilePhone())){
    		return "联系方式为空";
    	}
    	if(StringUtils.isBlank(baseUserVo.getEmail())){
    		return "邮件为空";
    	}
    	if(null == baseUserVo.getSex()){
    		return "性别为空";
    	}
    	return null;
    }
    
    @RequestMapping("/saveComment")
    public ModelAndView saveComment(String callbackUrl,HttpServletRequest request,UserServiceCommentVo userServiceCommentVo) {
    	ModelAndView model = new ModelAndView ( "/user/editUserinfo");
    	try {
    		BaseUserVo nowUser = this.getUser(request);
    		if(null == nowUser){
    			model = new ModelAndView ( "redirect:/login/toLogin.html?callbackUrl="+callbackUrl);
				return model;
    		}
    		callbackUrl = "/home/serviceShow.html?id="+userServiceCommentVo.getServiceId()+"&code=";
    		String checkMsg = checkUserInfo(userServiceCommentVo);
			if(!StringUtils.isBlank(checkMsg)){
				model.addObject("errorMsg", checkMsg);
				log.error(String.format("UserController.saveComment.check.error:%s", checkMsg));
				model = new ModelAndView ( "redirect:"+callbackUrl+checkMsg);
				return model;
			}
			userServiceCommentVo.setCommentUserId(nowUser.getId());
			userServiceCommentVo.setCommentUserName(nowUser.getLoginName());
        	model.addObject("user", nowUser);
        	
        	int result =  userServiceCommentService.insert(userServiceCommentVo);
         
			if(result > 0){
				 model = new ModelAndView ( "redirect:"+callbackUrl+1);
				 return model;
			}else{
				 model = new ModelAndView ("redirect:"+callbackUrl+1001);
				model.addObject("errorMsg", "评论失败");
				log.error(String.format("LoginController.saveComment.error:%s","修改失败，请稍后再试"));
			}
		} catch (Exception e) {
			model = new ModelAndView ("redirect:"+callbackUrl+1003);
			log.error(String.format("LoginController.saveComment.system.error:%s","系统繁忙，请稍后再试"),e);
			model.addObject("errorMsg", "系统繁忙，请稍后再试");
			return model;
		}
    	return model;
    }
    private String checkUserInfo(UserServiceCommentVo baseUserVo){
    	if(null == baseUserVo){
    		return "10101";
    	}
    	if(baseUserVo.getCommentType()== null){
    		return "10101";
    	}
    	if(baseUserVo.getServiceId()== null){
    		return "10102";
    	}
    	if(StringUtils.isBlank(baseUserVo.getCommentDirections())){
    		return "10103";
    	}
    	 
    	return null;
    }
    
}
