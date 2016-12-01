package cn.com.businessservicesplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/shop")
public class BaseUserCompanyController {

	/**
	 * @Description: 跳转到公司页面 <br>
	 * @Author: wangwenbin <br>
	 * @Date: 2016年12月1日 <br>
	 * @Time: 下午9:55:39 <br>
	 * @return
	 * @return ModelAndView <br>
	 * @throws
	 */
	@RequestMapping("/toCompany")
    public ModelAndView toCompany() {
    	ModelAndView model = new ModelAndView ( "/login/editCompany");
    	return model;
    }
}
