package cn.com.businessservicesplatform.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import cn.com.businessservicesplatform.common.constants.BaseConfigTypeEnum;
import cn.com.businessservicesplatform.common.constants.RecommendEnum;
import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.model.mysql.BaseConfigData;
import cn.com.businessservicesplatform.model.vo.BaseConfigDataVo;
import cn.com.businessservicesplatform.model.vo.BaseUserCompanyVo;
import cn.com.businessservicesplatform.model.vo.BaseUserVo;
import cn.com.businessservicesplatform.model.vo.UserCompanyServiceVo;
import cn.com.businessservicesplatform.model.vo.UserServiceCommentVo;
import cn.com.businessservicesplatform.service.BaseConfigDataService;
import cn.com.businessservicesplatform.service.BaseUserCompanyService;
import cn.com.businessservicesplatform.service.UserCompanyServiceService;
import cn.com.businessservicesplatform.service.UserServiceCommentService;
@Controller
@RequestMapping("")
public class HomeController extends BaseController{

	@Autowired
	BaseConfigDataService baseConfigDataService;
	
	@Autowired
	BaseUserCompanyService baseUserCompanyService;
	@Autowired
	UserCompanyServiceService userCompanyServiceService;
	@Autowired
	UserServiceCommentService userServiceCommentService;
	 
	@RequestMapping("/")
    public ModelAndView homeIndex(HttpServletRequest request,BaseUserCompanyVo baseUserCompanyVo) {
		return home(request,baseUserCompanyVo);
	}

	/**
	 * @Description:所有企业 <br>
	 * @Author: wangwenbin <br>
	 * @Date: 2016年12月1日 <br>
	 * @Time: 下午9:55:39 <br>
	 * @return
	 * @return ModelAndView <br>
	 * @throws
	 */
	@RequestMapping("/home/allCompany")
    public ModelAndView allCompany(@RequestParam(required = false, value = "page", defaultValue = "1")Integer page,HttpServletRequest request,BaseUserCompanyVo baseUserCompanyVo) {
    	ModelAndView model = new ModelAndView ("/home/allCompany");
    	try {
    		model.addObject("queryVo", baseUserCompanyVo);
    		
			BaseUserVo baseUserVo = this.getUser(request);
			
			model.addObject("user", baseUserVo);
			//经营范围
			List<BaseConfigData>  managementList = baseConfigDataService.queryList(new BaseConfigDataVo(BaseConfigTypeEnum.MANAGEMENT.getId()));
			model.addObject("managementList", managementList);
			 
			BasePage basePage = new BasePage(page,10);
			
			List<BaseUserCompanyVo> companyList = baseUserCompanyService.queryPage(basePage, baseUserCompanyVo);
			//公司信息
			model.addObject("companyList", companyList);
			
			model.addObject("basePage", basePage);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("HomeController.allCompany.is.system.error",e);
		}
    	return model;
    }
	/**
	 * @Description:所有服务 <br>
	 * @Author: wangwenbin <br>
	 * @Date: 2016年12月1日 <br>
	 * @Time: 下午9:55:39 <br>
	 * @return
	 * @return ModelAndView <br>
	 * @throws
	 */
	@RequestMapping("/home/allService")
    public ModelAndView allService(@RequestParam(required = false, value = "page", defaultValue = "1")Integer page,HttpServletRequest request,UserCompanyServiceVo userCompanyServiceVo) {
    	ModelAndView model = new ModelAndView ("/home/allService");
    	try {
    		model.addObject("queryVo", userCompanyServiceVo);
    		
			BaseUserVo baseUserVo = this.getUser(request);
			
			model.addObject("user", baseUserVo);
			//经营范围
			List<BaseConfigData>  serviceTypeList = baseConfigDataService.queryList(new BaseConfigDataVo(BaseConfigTypeEnum.SERVICES_TYPE.getId()));
			model.addObject("serviceTypeList", serviceTypeList);
			 
			BasePage basePage = new BasePage(page,10);
			
			List<UserCompanyServiceVo> serviceList = userCompanyServiceService.queryPage(basePage,userCompanyServiceVo);
			//公司信息
			model.addObject("serviceList", serviceList);
			
			List<UserCompanyServiceVo> likeServiceList = userCompanyServiceService.queryLikeList(6);
			//公司信息
			model.addObject("likeServiceList", likeServiceList);
			
			model.addObject("basePage", basePage);
			
		} catch (Exception e) {
			log.error("HomeController.allService.is.system.error",e);
		}
    	return model;
    }
	
	
	/**
	 * @Description:所有企业 <br>
	 * @Author: wangwenbin <br>
	 * @Date: 2016年12月1日 <br>
	 * @Time: 下午9:55:39 <br>
	 * @return
	 * @return ModelAndView <br>
	 * @throws
	 */
	@RequestMapping("/home/homeIndex")
    public ModelAndView home(HttpServletRequest request,BaseUserCompanyVo baseUserCompanyVo) {
    	ModelAndView model = new ModelAndView ("/home/home");
    	try {
    		model.addObject("queryVo", baseUserCompanyVo);
    		
			BaseUserVo baseUserVo = this.getUser(request);
			
			model.addObject("user", baseUserVo);
			baseUserCompanyVo.setRecommend(RecommendEnum.RECCOMEND.getId());
			baseUserCompanyVo.setQueryRows(5);
			List<BaseUserCompanyVo> companyList = baseUserCompanyService.queryList( baseUserCompanyVo);
			//推荐公司
			model.addObject("companyList", companyList);
			
			List<UserCompanyServiceVo> likeServiceList = userCompanyServiceService.queryLikeList(8);
			//猜你喜欢
			model.addObject("likeServiceList", likeServiceList);
			
			UserCompanyServiceVo userCompanyServiceVo = new UserCompanyServiceVo();
			userCompanyServiceVo.setRecommend(RecommendEnum.RECCOMEND.getId());
			userCompanyServiceVo.setQueryRows(5);
			List<UserCompanyServiceVo> serviceList = userCompanyServiceService.queryList(userCompanyServiceVo);
			//推荐服务
			model.addObject("serviceList", serviceList);
			
		} catch (Exception e) {
			log.error("HomeController.allCompany.is.system.error",e);
		}
    	return model;
    }
	
