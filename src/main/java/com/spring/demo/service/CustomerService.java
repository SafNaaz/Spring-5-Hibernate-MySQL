package com.spring.demo.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.spring.demo.model.Customer;
@Transactional
public interface CustomerService {
   void save(Customer user) ;
 
  List<Customer> getAllCustomers();
}