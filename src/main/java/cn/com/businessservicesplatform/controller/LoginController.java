package cn.com.businessservicesplatform.controller;

import cn.com.businessservicesplatform.common.util.CookieUtil;
import cn.com.businessservicesplatform.common.util.VerifyCodeUtils;
import cn.com.businessservicesplatform.model.mysql.BaseUser;
import cn.com.businessservicesplatform.model.vo.BaseUserVo;
import cn.com.businessservicesplatform.service.BaseUserService;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	BaseUserService baseUserService;
	
	
	/**
     * @Description: 跳转到登录页面 <br>
     * @Author: wangwenbin <br>
     * @Date: 2016年11月30日 <br>
     * @Time: 下午7:59:17 <br>
     * @return
     * @return ModelAndView <br>
     * @throws
     */
    @RequestMapping("/toLogin")
    public ModelAndView toLogin(String callbackUrl) {
    	ModelAndView model = new ModelAndView ( "/login/login");
    	if(!StringUtils.isBlank(callbackUrl)){
    		model.addObject("callbackUrl", callbackUrl);
    	}else{
    		model.addObject("callbackUrl", "");
    	}
    	
    	return model;
    }
    @RequestMapping("/doLogin")
    public ModelAndView doLogin(HttpServletRequest request,HttpServletResponse response,BaseUserVo baseUserVo) {
    	ModelAndView model = new ModelAndView ( "/login/login");
    	try {
			String checkLogin = checkLogin(baseUserVo);
			if(!StringUtils.isBlank(checkLogin)){
				model.addObject("errorMsg", checkLogin);
				log.error(String.format("LoginController.doLogin.check.error:%s", checkLogin));
				return model;
			}
			BaseUser baseUser = baseUserService.findBaseUser(baseUserVo);
			if(null != baseUser && baseUser.getId() != null){
				model.addObject("baseUser", baseUser);
				Boolean setCookieResult = CookieUtil.setCookieUser(request,response,new BaseUserVo(baseUser));
				if(!setCookieResult){
					setCookieResult = CookieUtil.setCookieUser(request,response,new BaseUserVo(baseUser));
				}
				if(setCookieResult){
					if(!StringUtils.isBlank(baseUserVo.getCallbackUrl())){
						model = new ModelAndView ( "redirect:"+baseUserVo.getCallbackUrl());
			    		return model;
			    	}else{
			    		model = new ModelAndView ( "/index");
			    		return model;
			    	}
				}else{
					log.error(String.format("LoginController.doLogin.setcookie.error:%s",baseUserVo.getLoginName()));
					model.addObject("errorMsg", "用户名或密码输入错误");
				}
			}else{
				log.error(String.format("LoginController.doLogin.loginName.null:%s",baseUserVo.getLoginName()));
				model.addObject("errorMsg", "用户名或密码输入错误");
			}
		} catch (Exception e) {
			log.error(String.format("LoginController.doLogin.system.error:%s","系统繁忙，请稍后再试"),e);
			model.addObject("errorMsg", "系统繁忙，请稍后再试");
			return model;
		}
    	return model;
    }
    
    private String checkLogin(BaseUserVo baseUserVo){
    	if(null == baseUserVo){
    		return "注册信息为空";
    	}
    	if(StringUtils.isBlank(baseUserVo.getLoginName())){
    		return "用户名为空";
    	}
    	if(StringUtils.isBlank(baseUserVo.getLoginPwd())){
    		return "密码为空";
    	}
    	if(StringUtils.isBlank(baseUserVo.getVerifyCode())){
    		return "验证码为空";
    	}
    	return null;
    }
    
    
    /**
     * @Description: 跳转到注册页面 <br>
     * @Author: wangwenbin <br>
     * @Date: 2016年11月30日 <br>
     * @Time: 下午7:59:17 <br>
     * @return
     * @return ModelAndView <br>
     * @throws
     */
    @RequestMapping("/toRegister")
    public ModelAndView toRegister() {
    	ModelAndView model = new ModelAndView ( "/login/register"); 
    	model.addObject("errorMsg", "");
    	return model;
    }
    /**
     * @Description: 注册 <br>
     * @Author: wangwenbin <br>
     * @Date: 2016年12月1日 <br>
     * @Time: 下午9:14:40 <br>
     * @param baseUserVo
     * @return
     * @return ModelAndView <br>
     * @throws
     */
    @RequestMapping("/doRegister")
    public ModelAndView doRegister(BaseUserVo baseUserVo) {
    	ModelAndView model = new ModelAndView ( "/login/register"); 
    	try {
			String checkResult = checkRegisterMsg(baseUserVo);
			if(!StringUtils.isBlank(checkResult)){
				model.addObject("errorMsg", checkResult);
				log.error(String.format("LoginController.doRegister.check.error:%s",checkResult));
				return model;
			}
			Integer result = baseUserService.register(baseUserVo);
			if(null != result && result.intValue() > 0){
				model = new ModelAndView ( "/index"); 
				return model;
			}else{
				log.error(String.format("LoginController.doRegister.save.error:%s",baseUserVo.getLoginName()));
				model.addObject("errorMsg", "系统繁忙，请稍后再试");
				return model;
			}
		} catch (Exception e) {
			log.error(String.format("LoginController.doRegister.system.error:%s","系统繁忙，请稍后再试"),e);
			model.addObject("errorMsg", "系统繁忙，请稍后再试");
			return model;
		}
    }
    private String checkRegisterMsg(BaseUserVo baseUserVo){
    	if(null == baseUserVo){
    		return "注册信息为空";
    	}
    	if(StringUtils.isBlank(baseUserVo.getLoginName())){
    		return "用户名为空";
    	}
    	if(StringUtils.isBlank(baseUserVo.getLoginPwd())){
    		return "密码为空";
    	}
    	if(StringUtils.isBlank(baseUserVo.getLoginPwd2())){
    		return "确认密码为空";
    	}
    	if(baseUserVo.getLoginPwd().equals(baseUserVo.getLoginPwd2())){
    		return "密码与确认密码不相同";
    	}
    	if(StringUtils.isBlank(baseUserVo.getMobilePhone())){
    		return "联系方式为空";
    	}
    	if(StringUtils.isBlank(baseUserVo.getEmail())){
    		return "邮件为空";
    	}
    	if(null == baseUserVo.getAge()){
    		return "年龄为空";
    	}
    	if(null == baseUserVo.getSex()){
    		return "性别为空";
    	}
    	BaseUserVo param = new BaseUserVo();
    	param.setMobilePhone(baseUserVo.getMobilePhone());
    	BaseUser baseUser = baseUserService.findBaseUser(param);
    	if(null != baseUser && baseUser.getId() != null){
    		return "联系方式已经存在";
    	}
    	param = new BaseUserVo();
    	param.setEmail(baseUserVo.getEmail());
    	baseUser = baseUserService.findBaseUser(param);
    	if(null != baseUser && baseUser.getId() != null){
    		return "邮箱已经存在";
    	}
    	param = new BaseUserVo();
    	param.setLoginName(baseUserVo.getLoginName());
    	baseUser = baseUserService.findBaseUser(param);
    	if(null != baseUser && baseUser.getId() != null){
    		return "用户名已经存在";
    	}
    	
    	return null;
    }
    
    @RequestMapping("/checkRegister")
	@ResponseBody
	public String checkRegister(BaseUserVo baseUserVo) {
    	if(StringUtils.isBlank(baseUserVo.getLoginName())){
    		return "用户名为空";
    	}
    	if(StringUtils.isBlank(baseUserVo.getMobilePhone())){
    		return "联系方式为空";
    	}
    	if(StringUtils.isBlank(baseUserVo.getEmail())){
    		return "邮件为空";
    	}
    	BaseUserVo param = new BaseUserVo();
    	param.setMobilePhone(baseUserVo.getMobilePhone());
    	BaseUser baseUser = baseUserService.findBaseUser(param);
    	if(null != baseUser && baseUser.getId() != null){
    		return "联系方式已经存在";
    	}
    	param = new BaseUserVo();
    	param.setEmail(baseUserVo.getEmail());
    	baseUser = baseUserService.findBaseUser(param);
    	if(null != baseUser && baseUser.getId() != null){
    		return "邮箱已经存在";
    	}
    	param = new BaseUserVo();
    	param.setLoginName(baseUserVo.getLoginName());
    	baseUser = baseUserService.findBaseUser(param);
    	if(null != baseUser && baseUser.getId() != null){
    		return "用户名已经存在";
    	}
    	return "";
    		
    }
}
