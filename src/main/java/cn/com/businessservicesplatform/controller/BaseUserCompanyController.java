package cn.com.businessservicesplatform.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import cn.com.businessservicesplatform.common.constants.BaseConfigTypeEnum;
import cn.com.businessservicesplatform.common.util.UploadUtil;
import cn.com.businessservicesplatform.model.mysql.BaseConfigData;
import cn.com.businessservicesplatform.model.vo.BaseConfigDataVo;
import cn.com.businessservicesplatform.model.vo.BaseUserCompanyVo;
import cn.com.businessservicesplatform.model.vo.BaseUserVo;
import cn.com.businessservicesplatform.model.vo.UploadResultVo;
import cn.com.businessservicesplatform.service.BaseConfigDataService;
import cn.com.businessservicesplatform.service.BaseUserCompanyService;
@Controller
@RequestMapping("/user")
public class BaseUserCompanyController extends BaseController{

	@Autowired
	BaseConfigDataService baseConfigDataService;
	
	@Autowired
	BaseUserCompanyService baseUserCompanyService;
	
	@Value("${com.upload.file.path}")
	private String uploadFilePath;
	
	
	/**
	 * @Description: 跳转到公司页面 <br>
	 * @Author: wangwenbin <br>
	 * @Date: 2016年12月1日 <br>
	 * @Time: 下午9:55:39 <br>
	 * @return
	 * @return ModelAndView <br>
	 * @throws
	 */
	@RequestMapping("/toCompany")
	public ModelAndView toCompany(HttpServletRequest request) {
		ModelAndView model = new ModelAndView ("/company/editCompany");
		BaseUserVo baseUserVo = this.getUser(request);
		model.addObject("user", baseUserVo);
		if(null == baseUserVo){
			model = new ModelAndView ( "redirect:/login/toLogin.html");
			return model;
		}
		//经营范围
		List<BaseConfigData>  managementList = baseConfigDataService.queryList(new BaseConfigDataVo(BaseConfigTypeEnum.MANAGEMENT.getId()));
		model.addObject("managementList", managementList);
		//企业性质
		List<BaseConfigData> propertyList = baseConfigDataService.queryList(new BaseConfigDataVo(BaseConfigTypeEnum.COMPANY_PROPERTY.getId()));
		model.addObject("propertyList", propertyList);
		//公司信息
		BaseUserCompanyVo resultVo = baseUserCompanyService.getBaseUserAllCompany(baseUserVo.getId());
		model.addObject("vo", resultVo);

		return model;
	}


	/**
	 * 跳转 到企业管理页面
	 * @param request
	 * @return
     */
	@RequestMapping("/toAllCompany")
	public ModelAndView toAllCompany(HttpServletRequest request) {
		ModelAndView model = new ModelAndView ("/admin/grzx_qygl");
		BaseUserVo baseUserVo = this.getUser(request);
		model.addObject("user", baseUserVo);
		if(null == baseUserVo){
			model = new ModelAndView ( "redirect:/login/toLogin.html");
			return model;
		}


		BaseUserCompanyVo companyVo = new BaseUserCompanyVo();
		List<BaseUserCompanyVo> companyVoLst =	baseUserCompanyService.getAllUserCompanys(companyVo);
		model.addObject("companyVoLst",companyVoLst);
		return model;
	}



