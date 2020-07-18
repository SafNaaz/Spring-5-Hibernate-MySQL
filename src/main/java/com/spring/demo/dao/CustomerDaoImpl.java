package com.spring.demo.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
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
	public boolean save(Customer user) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		try {
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			if(e.getCause() instanceof ConstraintViolationException){
				System.out.println("custid already exists");
				return false;
			}
			e.printStackTrace();
			return false;
		}
		session.close();
		return true;
	}

	@Override
	public boolean checkEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		TypedQuery<Customer> query = session
				.createQuery("from Customer as a  where a.email = :email");
		query.setParameter("email", email);
		boolean result = query.getResultList().size() > 0;
		session.close();
		return result;
	}

	@Override
	public boolean checkMobNo(String phoneno) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		TypedQuery<Customer> query = session
				.createQuery("from Customer as a  where a.phoneno = :phoneno");
		query.setParameter("phoneno", phoneno);
		boolean result = query.getResultList().size() > 0;
		session.close();
		return result;
	}

	@Override
	public List<Customer> list() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		TypedQuery<Customer> query = session.createQuery("from Customer");
		List<Customer> result = query.getResultList();
		session.close();
		return result;
	}

	@Override
	public void saveLog(CustomerLog log) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(log);
	}

}
