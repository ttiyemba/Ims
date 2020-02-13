package com.qa.services;

import java.util.List;

import com.qa.persistence.dao.Dao;
import com.qa.persistence.domain.Customer;

public class CustomerServices implements CrudServices<Customer>, GetCustomerId<Customer>{

	Dao<Customer> customerDao;
	
	public CustomerServices(Dao<Customer> customerDao) {
		this.customerDao = customerDao;
	}
	@Override
	public List<Customer> readAll() {
		return customerDao.readAll();
	}
	@Override
	public void create(Customer customer) {
		customerDao.create(customer);
	}
	@Override
	public void update(long id, Customer t) {
		customerDao.update(id, t);
	}
	@Override
	public void delete(Customer t) {
		customerDao.delete(t);
	}
	@Override
	public long getCustomerId(Customer t) {
	
		return customerDao.getCustomerId(t);
	}

}
