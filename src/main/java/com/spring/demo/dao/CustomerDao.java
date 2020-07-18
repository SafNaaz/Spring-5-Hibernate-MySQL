package com.spring.demo.dao;

import java.util.List;

import com.spring.demo.model.Customer;
import com.spring.demo.model.CustomerLog;

public interface CustomerDao {
   boolean save(Customer user);
    List<Customer> list();
    boolean checkMobNo(String phoneno);
    boolean checkEmail(String email);
    
    void saveLog(CustomerLog log);
}