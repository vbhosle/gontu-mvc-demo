package com.gontuseries.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/annotations")
public class AnnotationBasedController {
	
	@RequestMapping("/welcome/{countryName}/{userName}")
	public ModelAndView welcome(@PathVariable Map<String, String> pathVars) {
		
		String country = pathVars.get("countryName");
		String name = pathVars.get("userName");
		
		ModelAndView modelAndView = new ModelAndView("HelloPage");
		modelAndView.addObject("msg", "Welcome " + name + ". [" + country + "]");
		
		return modelAndView;
	}
}
