package cn.com.businessservicesplatform.controller;

import cn.com.businessservicesplatform.common.constants.UserCollectHistoryTypeEnum;
import cn.com.businessservicesplatform.model.vo.BaseUserVo;
import cn.com.businessservicesplatform.model.vo.UserCollectHistoryVo;
import cn.com.businessservicesplatform.service.UserCollectHistoryService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/user")
public class UserCollectHistoryController extends BaseController{
	
	private static final Logger log = LoggerFactory.getLogger(UserCollectHistoryController.class);

	@Autowired
	UserCollectHistoryService userCollectHistoryService;
	
    @RequestMapping("/addCollect")
    @ResponseBody
    public Boolean addCollect(HttpServletRequest request,UserCollectHistoryVo userCollectHistoryVo) {
    	Boolean result = Boolean.FALSE;
    	try {
			if(null == userCollectHistoryVo || userCollectHistoryVo.getCompanyId() == null){
				log.error("UserCollectHistoryController.addCollect.is.error:CompanyId.is.null");
				return result;
			}
			BaseUserVo baseUserVo = this.getUser(request);
			userCollectHistoryVo.setUserId(baseUserVo.getId());
			int addResult = userCollectHistoryService.addUserCollectHistory(userCollectHistoryVo);
			if(addResult>0){
				result = Boolean.TRUE;
			}else{
				log.error("UserCollectHistoryController.addCollect.is.error:save.is.error:"+userCollectHistoryVo.getCompanyId());
			}
		} catch (Exception e) {
			log.error("UserCollectHistoryController.addCollect.is.system.error:",e);
		}
    	return result;
    }
    @RequestMapping("/delCollect")
    @ResponseBody
    public Boolean delCollect(HttpServletRequest request,UserCollectHistoryVo userCollectHistoryVo) {
    	Boolean result = Boolean.FALSE;
    	try {
			if(null == userCollectHistoryVo || userCollectHistoryVo.getCompanyId() == null){
				log.error("UserCollectHistoryController.delCollect.is.error:CompanyId.is.null");
				return result;
			}
			BaseUserVo baseUserVo = this.getUser(request);
			userCollectHistoryVo.setUserId(baseUserVo.getId());
			int addResult = userCollectHistoryService.delUserCollectHistory(userCollectHistoryVo);
			if(addResult>0){
				result = Boolean.TRUE;
			}else{
				log.error("UserCollectHistoryController.delCollect.is.error:save.is.error:"+userCollectHistoryVo.getCompanyId());
			}
		} catch (Exception e) {
			log.error("UserCollectHistoryController.delCollect.is.system.error:",e);
		}
    	return result;
    }
    
    @RequestMapping("/collectList")
    public ModelAndView collectList(UserCollectHistoryVo userCollectHistoryVo) {
    	ModelAndView modelAndView = new ModelAndView("/user/collectList");
    	try {
    		if(null == userCollectHistoryVo){
    			userCollectHistoryVo = new UserCollectHistoryVo();
    			userCollectHistoryVo.setType(UserCollectHistoryTypeEnum.SERVICES.getId());
    		}else if(userCollectHistoryVo.getType() == null){
    			userCollectHistoryVo.setType(UserCollectHistoryTypeEnum.SERVICES.getId());
    		}
    		modelAndView.addObject("vo", userCollectHistoryVo);
			List<UserCollectHistoryVo> collectList = userCollectHistoryService.queryList(userCollectHistoryVo);
			modelAndView.addObject("collectList", collectList);
		} catch (Exception e) {
			log.error("UserCollectHistoryController.collectList.is.system.error",e);
		}
    	return modelAndView;
    }
    
}
