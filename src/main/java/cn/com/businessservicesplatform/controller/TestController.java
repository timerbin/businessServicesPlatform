package cn.com.businessservicesplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/shop")
public class TestController extends BaseController{

    @RequestMapping("/index")
    @ResponseBody
    public String index(HttpServletRequest request) {
    	return  "1234";
    }
    
    @RequestMapping("/toIndex")
    public ModelAndView    toIndex(HttpServletRequest request) {
    	
    	return new ModelAndView ( "index");
    }
}
