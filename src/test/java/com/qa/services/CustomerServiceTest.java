package com.qa.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.persistence.dao.Dao;
import com.qa.persistence.domain.Customer;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
	@Mock
	private Dao<Customer> customerDao;
	
	@InjectMocks
	private CustomerServices customerServices;
	
	Customer customer = new Customer();
	
	@Test
	public void customerServicesCreate() {
		Customer customer = new Customer(1L,"Tapiwa" , "Tiyemba");
		customerServices.create(customer);
		Mockito.verify(customerDao, Mockito.times(1)).create(customer);
	}
	
	@Test
	public void customerServicesRead() {
		customerServices.readAll();
		Mockito.verify(customerDao, Mockito.times(1)).readAll();
	}
	
	@Test
	public void customerServicesUpdate() {
		Customer customer = new Customer(1,"chris", "perrins");
		customerServices.update(1,customer);
		Mockito.verify(customerDao, Mockito.times(1)).update(1,customer);
	}
	
	@Test
	public void customerServicesDelete() {
		customerServices.delete(customer);
		Mockito.verify(customerDao, Mockito.times(1)).delete(customer);
	}
}

