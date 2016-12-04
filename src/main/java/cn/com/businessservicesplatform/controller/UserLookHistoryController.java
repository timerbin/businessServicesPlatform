package cn.com.businessservicesplatform.controller;

import cn.com.businessservicesplatform.common.constants.UserLookHistoryTypeEnum;
import cn.com.businessservicesplatform.model.mysql.BaseUserCompany;
import cn.com.businessservicesplatform.model.mysql.UserCompanyService;
import cn.com.businessservicesplatform.model.mysql.UserLookHistory;
import cn.com.businessservicesplatform.model.vo.BaseUserCompanyVo;
import cn.com.businessservicesplatform.model.vo.UserCompanyServiceVo;
import cn.com.businessservicesplatform.model.vo.UserLookHistoryVo;
import cn.com.businessservicesplatform.service.BaseUserCompanyService;
import cn.com.businessservicesplatform.service.UserCompanyServiceService;
import cn.com.businessservicesplatform.service.UserLookHistoryService;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/shopp/look")
public class UserLookHistoryController extends BaseController{
	
	private static final Logger log = LoggerFactory.getLogger(UserLookHistoryController.class);

	@Autowired
	UserLookHistoryService userLookHistoryService;

	@Autowired
	BaseUserCompanyService baseUserCompanyService;

	@Autowired
	UserCompanyServiceService userCompanyServiceService;
	
	
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
    	ModelAndView model = new ModelAndView ( "/user/lookHistory");
		UserLookHistoryVo vo = new UserLookHistoryVo();
		List<UserLookHistory> ulhLstHis =  userLookHistoryService.queryHistroyList(vo);


		//查询企业 浏览历史
		UserLookHistoryVo voCompany = new UserLookHistoryVo();
		voCompany.setType(UserLookHistoryTypeEnum.COMPANY.getId());
		List<UserLookHistory> comLstHis =  userLookHistoryService.queryHistroyList(vo);

		//查询服务 浏览历史
		UserLookHistoryVo voService = new UserLookHistoryVo();
		voService.setType(UserLookHistoryTypeEnum.SERVICES.getId());
		List<UserLookHistory> serLstHis =  userLookHistoryService.queryHistroyList(vo);


		List<UserLookHistoryVo> ulhLst = new ArrayList<UserLookHistoryVo>();
		for (UserLookHistory ulh : ulhLstHis){
			UserLookHistoryVo hVo = new UserLookHistoryVo(ulh.getUserId(),ulh.getServiceId(),ulh.getCompanyId(),ulh.getType());
			ulhLst.add(hVo);
		}



		List<UserLookHistoryVo> ulhLstNew = new ArrayList<UserLookHistoryVo>();
//		List<String> dateStr = new ArrayList<String>();

		BaseUserCompanyVo companyVo = new BaseUserCompanyVo();
		UserCompanyServiceVo usVo = new UserCompanyServiceVo();
		for (UserLookHistoryVo hVo: ulhLst) {

			//获取企业公司
			companyVo.setUserId(hVo.getCompanyId());
			BaseUserCompany bc = baseUserCompanyService.getUserCompany(companyVo);
			hVo.setCompanyName(bc.getCompanyName());
			BaseUserCompanyVo bcVo = new BaseUserCompanyVo(bc);
			hVo.setCompanyPicUrl(bcVo.getPicList().get(0).getCompanyPicUrl());

			//获取服务
			usVo.setUserId(hVo.getServiceId());
			hVo.setServiceName(userCompanyServiceService.fetchCompanyService(usVo).getServiceName());

			ulhLstNew.add(hVo);
		}

		model.addObject("ulhLstNew",ulhLstNew);
		model.addObject("comLstHis",comLstHis);
		model.addObject("serLstHis",serLstHis);

		model.addObject("dateStr",userLookHistoryService.queryHisDate());
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
