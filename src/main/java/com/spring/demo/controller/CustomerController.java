package com.spring.demo.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.demo.exception.DuplicateCustidException;
import com.spring.demo.exception.EmailExistException;
import com.spring.demo.exception.PhonenoExistException;
import com.spring.demo.model.Customer;
import com.spring.demo.service.CustomerService;


@Controller
public class CustomerController {
	
	  @Autowired
	  private CustomerService customerservice;
	  
	  
	    @GetMapping("/")
	    public String userForm(Locale locale, Model model) {
	         model.addAttribute("users", customerservice.getAllCustomers());
	        return "editcustomers";
	    }
	  
	    @ModelAttribute("customer")
	    public Customer formBackingObject() {
	        return new Customer();
	    }
	    
	    @PostMapping("/addcustomer")
	    public ModelAndView saveUser(@ModelAttribute("customer") @Valid Customer customer,
	                            BindingResult result, Model model) {
	    	
	    	ModelAndView view = null;
	 
	        if (result.hasErrors()) {
	        	view =new ModelAndView("editcustomers");
	             
	        	
	        	model.addAttribute("users", customerservice.getAllCustomers());
	            // return "editcustomers";
	        	return view;
	        }
	        
	        try {
	      
	            customerservice.save(customer);
	            
	            view =new ModelAndView("editcustomers");
	        	view.addObject("successmessage", "Customer details by Id "+customer.getCustid()+ " Registered successfully");
	        	
	        	
	        	
	        
	        }catch(DuplicateCustidException e) {
	        	view =new ModelAndView("editcustomers");
	        	view.addObject("message", e.getMessage());
	        	//return view;
	        }catch(EmailExistException e) {
	        	e.printStackTrace();
	        	view =new ModelAndView("editcustomers");
	        	view.addObject("message", e.getMessage());
	        	//return view;
	        }catch(PhonenoExistException e) {
	        	view =new ModelAndView("editcustomers");
	        	view.addObject("message", e.getMessage());
	        	//return view;
	        } catch (Throwable e) {
				view =new ModelAndView("editcustomers");
	        	view.addObject("message", "failed to add customer");
			}
	        model.addAttribute("users", customerservice.getAllCustomers());
	   
	       // view = new ModelAndView("redirect:/");
	        return view;
	    }

}
