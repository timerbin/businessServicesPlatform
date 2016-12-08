package cn.com.businessservicesplatform.controller;

import cn.com.businessservicesplatform.common.util.CookieUtil;
import cn.com.businessservicesplatform.model.mysql.BaseUser;
import cn.com.businessservicesplatform.model.mysql.BaseUserCompany;
import cn.com.businessservicesplatform.model.vo.BaseUserCompanyVo;
import cn.com.businessservicesplatform.model.vo.BaseUserVo;
import cn.com.businessservicesplatform.service.BaseUserCompanyService;
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


@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	BaseUserService baseUserService;
	@Autowired
	BaseUserCompanyService baseUserCompanyService;
	
	
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
			String code = null;
			HttpSession httpSession = request.getSession();
			if(null != httpSession.getAttribute("verCode")){
				code =  httpSession.getAttribute("verCode").toString();
			}
			if(StringUtils.isBlank(code)){
				model.addObject("errorMsg","验证码输入错误");
				log.error("LoginController.doLogin.check.error:code.is.null");
				return model;
			}else{
				if(!code.equals(baseUserVo.getVerifyCode())){
					model.addObject("errorMsg","验证码输入错误");
					log.error("LoginController.doLogin.check.error:code.is.null");
					return model;
				}
			}
			BaseUser baseUser = baseUserService.findBaseUser(baseUserVo);
			if(null != baseUser && baseUser.getId() != null){
				model.addObject("baseUser", baseUser);
				BaseUserVo userVo =  new BaseUserVo(baseUser);
				BaseUserCompanyVo baseUserCompanyVo = new BaseUserCompanyVo(baseUser.getId());
				BaseUserCompany baseUserCompany = baseUserCompanyService.getUserCompany(baseUserCompanyVo);
				if(null != baseUserCompany && baseUserCompany.getId() != null){
					userVo.setCompanyId(baseUserCompany.getId());
				}
				Boolean setCookieResult = CookieUtil.setCookieUser(request,response,userVo);
				if(!setCookieResult){
					setCookieResult = CookieUtil.setCookieUser(request,response,userVo);
				}
				if(setCookieResult){
					if(!StringUtils.isBlank(baseUserVo.getCallbackUrl())){
						model = new ModelAndView ( "redirect:"+baseUserVo.getCallbackUrl());
			    		return model;
			    	}else{
			    		model = new ModelAndView ( "redirect:/");
			    		return model;
			    	}
				}else{
					log.error(String.format("LoginController.doLogin.setcookie.error:%s",baseUserVo.getUserName()));
					model.addObject("errorMsg", "用户名或密码输入错误");
				}
			}else{
				log.error(String.format("LoginController.doLogin.UserName.null:%s",baseUserVo.getUserName()));
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
    	if(StringUtils.isBlank(baseUserVo.getUserName())){
    		return "登录名为空";
    	}
    	if(StringUtils.isBlank(baseUserVo.getUserPassword())){
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
    		model.addObject("vo", baseUserVo);
			String checkResult = checkRegisterMsg(baseUserVo);
			if(!StringUtils.isBlank(checkResult)){
				model.addObject("errorMsg", checkResult);
				log.error(String.format("LoginController.doRegister.check.error:%s",checkResult));
				return model;
			}
			Integer result = baseUserService.register(baseUserVo);
			if(null != result && result.intValue() > 0){
				model = new ModelAndView ( "redirect:/login/toLogin.html"); 
				return model;
			}else{
				log.error(String.format("LoginController.doRegister.save.error:%s",baseUserVo.getUserName()));
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
    	if(StringUtils.isBlank(baseUserVo.getUserName())){
    		return "用户名为空";
    	}
    	if(baseUserVo.getUserName().length() < 6){
    		return "用户名必须大于6位";
    	}
//    	Pattern pattern = Pattern.compile("(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{6,16}");
//		if (!pattern.matcher(baseUserVo.getUserPassword()).matches()  ) {
//			return "密码过于简单";
//		}
    	if(StringUtils.isBlank(baseUserVo.getUserPassword())){
    		return "密码为空";
    	}
    	if(baseUserVo.getUserPassword().length() < 6){
    		return "密码必须大于6位";
    	}
    	if(StringUtils.isBlank(baseUserVo.getUserPassword2())){
    		return "确认密码为空";
    	}
    	if(!baseUserVo.getUserPassword().equals(baseUserVo.getUserPassword2())){
    		return "密码与确认密码不相同";
    	}
    	if(StringUtils.isBlank(baseUserVo.getMobilePhoneNumber())){
    		return "联系方式为空";
    	}
    	if(StringUtils.isBlank(baseUserVo.getEmail())){
    		return "邮件为空";
    	}
    	if(null == baseUserVo.getUserSex()){
    		return "性别为空";
    	}
    	BaseUserVo param = new BaseUserVo();
    	param.setMobilePhoneNumber(baseUserVo.getMobilePhoneNumber());
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
    	param.setUserName(baseUserVo.getUserName());
    	baseUser = baseUserService.findBaseUser(param);
    	if(null != baseUser && baseUser.getId() != null){
    		return "用户名已经存在";
    	}
    	
    	return null;
    }
    
    @RequestMapping("/checkRegister")
	@ResponseBody
	public String checkRegister(BaseUserVo baseUserVo) {
    	if(StringUtils.isBlank(baseUserVo.getUserName())){
    		return "用户名为空";
    	}
    	if(StringUtils.isBlank(baseUserVo.getMobilePhoneNumber())){
    		return "联系方式为空";
    	}
    	if(StringUtils.isBlank(baseUserVo.getEmail())){
    		return "邮件为空";
    	}
    	BaseUserVo param = new BaseUserVo();
    	param.setMobilePhoneNumber(baseUserVo.getMobilePhoneNumber());
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
    	param.setUserName(baseUserVo.getUserName());
    	baseUser = baseUserService.findBaseUser(param);
    	if(null != baseUser && baseUser.getId() != null){
    		return "用户名已经存在";
    	}
    	return "";
    		
    }
}