	@RequestMapping("/saveCompany")
    public ModelAndView saveCompany(HttpServletRequest request,BaseUserCompanyVo baseUserCompanyVo) {
    	ModelAndView model = new ModelAndView ( "/company/editCompany");
    	try {
    		BaseUserVo baseUserVo = this.getUser(request);
        	model.addObject("user", baseUserVo);
        	if(null == baseUserVo){
        		model = new ModelAndView ( "redirect:/login/toLogin.html");
        		return model;
        	}
        	baseUserCompanyVo.setUserId(baseUserVo.getId());
    		List<BaseConfigData>  managementList = baseConfigDataService.queryList(new BaseConfigDataVo(BaseConfigTypeEnum.MANAGEMENT.getId()));
        	model.addObject("managementList", managementList);
        	//企业性质
        	List<BaseConfigData> propertyList = baseConfigDataService.queryList(new BaseConfigDataVo(BaseConfigTypeEnum.COMPANY_PROPERTY.getId()));
        	model.addObject("propertyList", propertyList);
			String checkLogin = check(baseUserCompanyVo);
			if(!StringUtils.isBlank(checkLogin)){
				model.addObject("errorMsg", checkLogin);
				log.error(String.format("BaseUserCompanyController.saveCompany.check.error:%s", checkLogin));
				return model;
			}
			model.addObject("vo", baseUserCompanyVo);
			int result = baseUserCompanyService.insert(baseUserCompanyVo);
			if(result <= 0){
				model.addObject("errorMsg","系统繁忙,请稍后再试");
				log.error("BaseUserCompanyController.saveCompany.save.error:");
				return model;
			}else{
				model = new ModelAndView ( "redirect:/user/toCompany.html");
	    		return model;
			}
		} catch (Exception e) {
			log.error("BaseUserCompanyController.saveCompany.system.error:", e);
		}
    	return model;
    }
	 private String check(BaseUserCompanyVo baseUserCompanyVo){
    	if(null == baseUserCompanyVo){
    		return "企业信息为空";
    	}
    	if(StringUtils.isBlank(baseUserCompanyVo.getCompanyName())){
    		return "企业名称为空";
    	}
    	if(StringUtils.isBlank(baseUserCompanyVo.getCompanyAddress())){
    		return "企业地址为空";
    	}
    	if(StringUtils.isBlank(baseUserCompanyVo.getCompanyContactUser())){
    		return "企业联系人为空";
    	}
    	if(StringUtils.isBlank(baseUserCompanyVo.getCompanyContactTel())){
    		return "联系方式为空";
    	}
    	if(StringUtils.isBlank(baseUserCompanyVo.getCompanyUrl())){
    		return "企业官网地址为空";
    	}
    	if(StringUtils.isBlank(baseUserCompanyVo.getCompanyRegisterMoney())){
    		return "注册资金为空";
    	}
    	if(StringUtils.isBlank(baseUserCompanyVo.getCompanyDirections())){
    		return "企业简介为空";
    	}
    	if(StringUtils.isBlank(baseUserCompanyVo.getCompanyRegisterTimeStr())){
    		return "注册时间为空";
    	}
    	if(StringUtils.isBlank(baseUserCompanyVo.getPicListStr())){
    		return "企业图片为空";
    	}
    	if(null == baseUserCompanyVo.getCompanyScope()){
    		return "经营范围为空";
    	}
    	if(null == baseUserCompanyVo.getCompanyType()){
    		return "企业性质为空";
    	}
    	
    	return null;
	}
	
	 
	@RequestMapping(value = "/getUploadPicForm")
	public ModelAndView getUploadPicForm(HttpServletRequest request, String formId, String inputId, String inputOnChange, String jsonp,String itemPicParam) {
		ModelAndView modelAndView = new ModelAndView("/company/uploadPic");
		modelAndView.addObject("formId", formId);
		modelAndView.addObject("inputId", inputId);
		modelAndView.addObject("inputOnChange", inputOnChange);
		modelAndView.addObject("jsonp", jsonp);
		modelAndView.addObject("itemPicParam",itemPicParam);
		return modelAndView;
	}
	@RequestMapping(value = "/uploadPic")
	public ModelAndView uploadPic(HttpServletRequest request,String jsonp,@RequestParam(value="pic") MultipartFile pic) {
		ModelAndView modelAndView = new ModelAndView("/company/uploadCallBack");
		modelAndView.addObject("callback", jsonp);
		UploadResultVo resultVo = new UploadResultVo(1,"系统异常,请稍后再试");
		if (null == pic) {
			resultVo.setMsg("请重新选择上传图片");
			modelAndView.addObject("data", JSON.toJSONString(resultVo));
			return modelAndView;
		}
		try {
			if(pic.getSize() > 2097152){
				resultVo.setMsg("请重新选择上传图片:图片最大支持2M大小");
				modelAndView.addObject("data", JSON.toJSONString(resultVo));
				return modelAndView;
			}
//			BufferedImage buff = ImageIO.read(logoImg.getInputStream());
//			 //判断图片大小
//			if (buff.getWidth() != 120) {
//				modelAndView.addObject("errorMsg", "请重新选择上传图片:图片宽度不符合标准");
//				return modelAndView;
//			}
//			if (buff.getHeight() != 120) {
//				modelAndView.addObject("errorMsg", "请重新选择上传图片：图片高度不符合标准");
//				return modelAndView;
//			}
			String picPath = UploadUtil.getInstance().saveToLocal(pic,uploadFilePath);
			if (!StringUtils.isBlank(picPath)) {
				resultVo.setReturnCode(1);
				resultVo.setPicPath(picPath);
			}else{
				resultVo.setMsg("上传图片信息失败");
			}
		} catch (Exception e) {
			resultVo.setMsg("上传图片信息失败");
			log.error("上传图片信息失败:系统异常", e);
		}
		modelAndView.addObject("data", JSON.toJSONString(resultVo).replaceAll("\"", "'"));
		return modelAndView;
	}
	
	
}
