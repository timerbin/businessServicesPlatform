package cn.com.businessservicesplatform.controller;

import cn.com.businessservicesplatform.common.util.VerifyCodeUtils;
import org.apache.commons.lang.StringUtils;
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
public class LoginController {


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
    	ModelAndView model = new ModelAndView ( "/login/register");
    	if(!StringUtils.isBlank(callbackUrl)){
    		model.addObject("callbackUrl", callbackUrl);
    	}else{
    		model.addObject("callbackUrl", "");
    	}
    	
    	return model;
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
    	
    	return model;
    }


	/**
	 * 验证码
	 * @Author John
	 * @param request
	 * @param response
     * @return
     */
	@RequestMapping("/genVerifyCode")
	@ResponseBody
	public String genVerifyCode(HttpServletRequest request,HttpServletResponse response) {
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		//生成随机字串
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		//存入会话session
		HttpSession session = request.getSession(true);
		//删除以前的
		session.removeAttribute("verCode");
		session.setAttribute("verCode", verifyCode.toLowerCase());
		//生成图片
		int w = 100, h = 30;
		try {
			VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
		} catch (IOException e) {
			//处理异常
			e.printStackTrace();
		}

		return  verifyCode;
	}
}
