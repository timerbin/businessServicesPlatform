package cn.com.businessservicesplatform.controller;

import cn.com.businessservicesplatform.model.vo.UserLookHistoryVo;
import cn.com.businessservicesplatform.service.UserLookHistoryService;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/shop/look")
public class UserLookHistoryController extends BaseController{
	
	private static final Logger log = LoggerFactory.getLogger(UserLookHistoryController.class);

	@Autowired
	UserLookHistoryService userLookHistoryService;
	
	
	/**
     * @Description: 跳转到浏览记录页面 <br>
     * @Author: wangwenbin <br>
     * @Date: 2016年11月30日 <br>
     * @Time: 下午7:59:17 <br>
     * @return
     * @return ModelAndView <br>
     * @throws
     */
    @RequestMapping("/toLookList")
    public ModelAndView toLookList() {
    	ModelAndView model = new ModelAndView ( "/login/login");
    	
    	return model;
    }
	
	
	@RequestMapping("/addlook")
    @ResponseBody
    public Boolean addlook(UserLookHistoryVo userLookHistoryVo) {
		Boolean result = Boolean.FALSE;
		try {
			String checkResult = checkAdd(userLookHistoryVo);
			if(!StringUtils.isBlank(checkResult)){
				log.error("UserLookHistoryController.add.look.is.error:"+checkResult);
				return result;
			}
			int insertResult = userLookHistoryService.insert(userLookHistoryVo);
			if(insertResult > 0){
				result = Boolean.TRUE;
			}else{
				log.error("UserLookHistoryController.add.look.is.null:"+insertResult);
			}
		} catch (Exception e) {
			log.error("UserLookHistoryController.add.look.is.system.error:",e);
		}
    	return  result;
    }
	private String checkAdd(UserLookHistoryVo userLookHistoryVo){
		if(null == userLookHistoryVo){
			return "参数为空";
		}
		if(null == userLookHistoryVo.getCompanyId()){
			return "企业为空";
		}
		return null;
	}
	
	
	@RequestMapping("/dellook")
    @ResponseBody
    public Boolean dellook(Integer id) {
		Boolean result = Boolean.FALSE;
		try {
			if(null == id){
				log.error("UserLookHistoryController.del.look.is.null:id 为空");
				return result;
			}
			int insertResult = userLookHistoryService.updateDel(id);
			if(insertResult > 0){
				result = Boolean.TRUE;
			}else{
				log.error("UserLookHistoryController.del.look.is.null:"+insertResult);
			}
		} catch (Exception e) {
			log.error("UserLookHistoryController.del.look.is.system.error:",e);
		}
    	return  result;
    }
	
}