	/**
	 * @Description:服务展示 <br>
	 * @Author: wangwenbin <br>
	 * @Date: 2016年12月1日 <br>
	 * @Time: 下午9:55:39 <br>
	 * @return
	 * @return ModelAndView <br>
	 * @throws
	 */
	@RequestMapping("/home/serviceShow")
    public ModelAndView serviceShow(@RequestParam(required = false, value = "page", defaultValue = "1")Integer page,Integer commentType,HttpServletRequest request,UserCompanyServiceVo userCompanyServiceVo) {
    	ModelAndView model = new ModelAndView ("/home/serviceShow");
    	try {
    		if(null == userCompanyServiceVo || userCompanyServiceVo.getId() == null){
    			model = new ModelAndView ( "redirect:/home/allService.html");
	    		return model;
			}
    		model.addObject("queryVo", userCompanyServiceVo);
			BaseUserVo baseUserVo = this.getUser(request);
			model.addObject("user", baseUserVo);
			//经营范围
			List<BaseConfigData>  serviceTypeList = baseConfigDataService.queryList(new BaseConfigDataVo(BaseConfigTypeEnum.SERVICES_TYPE.getId()));
			model.addObject("serviceTypeList", serviceTypeList);
			 
			//服务信息
			UserCompanyServiceVo  vo = userCompanyServiceService.getAllService(userCompanyServiceVo.getId());
			if(null == vo || vo.getId() == null){
    			model = new ModelAndView ( "redirect:/home/allService.html");
	    		return model;
			}
			
			model.addObject("vo", vo);
			
			List<UserCompanyServiceVo> likeServiceList = userCompanyServiceService.queryLikeList(6);
			model.addObject("likeServiceList", likeServiceList);
			
			//评论信息
			BasePage basePage = new BasePage(page,5);
			UserServiceCommentVo commentParam = new UserServiceCommentVo(userCompanyServiceVo.getId());
			commentParam.setCommentType(commentType);
			List<UserServiceCommentVo> commentList = userServiceCommentService.queryPage(basePage,commentParam);
			model.addObject("commentList", commentList);
			//评论记录信息
			UserServiceCommentVo commentSize = userServiceCommentService.getCommentSize(commentParam);
			model.addObject("commentSize", commentSize);
			model.addObject("basePage", basePage);
			if(null != userCompanyServiceVo.getCode() && userCompanyServiceVo.getCode() > 1){
				if(userCompanyServiceVo.getCode()  == 1002){
					model.addObject("errorMsg", "评论失败:您已经评论");
				}else{
					model.addObject("errorMsg", "评论失败");
				}
			}
		} catch (Exception e) {
			log.error("HomeController.serviceShow.is.system.error",e);
			model = new ModelAndView ( "redirect:/home/allService.html");
    		return model;
		}
    	return model;
    }
	
	
	@RequestMapping("/initMenu")
	@ResponseBody
    public List<BaseConfigData> initMenu() {
		List<BaseConfigData> result = new ArrayList<BaseConfigData>();
		try {
			result = baseConfigDataService.queryList(new BaseConfigDataVo(BaseConfigTypeEnum.SERVICES_TYPE.getId()));
		} catch (Exception e) {
			log.error("initMenu.is.system.error",e);
		}
		return result ;
    }
	
}
