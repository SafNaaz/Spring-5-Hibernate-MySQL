package com.spring.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CUSTOMER_LOG_464145")
public class CustomerLog {

	private String custid;
	private String custname;
	
	
	public CustomerLog() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public CustomerLog(String custid, String custname) {
		super();
		this.custid = custid;
		this.custname = custname;
	}



	@Id
	@Column(name="CUSTID")
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	@Column(name="CUSTNAME")
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	
	
	
		
}
