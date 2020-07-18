package com.spring.demo.dao;

import java.util.List;



import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring.demo.model.Customer;
import com.spring.demo.model.CustomerLog;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Customer user) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(user);
	}

	@Override
	public boolean checkEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		TypedQuery<Customer> query = session
				.createQuery("from Customer as a  where a.email = :email");
		query.setParameter("email", email);
		return query.getResultList().size() > 0;
	}

	@Override
	public boolean checkMobNo(String phoneno) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		TypedQuery<Customer> query = session
				.createQuery("from Customer as a  where a.phoneno = :phoneno");
		query.setParameter("phoneno", phoneno);
		return query.getResultList().size() > 0;
	}

	@Override
	public List<Customer> list() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		TypedQuery<Customer> query = session.createQuery("from Customer");
		return query.getResultList();
	}

	@Override
	public void saveLog(CustomerLog log) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(log);
	}

}
