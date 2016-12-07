package cn.com.businessservicesplatform.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.com.businessservicesplatform.common.constants.BaseConfigTypeEnum;
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
    public ModelAndView baseList(@RequestParam(required = false, value = "page", defaultValue = "1")Integer page,BaseConfigDataVo baseConfigDataVo) {
    	ModelAndView modelView = new ModelAndView ( "/admin/baseConfigManagement");
    	try {
			BasePage basePage = new BasePage(page,10);
			List<BaseConfigData> list = baseConfigDataService.queryPage(basePage, baseConfigDataVo);
			modelView.addObject("basePage", basePage);
			modelView.addObject("vo", baseConfigDataVo);
			modelView.addObject("baseList", list);
			modelView.addObject("typeList", BaseConfigTypeEnum.values());
		} catch (Exception e) {
			e.printStackTrace();
			log.error("BaseConfigController.baseList.is.system.error",e);
		}
    	return modelView;
    }
    @RequestMapping("/updateList")
    public ModelAndView updateList(@RequestParam(required = false, value = "page", defaultValue = "1")Integer page,BaseConfigDataVo baseConfigDataVo) {
    	try {
    		if(null == baseConfigDataVo || baseConfigDataVo.getId() == null){
    			return baseList(page,baseConfigDataVo);
    		}
    		int result = baseConfigDataService.updateStatus(baseConfigDataVo);
    		if(result <0){
    			baseConfigDataVo.setErrorMsg("修改失败");
    		}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("BaseConfigController.baseList.is.system.error",e);
		}
    	return baseList(page,baseConfigDataVo);
    }
    @RequestMapping("/addBase")
    public ModelAndView addBase(@RequestParam(required = false, value = "page", defaultValue = "1")Integer page,BaseConfigDataVo baseConfigDataVo) {
    	try {
    		if(null == baseConfigDataVo  ){
    			return baseList(page,baseConfigDataVo);
    		}
    		if(baseConfigDataVo.getType() == null || StringUtils.isBlank(baseConfigDataVo.getShowName())){
    			baseConfigDataVo.setErrorMsg("参数异常");
    			return baseList(page,baseConfigDataVo);
    		}
    		int result = baseConfigDataService.insert(baseConfigDataVo);
    		if(result <0){
    			baseConfigDataVo.setErrorMsg("添加失败");
    		}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("BaseConfigController.addBase.is.system.error",e);
		}
    	return baseList(page,baseConfigDataVo);
    }
    
    
}
