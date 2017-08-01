package com.soft.filter;

import java.util.*;

import javax.servlet.http.*;

import org.springframework.web.servlet.handler.*;

/**
 * 登录权限过滤器
 */
public class SecurityFilter extends HandlerInterceptorAdapter {
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		Map<String, Object> user = (Map) request.getSession().getAttribute("user");
		String url = request.getServletPath().toString();
		
		if (user == null) { // 如果未登录直接拦截
			if (!url.equals("/index.html") && !url.equals("/login.html")) { // 只放行登录页和登录操作
				response.sendRedirect(request.getContextPath() + "/index.html");
				return false;
			}
			return super.preHandle(request, response, handler);
		}
		
		//如果已经是登录状态拦截登录操作
		if (url.equals("/login.html")) {
			response.sendRedirect(request.getContextPath() + "/index.html");
			return super.preHandle(request, response, handler);
		}
		
		request.setAttribute("path", request.getContextPath());
		return super.preHandle(request, response, handler);
	}
}