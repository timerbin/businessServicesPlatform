package cn.com.businessservicesplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.model.mysql.BaseConfigData;
import cn.com.businessservicesplatform.model.vo.BaseConfigDataVo;
import cn.com.businessservicesplatform.service.BaseConfigDataService;

import java.util.List;


@Controller
@RequestMapping("/user")
public class BaseConfigController extends BaseController {

	@Autowired
	BaseConfigDataService baseConfigDataService;
    
    @RequestMapping("/baseList")
    public ModelAndView toIndex() {
    	BasePage basePage = new BasePage(1,3);
    	BaseConfigDataVo baseConfigDataVo = new BaseConfigDataVo();
    	baseConfigDataVo.setType(1);
    	List<BaseConfigData> list = baseConfigDataService.queryPage(basePage, baseConfigDataVo);
    	System.err.println(list.size()+"---"+basePage.getPages()+"----"+basePage.getCount());
    	return new ModelAndView ( "index");
    }
}
