package com.spring.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "CUSTOMER_464145")
public class Customer {

	private String custid;
	private String custname;
	private Integer age;
	private String phoneno;
	private String email;
	private String address;

	public Customer() {
		super();
	}

	public Customer(String custid, String custname, Integer age, String phoneno, String email, String address) {
		super();
		this.custid = custid;
		this.custname = custname;
		this.age = age;
		this.phoneno = phoneno;
		this.email = email;
		this.address = address;
	}

	@Id
	@Column(name = "CUSTID")
	@NotEmpty(message = "Custid Can't be empty")
	@Size(message = "{custid.size.invalid}", max = 5, min = 3)
	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	@Column(name = "CUSTNAME")
	@NotEmpty(message = "Custname Can't be empty")
	@Size(message = "{custname.size.invalid}", max = 20, min = 2)
	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	@Column(name = "AGE")
	@NotNull(message = "Age Can't be empty")
	@Range(min = 10, max = 60, message = "{age.range.valid}")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "PHONENO")
	@NotEmpty(message = "Phoneno Can't be empty")
	@Pattern(message = "Invalid Phoneno, should contain 10 digits starting with 7,8 or 9", regexp = "(^$|[0-9]{10})")
	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	@Column(name = "EMAIL")
	@NotEmpty(message = "Email Can't be empty")
	@Email(message = "Invalid Email address")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "ADDRESS")
	@NotEmpty(message = "Address Can't be empty")
	@Size(min = 5, max = 100, message = "{address.size.valid}")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
