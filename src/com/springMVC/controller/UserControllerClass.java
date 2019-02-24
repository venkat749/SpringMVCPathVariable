package com.springMVC.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class UserControllerClass {

	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView readMe() {
		ModelAndView model = new ModelAndView("userPage");
		model.addObject("userMessage","Welcome All to the Spring MVC World");
		return model;
	}
	
	@RequestMapping(value = "/{userName}/{age}", method = RequestMethod.GET)
	public ModelAndView readMe(@PathVariable("userName")String name, @PathVariable("age")int age) {
		ModelAndView model = new ModelAndView("userPage");
		model.addObject("userMessage","Hello "+name+". Your age is "+age);
		return model;
	}
	
	@RequestMapping(value = "/{username}/{class}/{subject}/{mark}", method = RequestMethod.GET)
	public ModelAndView readMeOtherWay(@PathVariable Map<String,String> pathVars) {
		
		String user = pathVars.get("username");
		String className = pathVars.get("class");
		String subject = pathVars.get("subject");
		String mark = pathVars.get("mark");
		
		ModelAndView model = new ModelAndView("userPage");
		model.addObject("userMessage","UserName : "+user +"\n Class : "+className+"\n Subject : "+subject+"\n Mark : "+mark);
		return model;
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView readMe(@RequestParam Map<String,String> reqParams) {
		
		String name = reqParams.get("name");
		String age = reqParams.get("age");
		ModelAndView model = new ModelAndView("userPage");
		model.addObject("userMessage","Hello "+name+". Your age is "+age);
		return model;
	}
	
}
