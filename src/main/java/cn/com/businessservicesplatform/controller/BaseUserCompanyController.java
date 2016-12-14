package cn.com.businessservicesplatform.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import cn.com.businessservicesplatform.common.constants.RecommendEnum;
import cn.com.businessservicesplatform.common.constants.UserServiceStatuesEnum;
import cn.com.businessservicesplatform.common.util.BasePage;
import cn.com.businessservicesplatform.model.mysql.BaseUser;
import cn.com.businessservicesplatform.model.vo.*;
import cn.com.businessservicesplatform.service.BaseUserService;
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
import cn.com.businessservicesplatform.service.BaseConfigDataService;
import cn.com.businessservicesplatform.service.BaseUserCompanyService;
@Controller
@RequestMapping("/user")
public class BaseUserCompanyController extends BaseController{

	@Autowired
	BaseConfigDataService baseConfigDataService;
	@Autowired
	BaseUserCompanyService baseUserCompanyService;
	@Autowired
	BaseUserService baseUserService;

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
     */
	@RequestMapping("/toAllCompany")
	public ModelAndView toAllCompany(@RequestParam(required = false, value = "page", defaultValue = "1")Integer page, BaseUserCompanyVo baseUserCompanyVo) {
		ModelAndView model = new ModelAndView ("/admin/grzx_qygl");
		BasePage basePage = new BasePage(page,10);
		List<BaseUserCompanyVo> companyVoLst =	baseUserCompanyService.queryPageAll(basePage,baseUserCompanyVo);
		model.addObject("comVoLst",companyVoLst);
		model.addObject("basePage",basePage);
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
			baseUserCompanyVo.setStatus(UserServiceStatuesEnum.NOTPASSVERIFY.getId());
			baseUserCompanyVo.setRecommend(RecommendEnum.UN_RECCOMEND.getId());
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
				model.addObject("errorMsg","企业信息已经录入");
//				model = new ModelAndView ( "redirect:/user/toCompany.html");
//	    		return model;
			}
		} catch (Exception e) {
			model.addObject("errorMsg","系统繁忙,请稍后再试");
			log.error("BaseUserCompanyController.saveCompany.system.error:", e);
		}
    	return model;
    }


	/**
	 * 管理员 --创建企业
	 * @param request
	 * @param baseUserCompanyVo
	 * @return
     */
	@RequestMapping("/createCompany")
	public ModelAndView createCompany(HttpServletRequest request,BaseUserCompanyVo baseUserCompanyVo) {
		ModelAndView model = new ModelAndView ( "/admin/grzx_qygl");
		try {
			BaseUserVo baseUserVo = this.getUser(request);
			model.addObject("user", baseUserVo);
			if(null == baseUserVo){
				model = new ModelAndView ( "redirect:/login/toLogin.html");
				return model;
			}


			/************用户信息************/

//			Integer id;
			String userName = request.getParameter("userName");
			String trueName = request.getParameter("trueName");
			String userPassword  = request.getParameter("userPassword");
			String userPassword2  = request.getParameter("userPassword2");
			String mobilePhoneNumber = request.getParameter("mobilePhoneNumber");
			Integer userStatus = 1;
			String sex = request.getParameter("userSex");
			Integer userSex = sex == null?null:Integer.parseInt(sex);
			String email = request.getParameter("email");
			Integer type = 1;
			Integer age = request.getParameter("age") == null ? null : Integer.parseInt(request.getParameter("age"));


			BaseUser baseUser = new BaseUser();
			baseUser.setAge(age);
			baseUser.setCreateTime(new Date());
			baseUser.setEmail(email);
			baseUser.setMobilePhoneNumber(mobilePhoneNumber);
			baseUser.setRegisterTime(new Date());
			baseUser.setTrueName(trueName);
			baseUser.setUserName(userName);
			baseUser.setType(type);
			baseUser.setUserPassword(userPassword);//别忘了 MD5
			baseUser.setUserSex(userSex);
			baseUser.setUserStatus(userStatus);
			baseUserVo = new BaseUserVo(baseUser);
			baseUserVo.setUserPassword2(userPassword2);

			String checkResult = checkRegisterMsg(baseUserVo);
			if(!StringUtils.isBlank(checkResult)){
				model.addObject("errorMsg", checkResult);
				log.error(String.format("BaseUserCompanyController.createCompany.check.error:%s",checkResult));
				model.addObject("flag","create");
				model.setViewName("redirect:/user/toOneCompany.html");
				return model;
			}
			Integer result = baseUserService.register(baseUserVo);

			if(null != result && result.intValue() > 0){
				log.info("############管理员 创建企业 用户创建成功 新用户" + baseUserVo.getUserName());
			}else{
				log.error(String.format("BaseUserCompanyController.createCompany.save.error  .....Current create user:%s",baseUserVo.getUserName()));
//				model.addObject("flag","create");
				model.setViewName("redirect:/user/toOneCompany.html?flag=create");
				model.addObject("errorMsg", "系统繁忙，请稍后再试");
				return model;
			}


		   /****************end***********/


			/**
			 * 查询新增的用户 ID
			 *
			 */
			baseUserVo.setUserPassword2(baseUserVo.getUserPassword2());
			baseUserVo.setUserPassword(null);
//			baseUserVo.setUserPassword2(MD5Util.getMD5(baseUserVo.getUserPassword2()));
			BaseUser baseUserNew =  baseUserService.findBaseUser(baseUserVo);
			baseUserVo = new BaseUserVo(baseUserNew);


			baseUserCompanyVo.setUserId(baseUserVo.getId());
			List<BaseConfigData>  managementList = baseConfigDataService.queryList(new BaseConfigDataVo(BaseConfigTypeEnum.MANAGEMENT.getId()));
			model.addObject("managementList", managementList);
			//企业性质
			List<BaseConfigData> propertyList = baseConfigDataService.queryList(new BaseConfigDataVo(BaseConfigTypeEnum.COMPANY_PROPERTY.getId()));
			model.addObject("propertyList", propertyList);
			String checkLogin = check(baseUserCompanyVo);
			if(!StringUtils.isBlank(checkLogin)){
				model.addObject("flag","create");
				model.setViewName("redirect:/user/toOneCompany.html");
				model.addObject("errorMsg", checkLogin);
				log.error(String.format("BaseUserCompanyController.saveCompany.check.error:%s", checkLogin));
				return model;
			}

			baseUserCompanyVo.setRecommend(RecommendEnum.RECCOMEND.getId()); //默认不推荐
			baseUserCompanyVo.setStatus(UserServiceStatuesEnum.PASSVERIFY.getId()); //管理员创建企业默认不需要审核 上线状态
			model.addObject("vo", baseUserCompanyVo);
			result = baseUserCompanyService.insert(baseUserCompanyVo);
			if(result <= 0){
				model.addObject("errorMsg","系统繁忙,请稍后再试");
				log.error("BaseUserCompanyController.saveCompany.save.error:");
				return model;
			}else{
				model = new ModelAndView ( "redirect:/user/toAllCompany.html");
				return model;
			}
		} catch (Exception e) {
			model.addObject("flag","create");
			model.setViewName("redirect:/user/toOneCompany.html");
			model.addObject("errorMsg","系统繁忙,请稍后再试");
			log.error("BaseUserCompanyController.saveCompany.system.error:", e);
		}
		return model;
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


	/**
	 * 更新
	 * @param page
	 * @param baseUserCompanyVo
	 * @return
	 */
	@RequestMapping("/updateCompany")
	protected ModelAndView updateCompany(@RequestParam(required = false, value = "page", defaultValue = "1")Integer page,BaseUserCompanyVo baseUserCompanyVo) {

		try {
			if (null == baseUserCompanyVo || baseUserCompanyVo.getId() == null) {
				return toAllCompany(page, baseUserCompanyVo);
			}
			int result = baseUserCompanyService.updateCompany(baseUserCompanyVo);

			if (result < 0) {
				baseUserCompanyVo.setMsg("更新失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("########更新服务失败", e);
			baseUserCompanyVo.setMsg("系统繁忙");
		}
		return toAllCompany(page, baseUserCompanyVo);
	}



	/**
	 * 删除 只是逻辑删除
	 * @param page
	 * @param baseUserCompanyVo
	 * @return
	 */
	@RequestMapping("/toDelCompany")
	protected ModelAndView delCompany(@RequestParam(required = false, value = "page", defaultValue = "1")Integer page,BaseUserCompanyVo baseUserCompanyVo) {

		try {

			baseUserCompanyVo.setCompanyName(null); //屏蔽
			if (null == baseUserCompanyVo || baseUserCompanyVo.getId() == null) {
				return toAllCompany(page, baseUserCompanyVo);
			}
			baseUserCompanyVo.setStatus(UserServiceStatuesEnum.DELETED.getId());
			baseUserCompanyService.deleteCompany(baseUserCompanyVo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("########删除更新企业失败", e);
			baseUserCompanyVo.setMsg("系统繁忙");
		}
		return toAllCompany(page, baseUserCompanyVo);
	}




	/**
	 * 编辑 或 详细 页面跳转
	 * @param request
	 * @return
     */
	@RequestMapping("/toOneCompany")
	public ModelAndView toOneCompany(HttpServletRequest request) {

		String id = request.getParameter("id");
		String flag = request.getParameter("flag");

		ModelAndView model = new ModelAndView ("/admin/grzx_qygl");
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

		if(id != null && !"".equals(id)){
			int i = Integer.parseInt(id);
			//公司信息
			BaseUserCompanyVo resultVo = baseUserCompanyService.getUserAllCompany(i);
			model.addObject("vo", resultVo);
		}




		if("edit".equals(flag)){
			model.setViewName("admin/grzx_editCompany");
		}else if("detail".equals(flag)){
			model.setViewName("admin/grzx_detailCompany");
		}else if("create".equals(flag)){
			model.addObject("errorMsg",request.getParameter("errorMsg"));
			model.setViewName("admin/toCreateCompany");
		}
		return model;
	}



	private String checkRegisterMsg(BaseUserVo baseUserVo){
		if(null == baseUserVo){
			return "注册信息为空";
		}
		if(StringUtils.isBlank(baseUserVo.getUserName())){
			return "用户名为空";
		}
		if(baseUserVo.getUserName().length() < 6){
			return "用户名必须大于6位";
		}
//    	Pattern pattern = Pattern.compile("(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9]).{6,16}");
//		if (!pattern.matcher(baseUserVo.getUserPassword()).matches()  ) {
//			return "密码过于简单";
//		}
		if(StringUtils.isBlank(baseUserVo.getUserPassword())){
			return "密码为空";
		}
		if(baseUserVo.getUserPassword().length() < 6){
			return "密码必须大于6位";
		}
		if(StringUtils.isBlank(baseUserVo.getUserPassword2())){
			return "确认密码为空";
		}
		if(!baseUserVo.getUserPassword().equals(baseUserVo.getUserPassword2())){
			return "密码与确认密码不相同";
		}
		if(StringUtils.isBlank(baseUserVo.getMobilePhoneNumber())){
			return "联系方式为空";
		}
		if(StringUtils.isBlank(baseUserVo.getEmail())){
			return "邮件为空";
		}
		if(null == baseUserVo.getUserSex()){
			return "性别为空";
		}
		BaseUserVo param = new BaseUserVo();
		param.setMobilePhoneNumber(baseUserVo.getMobilePhoneNumber());
		BaseUser baseUser = baseUserService.findBaseUser(param);
		if(null != baseUser && baseUser.getId() != null){
			return "联系方式已经存在";
		}
		param = new BaseUserVo();
		param.setEmail(baseUserVo.getEmail());
		baseUser = baseUserService.findBaseUser(param);
		if(null != baseUser && baseUser.getId() != null){
			return "邮箱已经存在";
		}
		param = new BaseUserVo();
		param.setUserName(baseUserVo.getUserName());
		baseUser = baseUserService.findBaseUser(param);
		if(null != baseUser && baseUser.getId() != null){
			return "用户名已经存在";
		}

		return null;
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

}
