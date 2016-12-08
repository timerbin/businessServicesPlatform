package cn.com.businessservicesplatform.common.util;

import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.com.businessservicesplatform.model.vo.BaseUserVo;


public class CookieUtil {

	private static final Logger log = LoggerFactory.getLogger(CookieUtil.class);
	
	public static final String DEFAULT_COOKIE_KEY = "services_user_info";
	
	/**
	 * @Description: 获取cookie中用户信息 <br>
	 * @Author: wangwenbin <br>
	 * @Date: 2016年12月1日 <br>
	 * @Time: 下午9:30:27 <br>
	 * @param request
	 * @return void <br>
	 * @throws
	 */
	public static BaseUserVo getCookieUser(HttpServletRequest request){
		BaseUserVo baseUserVo = null;
		try {
			String signStr = getCookie(request,DEFAULT_COOKIE_KEY);
			if(!StringUtils.isBlank(signStr)){
				String dataMsg = DESUtils.decrypt(signStr);
				if(!StringUtils.isBlank(dataMsg) && dataMsg.indexOf("|") >= 0){
					String [] datas =  dataMsg.split("\\|");
					if(datas.length >= 8){
						baseUserVo = new BaseUserVo();
						baseUserVo.setId(makeInt(datas[0]));
						baseUserVo.setUserName(datas[1]);
						baseUserVo.setTrueName(datas[2]);
						baseUserVo.setUserStatus(makeInt(datas[3]));
						baseUserVo.setType(makeInt(datas[4]));
						baseUserVo.setMobilePhoneNumber(datas[5]);
						baseUserVo.setEmail(datas[6]);
						baseUserVo.setUserSex(makeInt(datas[7]));
						baseUserVo.setCompanyId(makeInt(datas[8]));
						baseUserVo.setUserLogo(datas[9]);
					}
				}
			}
		} catch (Exception e) {
			log.error("CookieUtil.getCookieUser.is.error",e);
		}
		
		return baseUserVo;
	}
	private static Integer makeInt(String str){
		Integer result = null;
		if(!StringUtils.isBlank(str)){
			result = Integer.parseInt(str);
		}
		return result;
	}
	
	/**
	 * @Description: 将登录信息写入到cookie <br>
	 * @Author: wangwenbin <br>
	 * @Date: 2016年12月1日 <br>
	 * @Time: 下午9:32:11 <br>
	 * @param request
	 * @param BaseUserVo
	 * @return
	 * @return Boolean <br>
	 * @throws
	 */
	public static Boolean setCookieUser(HttpServletRequest request,HttpServletResponse response,BaseUserVo baseUserVo){
		 if(null == baseUserVo || baseUserVo.getId() == null){
			 return Boolean.FALSE;
		 }
		 try {
			StringBuffer str = new StringBuffer();
			 str.append(baseUserVo.getId()).append("|");
			 str.append(baseUserVo.getUserName()).append("|");
			 str.append(baseUserVo.getTrueName()).append("|");
			 str.append(baseUserVo.getUserStatus()).append("|");
			 str.append(baseUserVo.getType()).append("|");
			 str.append(baseUserVo.getMobilePhoneNumber()).append("|");
			 str.append(baseUserVo.getEmail()).append("|");
			 str.append(baseUserVo.getUserSex()).append("|");
			 str.append(baseUserVo.getCompanyId()).append("|");
			 str.append(baseUserVo.getUserLogo());
			 String sign = DESUtils.encrypt(str.toString());
			 int maxAge = 60*60*24*1;
			 addCookie(response,DEFAULT_COOKIE_KEY,sign,maxAge);
			 setSession(request,baseUserVo);
			 return Boolean.TRUE;
		} catch (Exception e) {
			log.error("CookieUtil.setCookieUser.is.system.error",e);
		}
		return Boolean.FALSE;
	}
	
	/**
	 * session 赋值
	 * @param request
	 * @param BaseUserVo
	 */
	public static void setSession(HttpServletRequest request,BaseUserVo BaseUserVo){
		HttpSession  httpSession = request.getSession();
		httpSession.setAttribute(DEFAULT_COOKIE_KEY, BaseUserVo);
	}
	/**
	 * session取值
	 * @param request
	 * @param BaseUserVo
	 */
	public   static BaseUserVo getSession(HttpServletRequest request){
		BaseUserVo baseUserVo = null ;
		try {
			HttpSession  httpSession = request.getSession();
			baseUserVo = (BaseUserVo) httpSession.getAttribute(CookieUtil.DEFAULT_COOKIE_KEY);
		} catch (Exception e) {
			log.error("CookieUtil.getSession.is.error",e);
		}
		return baseUserVo;
	}
	
	
	/**
	 * 添加cookie
	 * @param response
	 * @param name
	 * @param value
	 * @param maxAge
	 */
	private static void addCookie(HttpServletResponse response, String name, String value,Integer maxAge) {
 		try {
 			name = URLEncoder.encode(name, "UTF-8");
 			value = URLEncoder.encode(value, "UTF-8");
 			Cookie cookie = new Cookie(name, value);
 			if (maxAge != null) {
 				cookie.setMaxAge(maxAge);
 			}
 			cookie.setPath("/");
 	        //cookie.setDomain(".");
 			response.addCookie(cookie);
 		} catch (Exception e) {
 			log.error(String.format("CookieUtil.addCookie.is.system.error:%s-%s",name,value),e);
 		}
	  }
	/**
	 * 获取cookie
	 * @param req
	 * @param name
	 * @return
	 */
	 private static String getCookie(HttpServletRequest req, String name) {
			Cookie[] cookies = req.getCookies();
			if (cookies == null)
				return null;
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals(name)) {
					return cookies[i].getValue();
				}
			}
			return null;
		}
	
}
