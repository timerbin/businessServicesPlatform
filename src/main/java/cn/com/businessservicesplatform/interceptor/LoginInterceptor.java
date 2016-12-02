package cn.com.businessservicesplatform.interceptor;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.com.businessservicesplatform.common.util.CookieUtil;
import cn.com.businessservicesplatform.model.mysql.BaseUser;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	    throws Exception {
		try {
			String requestUrl = request.getRequestURL().toString();
			/***优先Session 中取值**/
			BaseUser baseUser = CookieUtil.getSession(request);
			if(null == baseUser || baseUser.getId() == null){
				/***其次cookie 中取值**/
				baseUser = CookieUtil.getCookieUser(request);
				if(null == baseUser || baseUser.getId() == null){
					StringBuffer url = new StringBuffer("/login/toLogin.html");
					if(!StringUtils.isBlank(requestUrl)){
						url.append("?callbackUrl=" + URLEncoder.encode(requestUrl,"UTF-8"));
					}
					response.sendRedirect(url.toString());
					return Boolean.FALSE;
				}else{
					return Boolean.TRUE;
				}
			}else{
				return Boolean.TRUE;
			}
		} catch (Exception e) {
			String requestUrl = request.getRequestURL().toString();
			StringBuffer url = new StringBuffer("/login/toLogin.html");
			if(!StringUtils.isBlank(requestUrl)){
				url.append("?callbackUrl=" + URLEncoder.encode(requestUrl,"UTF-8"));
			}
			response.sendRedirect(url.toString());
			log.error("LoginInterceptor.preHandle.is.error",e);
			return Boolean.FALSE;
		}
	}

	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
	}

	@Override
	public void afterCompletion(
			HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
