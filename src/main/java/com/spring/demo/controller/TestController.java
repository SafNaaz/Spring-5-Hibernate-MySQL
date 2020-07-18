package com.spring.demo.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.demo.model.User;

@Controller
@RequestMapping(value="/testcontrol")
public class TestController {
	
	   @GetMapping("/formpage")
	   public ModelAndView viewFormPage() {
		   
		   ModelAndView view = new ModelAndView("MyPage");
		   User user = new User();
		   view.addObject("userdetails", user);
		   
		   return view;
		   
	   }
	
	  
	
	   
	   @PostMapping("/viewmypage")
	   public ModelAndView viewMyPage(@ModelAttribute("userdetails") User user) {
		   
		   //System.out.println();
		   
		   ModelAndView view = new ModelAndView("MyResult");
		   view.addObject("id", user.getId());
		   view.addObject("name", user.getName());
		   
		   return view;
		   
	   }
	
	
	

}
