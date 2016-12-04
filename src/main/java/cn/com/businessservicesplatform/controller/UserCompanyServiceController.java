package cn.com.businessservicesplatform.controller;

import cn.com.businessservicesplatform.common.constants.BaseConfigTypeEnum;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
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
				}
			}

		}


		model.addObject("serTypeList", serTypeList);
		model.addObject("voList", voList);
		return model;
	}


//	public static void main(String[] args){
//		String showName = "13";
//		showName = showName.substring(3);
//
//		System.out.print("***"+showName);
//	}
	
	/**
	 * 发布服务
	 * @param request
	 * @return
	 */
	@RequestMapping("/toFabuService")
	@ResponseBody
	protected Map<String,Object> fabuServ(HttpServletRequest request) {

		Map<String,Object> map = new HashMap<String, Object>();
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
			map.put("msg","发布成功");
		}
		return map;
	}
	
	
}
