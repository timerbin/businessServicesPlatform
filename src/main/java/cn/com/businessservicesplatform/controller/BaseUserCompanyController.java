package cn.com.businessservicesplatform.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
@Controller
@RequestMapping("/ss")
public class BaseUserCompanyController extends BaseController{

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
    public ModelAndView toCompany() {
    	ModelAndView model = new ModelAndView ( "/login/editCompany");
    	return model;
    }
	@RequestMapping("/toUp")
    public ModelAndView toUp() {
    	ModelAndView model = new ModelAndView ( "/company/uploadFrame");
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
	public ModelAndView uploadPic(HttpServletRequest request, String jsonp, @RequestParam(value="pic") MultipartFile pic,String itemPicParam) {
//	@RequestMapping(value = "/upload", method = { RequestMethod.POST })
//	public ModelAndView upActivitySpecUrl(MultipartFile logoImg) {
		ModelAndView modelAndView = new ModelAndView("/company/uploadFrame");
		if (null == pic) {
			modelAndView.addObject("msg", "请重新选择上传图片");
			return modelAndView;
		}
		try {
			if(pic.getSize() > 2097152){
				modelAndView.addObject("msg", "请重新选择上传图片:图片最大支持2M大小");
				return modelAndView;
			}
//			BufferedImage buff = ImageIO.read(logoImg.getInputStream());
//			 //判断图片大小
//			if (buff.getWidth() != 120) {
//				modelAndView.addObject("msg", "请重新选择上传图片:图片宽度不符合标准");
//				return modelAndView;
//			}
//			if (buff.getHeight() != 120) {
//				modelAndView.addObject("msg", "请重新选择上传图片：图片高度不符合标准");
//				return modelAndView;
//			}
//			UploadRet4FDFS uploadResult = uploadFile(logoImg,path);
//			if (!StringUtils.isBlank(uploadResult.getResult()) && !StringUtils.isBlank(uploadResult.getUrl())) {
//				modelAndView.addObject("shopLogoUrl", uploadResult.getUrl());
//			} else {
//				modelAndView.addObject("msg", "上传图片信息失败");
//			}
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView.addObject("msg", "修改活动车型主图信息失败：执行修改异常");
			log.error("修改活动车型主图信息失败：执行修改异常", e);
		}
		return modelAndView;
	}
	

//	private UploadRet4FDFS uploadFile(MultipartFile activityUrl,String path) {
//		UploadRet4FDFS result = null;
//		File localTmpFile = null;
//		try {
//			// 将上传的文件保存到本地
//			localTmpFile = saveToLocal(activityUrl,path);
//			ImageFormat imageFormat = ImageValidator.analyzeFormat(localTmpFile);
//			if (ImageFormat.unkown.equals(imageFormat)) {
//				StringBuilder supportFormatDescr = new StringBuilder();
//				// 生成错误提示文案
//				supportFormatDescr.append("请上传图片文件,目前支持的格式:");
//				ImageFormat[] supportFormats = ImageFormat.values();
//				for (ImageFormat supportFormat : supportFormats) {
//					if (!ImageFormat.unkown.equals(supportFormat)) {
//						supportFormatDescr.append(supportFormat.toString());
//						supportFormatDescr.append(",");
//					}
//				}
//				supportFormatDescr.deleteCharAt(supportFormatDescr.length() - 1);
//				throw new IllegalStateException(supportFormatDescr.toString());
//			}
//			String token = UploadUtil4FDFS.getToken();
//			result = UploadUtil4FDFS.upload(localTmpFile, token);
//		} catch (Exception e) {
//			logger.error("图片上传失败", e);
//			result = new UploadRet4FDFS();
//			result.setCode("1");
//			result.setMessage(e.getMessage());
//		} finally {
//			// 清理临时文件
//			FileUtils.deleteQuietly(localTmpFile);
//		}
//		return result;
//	}
//
//	/**
//	 * 将上传的文件写到本地临时存储
//	 * 
//	 * @param uploadFile
//	 *            上传文件
//	 * @return 本地临时文件
//	 * @throws IOException
//	 */
//	private File saveToLocal(MultipartFile uploadFile,String path) throws IOException {
//		File filePathDir = new File(path);
//		if (!filePathDir.exists()) {
//			filePathDir.mkdirs();
//		}
//		String extName = FilenameUtils.getExtension(uploadFile.getOriginalFilename());
//		if (StringUtils.isBlank(extName)) {
//			throw new IllegalStateException("扩展名不能为空");
//		}
//		String mainName = String.format("%d_%04d", System.currentTimeMillis(), new Random().nextInt(9999));
//		File dstFile = new File(String.format("%s/%s.%s", path, mainName, extName.toLowerCase()));
//		InputStream src = null;
//		OutputStream dst = null;
//		try {
//			src = uploadFile.getInputStream();
//			dst = new FileOutputStream(dstFile);
//			IOUtils.copy(src, dst);
//		} finally {
//			IOUtils.closeQuietly(dst);
//			IOUtils.closeQuietly(src);
//		}
//		return dstFile;
//	}
}
