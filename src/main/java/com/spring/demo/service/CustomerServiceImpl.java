package com.spring.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.spring.demo.dao.CustomerDao;
import com.spring.demo.exception.EmailExistException;
import com.spring.demo.exception.PhonenoExistException;
import com.spring.demo.model.Customer;
import com.spring.demo.model.CustomerLog;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	
	@Autowired
	private CustomerDao customerdao;

	@Transactional(propagation=Propagation.REQUIRED)
	public void save(Customer user){
	   
		//this.customerdao.saveLog(new CustomerLog(user.getCustid(), user.getCustname()));
		
		if(customerdao.checkEmail(user.getEmail())) {
			throw new EmailExistException("Email by id : "+user.getEmail()+" Already Exist");
		}else if(customerdao.checkMobNo(user.getPhoneno())) {
			throw new PhonenoExistException("Phone no : "+user.getPhoneno()+" Already Exist");
		}
		
		customerdao.save(user);
		
	}
  
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return this.customerdao.list();
	}
	

}
