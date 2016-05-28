package com.gontuseries.hellocontroller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/greet")
public class HelloController  {
	
	@RequestMapping("/welcome")
	public ModelAndView helloWorld(){
		ModelAndView modelandview = new ModelAndView("HelloPage");
		modelandview.addObject("welcomeMessage","Hi User, How are you, I am Annotation");
		return modelandview;
 	}
	
	//@RequestMapping("/welcome/{userName}/{countryName}")
	@RequestMapping("/welcome/{userName}")
	//public ModelAndView helloWorld2(@PathVariable("userName") String name,@PathVariable("countryName") String country){
	public ModelAndView helloWorld2(@PathVariable("userName") String name){
		ModelAndView modelandview = new ModelAndView("HelloPage");
		modelandview.addObject("welcomeMessage","Welcome "+ name.toUpperCase());
		return modelandview;
 	}

	@RequestMapping("/welcome/{userName}/{countryName}")
	public ModelAndView helloWorld3(@PathVariable Map<String,String> pathVars){
		//when using map place <mvc:annotation-driven/> tag in xml
		String name = pathVars.get("userName");
		String country = pathVars.get("countryName");
		
		
		ModelAndView modelandview = new ModelAndView("HelloPage");
		modelandview.addObject("welcomeMessage","Welcome "+ name.toUpperCase() + " From " +  country.toUpperCase());
		return modelandview;
 	}

	
	
}
