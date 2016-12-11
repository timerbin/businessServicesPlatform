package cn.com.businessservicesplatform.controller;

import cn.com.businessservicesplatform.common.constants.BaseConfigTypeEnum;
import cn.com.businessservicesplatform.common.constants.RecommendEnum;
import cn.com.businessservicesplatform.common.constants.UserServiceStatuesEnum;
import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.model.mysql.BaseConfigData;
import cn.com.businessservicesplatform.model.mysql.UserCompanyService;
import cn.com.businessservicesplatform.model.vo.BaseConfigDataVo;
import cn.com.businessservicesplatform.model.vo.BaseUserCompanyVo;
import cn.com.businessservicesplatform.model.vo.BaseUserVo;
import cn.com.businessservicesplatform.model.vo.UserCompanyServiceVo;
import cn.com.businessservicesplatform.service.BaseConfigDataService;
import cn.com.businessservicesplatform.service.BaseUserCompanyService;
import cn.com.businessservicesplatform.service.UserCompanyServiceService;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserCompanyServiceController extends BaseController{

	public static final Logger log = LoggerFactory.getLogger(UserCompanyServiceController.class);

	@Autowired
	UserCompanyServiceService userCompanyServiceService;

	@Autowired
	BaseConfigDataService baseConfigDataService;
	
	@Autowired
	BaseUserCompanyService baseUserCompanyService;



	/**
	 * 发布服务 跳转
	 * @param request
	 * @return
	 */
	@RequestMapping("/toPushService")
	protected ModelAndView toSaveService(HttpServletRequest request) {
		ModelAndView model = new ModelAndView ("/company/fabufuwu");
		try {

			BaseUserVo baseUserVo = getUser(request);
			model.addObject("user", baseUserVo);
			if(null == baseUserVo){
				model = new ModelAndView ( "redirect:/login/toLogin.html");
				return model;
			}

			//判断是否为企业用户
			BaseUserCompanyVo vo  = baseUserCompanyService.getBaseUserAllCompany(baseUserVo.getId());
			if(vo != null){
				List<BaseConfigData> serTypeList = baseConfigDataService.queryList(new BaseConfigDataVo(BaseConfigTypeEnum.SERVICES_TYPE.getId()));
				model.addObject("serTypeList", serTypeList);
			}else{
				//跳转到成为企业页面
				model.addObject("errorMsg","成为企业后才能发布服务，请填写资料");
				model = new ModelAndView ("company/editCompany");
			}


		}catch (Exception e){

			log.error("############ 发布服务跳转异常 ",e);
			model.addObject("errorMsg","系统繁忙请稍后再试");
//			model = new ModelAndView ("company/fabufuwu");
		}


		return model;
	}



	/**
	 * 服务管理 跳转
	 * @param
	 * @return
	 */
	@RequestMapping("/toServiceManage")
	protected ModelAndView toServiceManage(@RequestParam(required = false, value = "page", defaultValue = "1")Integer page, UserCompanyServiceVo userCompanyServiceVo) {

		ModelAndView model = new ModelAndView ("admin/grzx_fwgl");
		try {

			List<BaseConfigData> serTypeList = baseConfigDataService.queryList(new BaseConfigDataVo(BaseConfigTypeEnum.SERVICES_TYPE.getId()));
			if(page == null){
                page =1;
            }
            BasePage basePage = new BasePage(page,10);
			List<UserCompanyServiceVo> voList = userCompanyServiceService.queryPage(basePage,userCompanyServiceVo);

			for (UserCompanyServiceVo vo:voList) {
				for (BaseConfigData config:serTypeList) {
					if(vo.getServiceType() == config.getId()){
						vo.setServiceTypeStr(config.getShowName());
					}
				}

			}


			model.addObject("basePage",basePage);
			model.addObject("serTypeList", serTypeList);
			model.addObject("voList", voList);
		}catch (Exception e){
			e.printStackTrace();
			log.error("###########服务管理 分页查询错误",e);

		}

		return model;
	}

	
	/**
	 * 发布服务 保存
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveService")
	protected ModelAndView saveService(HttpServletRequest request,UserCompanyServiceVo serVo) {
		ModelAndView model = new ModelAndView ("/company/fabufuwu");
		try {

			BaseUserVo baseUserVo = getUser(request);
			model.addObject("user", baseUserVo);
			if(null == baseUserVo){
				model = new ModelAndView ( "redirect:/login/toLogin.html");
				return model;
			}

			List<BaseConfigData> serTypeList = baseConfigDataService.queryList(new BaseConfigDataVo(BaseConfigTypeEnum.SERVICES_TYPE.getId()));
			model.addObject("serTypeList", serTypeList);
			model.addObject("vo", serVo);
			String checkLogin = check(serVo);
			if(!StringUtils.isBlank(checkLogin)){
				model.addObject("errorMsg", checkLogin);
				log.error(String.format("UserCompanyServiceController.saveService.check.error:%s", checkLogin));
				return model;
			}
			serVo.setCompanyId(baseUserVo.getCompanyId());
			serVo.setUserId(baseUserVo.getId());
			//发布服务
			int result = userCompanyServiceService.insert(serVo);
			if(result <= 0){
				if(result == -2){
					model.addObject("errorMsg","服务名称已经存在,不可以重复发布");
					log.error("UserCompanyServiceController.saveService.save.error:");
					return model;
				}
				model.addObject("errorMsg","系统繁忙,请稍后再试");
				log.error("UserCompanyServiceController.saveService.save.error:");
				return model;
			}else{
				model = new ModelAndView ( "redirect:/user/toCompany.html");
	    		return model;
			}
		}catch (Exception e){
			model.addObject("errorMsg","系统繁忙,请稍后再试");
			log.error("BaseUserCompanyController.saveCompany.system.error:", e);
		}
		return model;
	}
	 private String check(UserCompanyServiceVo userCompanyServiceVo){
	    	if(null == userCompanyServiceVo){
	    		return "服务信息为空";
	    	}
	    	if(StringUtils.isBlank(userCompanyServiceVo.getServiceName())){
	    		return "服务名称为空";
	    	}
	    	if(StringUtils.isBlank(userCompanyServiceVo.getServiceContactTel())){
	    		return "服务联系方式为空";
	    	}
	    	if(StringUtils.isBlank(userCompanyServiceVo.getServiceContactUser())){
	    		return "服务联系人为空";
	    	}
	    	if(StringUtils.isBlank(userCompanyServiceVo.getPicUrl())){
	    		return "服务图片为空";
	    	}
	    	if(null == userCompanyServiceVo.getServiceType()){
	    		return "服务类型为空";
	    	}
	    	if(StringUtils.isBlank(userCompanyServiceVo.getServiceDirections())){
	    		return "服务简介为空";
	    	}
	    	UserCompanyServiceVo queryVo = new UserCompanyServiceVo();
	    	queryVo.setServiceType(userCompanyServiceVo.getServiceType());
	    	queryVo.setServiceName(userCompanyServiceVo.getServiceName());
	    	UserCompanyServiceVo resulstVo = userCompanyServiceService.fetchCompanyService(queryVo);
	    	if(null != resulstVo){
	    		return "服务名称已经存在,不可以重复发布";
	    	}
	    	return null;
		}



	/**
	 * 编辑 更新保存
	 * @param request
	 * @return
	 */
	@RequestMapping("/toUpdateEditService")
	protected ModelAndView updateEditServ(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();

		String errMsg = "";
		String serType = request.getParameter("serviceTypeEdit");
		int serTypeInt = 0;
		if(serType != null && !"".equals(serType)){
			serTypeInt = Integer.parseInt(serType);
		}else{
			errMsg = "服务类型为空";
            model.addObject("msg",errMsg);
			return model;
		}
		//校验
		UserCompanyServiceVo voSer = new UserCompanyServiceVo();
		voSer.setServiceName(request.getParameter("serviceName"));
		voSer.setServiceContactTel(request.getParameter("fwLxfsEdit"));
		voSer.setServiceContactUser(request.getParameter("fwLxrEdit"));
		voSer.setPicUrl(request.getParameter("id"));
		voSer.setServiceType(serTypeInt);
		voSer.setServiceDirections(request.getParameter("fwJsEdit"));

		errMsg = this.check(voSer);
        model.addObject("msg",errMsg);



		try {
			String recommend = request.getParameter("recommend");
			String id = request.getParameter("id");
			voSer = new UserCompanyServiceVo();
			voSer.setUserId(Integer.parseInt(id));
			voSer.setRecommend(Integer.parseInt(recommend));
			int i = userCompanyServiceService.updateByPrimaryKeySelective(voSer);

			if(i<0){
                model.addObject("msg","失败");
			}
			return model;
		}catch (Exception e){
			log.error("################### updateServ 推荐不推荐 服务失败" + e);
            model.addObject("msg","系统繁忙，请稍后再试");
			return model;
		}
	}


	/**
	 * 推荐 更新保存
	 * @param
	 * @return
	 */
	@RequestMapping("/toUpdateService")
	protected ModelAndView updateServ(@RequestParam(required = false, value = "page", defaultValue = "1")Integer page,UserCompanyServiceVo userCompanyServiceVo) {

		try {
			if(null == userCompanyServiceVo || userCompanyServiceVo.getId() == null){
				return toServiceManage(page,userCompanyServiceVo);
			}
			int result = userCompanyServiceService.updateByPrimaryKeySelective(userCompanyServiceVo);

			if(result <0){
				userCompanyServiceVo.setMsg("修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("########更新服务失败",e);
		}
		return toServiceManage(page,userCompanyServiceVo);






//		ModelAndView modle = new ModelAndView("admin/grzx_fwgl");
//		Map<String,Object> map = new HashMap<String, Object>();
//		try {
//			String recommend = request.getParameter("tuijianflag");
//			String id = request.getParameter("id");
//			UserCompanyServiceVo vo = new UserCompanyServiceVo();
//			vo.setId(Integer.parseInt(id));
//			vo.setRecommend(Integer.parseInt(recommend));
//			int i = userCompanyServiceService.updateByPrimaryKeySelective(vo);
//
//			if(i>0){
//				modle.addObject("msg","成功");
//			}else{
//				modle.addObject("msg","失败");
//			}
//			return modle;
//		}catch (Exception e){
//			log.error("################### updateServ 推荐不推荐 服务失败" + e);
//			modle.addObject("errorMsg","系统繁忙，请稍后再试");
//			return modle;
//		}
	}


	/**
	 * 删除
	 * @param request
	 * @return
	 */
	@RequestMapping("/toDelService")
	@ResponseBody
	protected ModelAndView delServ(HttpServletRequest request) {

		ModelAndView model = new ModelAndView ("admin/grzx_fwgl");
		try {
			String id = request.getParameter("id");

			if(id != null && !"".equals(id)){
				int idInt = Integer.parseInt(id);
				int i = userCompanyServiceService.delCompanyServiceByid(idInt);
				if(i != 0){
					model.addObject("msg","删除成功");
				}else{
					model.addObject("msg","删除失败");
				}
			}else{
				model.addObject("msg","删除失败,无效的ID");
			}

			return model;
		}catch (Exception e){
			log.error("################### 删除服务失败" + e);
			model.addObject("msg","系统繁忙，请稍后再试");
			return model;
		}
	}


	/**
	 * 编辑 详细 根据ID 查询 跳转
	 * @param request
	 * @return
	 */
	@RequestMapping("/toFindService")
	@ResponseBody
	protected ModelAndView findServ(HttpServletRequest request) {

		ModelAndView model = new ModelAndView ("admin/grzx_fwgl");
		try {

			List<BaseConfigData> serTypeList = baseConfigDataService.queryList(new BaseConfigDataVo(BaseConfigTypeEnum.SERVICES_TYPE.getId()));
			model.addObject("typeLst",serTypeList);

			String id = request.getParameter("id");
			String flag = request.getParameter("flag");

			UserCompanyServiceVo userCompanyServiceVo =	userCompanyServiceService.getAllService(Integer.parseInt(id));

			model.addObject("serVo",userCompanyServiceVo);

			if("edit".equals(flag)){
				model.setViewName("admin/toEditService");
			}else if("detail".equals(flag)){
				model.setViewName("admin/toDetailService");
			}

			return model;
		}catch (Exception e){
			log.error("################### 查询服务详细失败" + e);
			model.addObject("msg","系统繁忙，请稍后再试");
			return model;
		}
	}
	/**
	 * 管理员发布服务
	 * @param request
	 * @return
	 */
	@RequestMapping("/toAdminAddService")
	protected ModelAndView toAdminAddService(HttpServletRequest request) {
		ModelAndView model = new ModelAndView ("/admin/adminAddService");
		try {
			List<BaseConfigData> serTypeList = baseConfigDataService.queryList(new BaseConfigDataVo(BaseConfigTypeEnum.SERVICES_TYPE.getId()));
			model.addObject("serTypeList", serTypeList);
			BaseUserCompanyVo vo = new BaseUserCompanyVo();
			List<BaseUserCompanyVo> comanyList = baseUserCompanyService.queryAllList(vo);
			model.addObject("comanyList", comanyList);
		} catch (Exception e) {
			log.error("toAdminAddService.is.system.error",e);
		}
		return model;
	}
	
	/**
	 * 管理员发布服务
	 * @param request
	 * @return
	 */
	@RequestMapping("/doAdminAddService")
	protected ModelAndView doAdminAddService(HttpServletRequest request,UserCompanyServiceVo serVo) {
		ModelAndView model = new ModelAndView ("/admin/adminAddService");
		try {
			//判断是否为企业用户
			BaseUserVo baseUserVo = getUser(request);
			model.addObject("user", baseUserVo);
			if(null == baseUserVo){
				model = new ModelAndView ( "redirect:/login/toLogin.html");
				return model;
			}
			List<BaseConfigData> serTypeList = baseConfigDataService.queryList(new BaseConfigDataVo(BaseConfigTypeEnum.SERVICES_TYPE.getId()));
			model.addObject("serTypeList", serTypeList);
			model.addObject("vo", serVo);
			BaseUserCompanyVo vo = new BaseUserCompanyVo();
			List<BaseUserCompanyVo> comanyList = baseUserCompanyService.queryAllList(vo);
			model.addObject("comanyList", comanyList);
			String checkLogin = checkService(serVo);
			if(!StringUtils.isBlank(checkLogin)){
				model.addObject("errorMsg", checkLogin);
				log.error(String.format("UserCompanyServiceController.doAdminAddService.check.error:%s", checkLogin));
				return model;
			}
			//发布服务
			int result = userCompanyServiceService.insert(serVo);
			if(result <= 0){
				if(result == -2){
					model.addObject("errorMsg","服务名称已经存在,不可以重复发布");
					log.error("UserCompanyServiceController.doAdminAddService.save.error:");
					return model;
				}
				model.addObject("errorMsg","系统繁忙,请稍后再试");
				log.error("UserCompanyServiceController.doAdminAddService.save.error:");
				return model;
			}else{
				model = new ModelAndView ( "redirect:/user/toServiceManage.html");
	    		return model;
			}
		}catch (Exception e){
			model.addObject("errorMsg","系统繁忙,请稍后再试");
			log.error("BaseUserCompanyController.doAdminAddService.system.error:", e);
		}
		return model;
	}
	
	 private String checkService(UserCompanyServiceVo userCompanyServiceVo){
	    	
		 String result = check(userCompanyServiceVo);
		 if(!StringUtils.isBlank(result)){
    		return result;
    	 }
		 if(null == userCompanyServiceVo.getCompanyId()){
			 return "请重新选择公司信息";
		 }
		 if(null == userCompanyServiceVo.getUserId()){
			 return "请重新选择公司信息";
		 }
	    	return null;
	}
	
	
}
