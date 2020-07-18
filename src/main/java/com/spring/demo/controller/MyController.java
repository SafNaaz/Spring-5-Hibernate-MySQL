package com.spring.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.demo.model.UserDetails;

@CrossOrigin
@RestController
@RequestMapping(value="/mycontrol")
public class MyController {
	
	   /*
	
	   @GetMapping("/")
	   public ModelAndView sayHello() {
		   
		   ModelAndView mv = new ModelAndView("Test");
		   mv.addObject("userdetails", new UserDetails());
		   return mv;
	   }
	   
	   @PostMapping("/submitdata")
	   public ModelAndView displayData(@ModelAttribute("userdetails")UserDetails userdetails) {
		   
		   ModelAndView mv = new ModelAndView("Display");
		   mv.addObject("display", userdetails);
		   
		   return mv;
	   }*/
	
	  
	  @GetMapping("/data/{id}/")
	  public List<UserDetails> getData(@PathVariable String id)
	  {
		   ArrayList<UserDetails> list = new ArrayList<>();
		 // if(id.equalsIgnoreCase("admin")) {
			  UserDetails ud = new UserDetails();
			  ud.setUsername("Test");
			  ud.setPassword("pwd");
			  list.add(ud);
			  return list;
			  
			  //ResponseEntity<Object> re = new ResponseEntity<Object>(ud, HttpStatus.OK);
			  
			  //return re;
		 // }else {
			//  ResponseEntity<Object> re = new ResponseEntity<Object>("Required data not found", HttpStatus.NOT_FOUND);
			  
			//  return re;
		 // }
		 
	  }
	   
	   
	   
	   
	   

}
