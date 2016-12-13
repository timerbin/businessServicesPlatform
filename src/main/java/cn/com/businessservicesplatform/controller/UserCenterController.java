package cn.com.businessservicesplatform.controller;

import cn.com.businessservicesplatform.service.BaseUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/user")
public class UserCenterController extends BaseController{
	

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
    @RequestMapping("/index")
    public ModelAndView toLogin(String callbackUrl) {
    	ModelAndView model = new ModelAndView ( "/login/login");
    	return model;
    }
}
