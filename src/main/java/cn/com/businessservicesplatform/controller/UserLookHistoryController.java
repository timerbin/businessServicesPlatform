package cn.com.businessservicesplatform.controller;

import cn.com.businessservicesplatform.common.constants.BaseConfigTypeEnum;
import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.common.util.DateUtils;
import cn.com.businessservicesplatform.model.mysql.BaseConfigData;
import cn.com.businessservicesplatform.model.mysql.UserLookHistory;
import cn.com.businessservicesplatform.model.vo.BaseConfigDataVo;
import cn.com.businessservicesplatform.model.vo.BaseUserVo;
import cn.com.businessservicesplatform.model.vo.UserLookHistoryVo;
import cn.com.businessservicesplatform.service.BaseConfigDataService;
import cn.com.businessservicesplatform.service.BaseUserCompanyService;
import cn.com.businessservicesplatform.service.UserCompanyServiceService;
import cn.com.businessservicesplatform.service.UserLookHistoryService;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/user")
public class UserLookHistoryController extends BaseController{
	
	private static final Logger log = LoggerFactory.getLogger(UserLookHistoryController.class);

	@Autowired
	UserLookHistoryService userLookHistoryService;

	@Autowired
	BaseUserCompanyService baseUserCompanyService;

	@Autowired
	UserCompanyServiceService userCompanyServiceService;
	
	@Autowired
	BaseConfigDataService baseConfigDataService;
	
	
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
    public ModelAndView toLookList(@RequestParam(required = false, value = "page", defaultValue = "1")Integer page, UserLookHistoryVo userLookHistoryVo) {
    	ModelAndView model = new ModelAndView ( "/user/lookHistory");

		if(page == null){
			page =1;
		}
        BasePage basePage = new BasePage(page,10);

		if(userLookHistoryVo.getType()!=null && userLookHistoryVo.getType().equals("")){
			userLookHistoryVo.setType(null);
		}
		List<UserLookHistoryVo>  ulhLstHis = userLookHistoryService.queryByPage(basePage,userLookHistoryVo);
		List<UserLookHistoryVo> ulhLst = new ArrayList<UserLookHistoryVo>();
		for (UserLookHistory ulh : ulhLstHis){
			UserLookHistoryVo hVo = new UserLookHistoryVo(ulh);
			ulhLst.add(hVo);
		}
		model.addObject("vo",userLookHistoryVo);
		
		model.addObject("ulhLst",ulhLst);
		List<String> lstStr = userLookHistoryService.queryHisDate();
		model.addObject("dateStr",lstStr);
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
	
	/**
	 * 跳转 统计页面
	 * @param request
	 * @return
     */
	@RequestMapping("/toStatistics")
	public ModelAndView toStatistics(HttpServletRequest request,UserLookHistoryVo userLookHistoryVo) {
		ModelAndView model = new ModelAndView ("/user/statistics");
		try {
			BaseUserVo baseUserVo = this.getUser(request);
			model.addObject("user", baseUserVo);
			if(null == baseUserVo){
				model = new ModelAndView ( "redirect:/login/toLogin.html");
				return model;
			}
			//经营范围
			List<BaseConfigData>  serviceTypeList = baseConfigDataService.queryList(new BaseConfigDataVo(BaseConfigTypeEnum.SERVICES_TYPE.getId()));
			model.addObject("serviceTypeList", serviceTypeList);
			
			String data = DateUtils.getString(new Date(), "yyyy");
			userLookHistoryVo.setBeginTime(data);
			model.addObject("vo",userLookHistoryVo);
			
			model.addObject("init","1");
			
		} catch (Exception e) {
			log.error("UserController.toStatistics.is.system.error",e);
		}
		return model;
	}
	
	@RequestMapping("/queryServiceLook")
	@ResponseBody
    public List<BaseConfigDataVo> queryServiceLook(UserLookHistoryVo userLookHistoryVo) {
		List<BaseConfigDataVo> result = new ArrayList<BaseConfigDataVo>();
		try {
			result = userLookHistoryService.queryServiceLook(userLookHistoryVo);
		} catch (Exception e) {
			log.error("queryServiceLook.is.system.error",e);
		}
		return result ;
    }
}
