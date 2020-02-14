package com.qa.services;

import java.util.List;

import com.qa.persistence.dao.Dao;
import com.qa.persistence.domain.Customer;

public class CustomerServices implements CrudServices<Customer>, GetCustomerId<Customer>{

	Dao<Customer> customerDao;
	
	public CustomerServices(Dao<Customer> customerDao) {
		this.customerDao = customerDao;
	}
	/**
	 * customer service
	 */
	public List<Customer> readAll() {
		return customerDao.readAll();
	}
	/**
	 * service to create a customer
	 */
	public void create(Customer customer) {
		customerDao.create(customer);
	}
	/**
	 * service to delete a customer
	 */
	public void update(long id, Customer t) {
		customerDao.update(id, t);
	}
	
	public void delete(Customer t) {
		customerDao.delete(t);
	}
	
	public long getCustomerId(Customer t) {
	
		return customerDao.getCustomerId(t);
	}

}
