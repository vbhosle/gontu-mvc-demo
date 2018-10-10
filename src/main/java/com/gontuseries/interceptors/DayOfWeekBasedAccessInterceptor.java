package com.gontuseries.interceptors;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Calendar calendar = Calendar.getInstance();
		int dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);
		System.out.println("In interceptor"+dayOfWeek);
		if(dayOfWeek == calendar.WEDNESDAY) {
			response.getWriter().write("The website is closed on Sunday!");
			return false;
		}
		return true;
	}
}
