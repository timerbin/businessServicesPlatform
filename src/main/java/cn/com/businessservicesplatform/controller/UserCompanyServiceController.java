package cn.com.businessservicesplatform.controller;

import cn.com.businessservicesplatform.common.constants.BaseConfigTypeEnum;
import cn.com.businessservicesplatform.common.constants.RecommendEnum;
import cn.com.businessservicesplatform.common.constants.UserServiceStatuesEnum;
import cn.com.businessservicesplatform.model.mysql.BaseConfigData;
import cn.com.businessservicesplatform.model.mysql.UserCompanyService;
import cn.com.businessservicesplatform.model.vo.BaseConfigDataVo;
import cn.com.businessservicesplatform.model.vo.BaseUserVo;
import cn.com.businessservicesplatform.model.vo.UserCompanyServiceVo;
import cn.com.businessservicesplatform.service.BaseConfigDataService;
import cn.com.businessservicesplatform.service.UserCompanyServiceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shopp/userCompanyService")
public class UserCompanyServiceController extends BaseController{
	


	public static final Logger log = LoggerFactory.getLogger(UserCompanyServiceController.class);

	@Autowired
	UserCompanyServiceService userCompanyServiceService;

	@Autowired
	BaseConfigDataService baseConfigDataService;


	/**
	 * 发布服务 跳转
	 * @param request
	 * @return
	 */
	@RequestMapping("/toFabu")
	protected ModelAndView fabu(HttpServletRequest request) {

		ModelAndView model = new ModelAndView ("company/fabufuwu");
		List<BaseConfigData> serTypeList = baseConfigDataService.queryList(new BaseConfigDataVo(BaseConfigTypeEnum.SERVICES_TYPE.getId()));
		model.addObject("serTypeList", serTypeList);
		return model;
	}



	/**
	 * 服务管理 跳转
	 * @param request
	 * @return
	 */
	@RequestMapping("/toServiceManage")
	protected ModelAndView toServiceManage(HttpServletRequest request) {

		ModelAndView model = new ModelAndView ("admin/grzx_fwgl");
		List<BaseConfigData> serTypeList = baseConfigDataService.queryList(new BaseConfigDataVo(BaseConfigTypeEnum.SERVICES_TYPE.getId()));

		UserCompanyServiceVo vo = new UserCompanyServiceVo();
		List<UserCompanyServiceVo> voList = userCompanyServiceService.getAllUserCompanyServices(vo);

		for (UserCompanyServiceVo serVo:voList) {
			for (BaseConfigData configs:serTypeList) {
				if(serVo.getServiceType() == configs.getId()){
					serVo.setServiceTypeStr(configs.getShowName());
					serVo.setStatusStr(UserServiceStatuesEnum.get(serVo.getStatus()).getDes());
					serVo.setRecommendStr(RecommendEnum.get(serVo.getRecommend()).getDes());
				}
			}

		}


		model.addObject("serTypeList", serTypeList);
		model.addObject("voList", voList);
		return model;
	}

	
	/**
	 * 发布服务
	 * @param request
	 * @return
	 */
	@RequestMapping("/toFabuService")
	@ResponseBody
	protected Map<String,Object> fabuServ(HttpServletRequest request) {

		Map<String,Object> map = new HashMap<String, Object>();
		try {


			//判断是否为企业用户
			BaseUserVo vo = getUser(request);

//		if(vo!= null && null == vo.getCompanyId()){
//			//如果为空 则不为企业用户 需要跳转到成为企业用户页面
//			return new ModelAndView ( "company/chengweiqiye.jsp");
//		}else{
//			ModelAndView modelAndView =new ModelAndView();
//			modelAndView.addObject("error","当前不是有效用户");
//		}

			//根据用户ID 查询企业信息

			//发布服务
			UserCompanyServiceVo serVo = new UserCompanyServiceVo();

			String serviceName = request.getParameter("serviceName");
			String serviceType = request.getParameter("serviceType");
			String serviceContactUser = request.getParameter("serviceContactUser");
			String serviceContactTel = request.getParameter("serviceContactTel");
			String serviceDirections = request.getParameter("serviceDirections");

			serVo.setCompanyId(12321);
			serVo.setCreateTime(new Date());
			serVo.setServiceContactTel(serviceContactTel);
			serVo.setServiceContactUser(serviceContactUser);
			serVo.setServiceDirections(serviceDirections);
			serVo.setServiceName(serviceName);
			serVo.setServiceType(BaseConfigTypeEnum.SERVICES_TYPE.getId());
			serVo.setStatus(0);
			serVo.setUserId(123);

			int i = userCompanyServiceService.insert(serVo);
			log.info("#############发布服务 " + i);
			if(i>0){
				map.put("msg","发布成功");
			}else{
				map.put("msg","发布失败");
			}
			return map;

		}catch (Exception e){

			log.error("################### 发布服务失败" + e);
			map.put("msg","系统繁忙，请稍后再试");
			return map;
		}
	}



	/**
	 * 编辑 推荐 不推荐 更新保存
	 * @param request
	 * @return
	 */
	@RequestMapping("/toUpdateService")
	@ResponseBody
	protected Map<String,Object> updateServ(HttpServletRequest request) {

		Map<String,Object> map = new HashMap<String, Object>();
		try {
			String recommend = request.getParameter("recommend");
			String id = request.getParameter("id");
			UserCompanyServiceVo vo = new UserCompanyServiceVo();
			vo.setUserId(Integer.parseInt(id));
			vo.setRecommend(Integer.parseInt(recommend));
			int i = userCompanyServiceService.updateByPrimaryKeySelective(vo);

			if(i>0){
				map.put("msg","成功");
			}else{
				map.put("msg","失败");
			}
			return map;
		}catch (Exception e){
			log.error("################### updateServ 编辑服务失败" + e);
			map.put("msg","系统繁忙，请稍后再试");
			return map;
		}
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
				model.setViewName("admin/editService");
			}else if("detail".equals(flag)){
				model.setViewName("admin/detailService");
			}

			return model;
		}catch (Exception e){
			log.error("################### 查询服务详细失败" + e);
			model.addObject("msg","系统繁忙，请稍后再试");
			return model;
		}
	}
	
	
}
