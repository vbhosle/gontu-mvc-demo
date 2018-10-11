package com.gontuseries.interceptors;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);
		System.out.println("HandlerInterceptorAdapter : Spring MVC called preHandle method for "
				+ request.getRequestURL().toString() + ", today is " + dayOfWeek);
		if(dayOfWeek == calendar.WEDNESDAY) {
			response.getWriter().write("The website is closed on Sunday!");
			return false;
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// this method would be called after Spring MVC executes the request handler method for the request
		System.out.println("HandlerInterceptorAdapter : Spring MVC called postHandle method for "
							+ request.getRequestURL().toString());
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// this method would be called after the reponse object is produced by the view for the request
		System.out.println("HandlerInterceptorAdapter : Spring MVC called afterCompletion method for "
				+ request.getRequestURL().toString());
	}
}
