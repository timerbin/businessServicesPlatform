package cn.com.businessservicesplatform.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import cn.com.businessservicesplatform.common.constants.BaseConfigTypeEnum;
import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.model.mysql.BaseConfigData;
import cn.com.businessservicesplatform.model.vo.BaseConfigDataVo;
import cn.com.businessservicesplatform.model.vo.BaseUserCompanyVo;
import cn.com.businessservicesplatform.model.vo.BaseUserVo;
import cn.com.businessservicesplatform.model.vo.UserCompanyServiceVo;
import cn.com.businessservicesplatform.service.BaseConfigDataService;
import cn.com.businessservicesplatform.service.BaseUserCompanyService;
import cn.com.businessservicesplatform.service.UserCompanyServiceService;
@Controller
@RequestMapping("/home")
public class HomeController extends BaseController{

	@Autowired
	BaseConfigDataService baseConfigDataService;
	
	@Autowired
	BaseUserCompanyService baseUserCompanyService;
	@Autowired
	UserCompanyServiceService userCompanyServiceService;
	 

	/**
	 * @Description:所有企业 <br>
	 * @Author: wangwenbin <br>
	 * @Date: 2016年12月1日 <br>
	 * @Time: 下午9:55:39 <br>
	 * @return
	 * @return ModelAndView <br>
	 * @throws
	 */
	@RequestMapping("/allCompany")
    public ModelAndView allCompany(Integer page,HttpServletRequest request,BaseUserCompanyVo baseUserCompanyVo) {
    	ModelAndView model = new ModelAndView ("/company/allCompany");
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
	@RequestMapping("/allService")
    public ModelAndView allService(Integer page,HttpServletRequest request,UserCompanyServiceVo userCompanyServiceVo) {
    	ModelAndView model = new ModelAndView ("/company/allService");
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
			
			List<UserCompanyServiceVo> likeServiceList = userCompanyServiceService.queryLikeList();
			//公司信息
			model.addObject("likeServiceList", likeServiceList);
			
			model.addObject("basePage", basePage);
			
		} catch (Exception e) {
			log.error("HomeController.allService.is.system.error",e);
		}
    	return model;
    }
	
}
