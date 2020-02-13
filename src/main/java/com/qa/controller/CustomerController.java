package com.qa.controller;

import org.apache.log4j.Logger;

import com.qa.persistence.domain.Customer;
import com.qa.services.CrudServices;
import com.qa.services.GetCustomerId;
import com.qa.utils.Utils;

public class CustomerController implements CrudController<Customer>, GetCustomerIdController<Customer>{

	public static final Logger LOGGER = Logger.getLogger(CustomerController.class);
	
	private CrudServices<Customer> customerService;
	private GetCustomerId<Customer> getCustomerId;
	
	public CustomerController(CrudServices<Customer> customerService, GetCustomerId<Customer> getCustomerId ) {
		this.customerService = customerService;
		this.getCustomerId = getCustomerId;
		
	}
	@Override
	public void readAll() {
		for(Customer customer: customerService.readAll()) {
			LOGGER.info(customer.toString());
		}
	}
	@Override

	public void create() {
		LOGGER.info("Please enter a first name");
		String firstName = Utils.getInput();
		while(firstName.matches(".*\\d.*")) {
			LOGGER.info("Please enter a first name");
			firstName = Utils.getInput();
		}
		LOGGER.info("Please enter a surname");
		String surname = Utils.getInput();
		while(surname.matches(".*\\d.*")) {
			LOGGER.info("Please enter a surname"); 
			surname = Utils.getInput();
		}
        
		customerService.create(new Customer(firstName, surname));
		
	}
	@Override
	public void update() {
		LOGGER.info("Hi,  it seems you want to change some details, please follow the steps below");
		long custId = getCustomerId();
		if(custId!=0) {
			LOGGER.info("Please enter the new details");
			LOGGER.info("Please enter the new or currently used first name for update");
			String newOrCurrFirstName = Utils.getInput();
			while(newOrCurrFirstName.matches(".*\\d.*")) {
				LOGGER.info("Please enter a first name");
				newOrCurrFirstName = Utils.getInput();
			}
			LOGGER.info("Please enter the new or currently used surname for update");
			String newOrCurrSurname = Utils.getInput();
			while(newOrCurrSurname .matches(".*\\d.*")) {
				LOGGER.info("Please enter the new or currently used surname for update");
				newOrCurrSurname  = Utils.getInput();
			}
			
			customerService.update(custId, new Customer(newOrCurrFirstName, newOrCurrSurname));
		}
	
	}
	@Override
	public void delete() {
		LOGGER.info("Please enter a first name");
		String firstName = Utils.getInput();
		while(firstName.matches(".*\\d.*")) {
			LOGGER.info("Please enter a first name");
			firstName = Utils.getInput();
		}
		LOGGER.info("Please enter a surname");
		String surname = Utils.getInput();
		while(surname.matches(".*\\d.*")) {
			LOGGER.info("Please enter a surname");
			surname = Utils.getInput();
		}
	
		customerService.delete(new Customer(firstName, surname));
	}

	@Override
	public long getCustomerId() {
		
		LOGGER.info("Please enter the currently used first name");
		String currFirstName = Utils.getInput();
		while(currFirstName.matches(".*\\d.*")) {
			LOGGER.info("Please enter a first name");
			currFirstName = Utils.getInput();
		}
		LOGGER.info("Please the currently used surname");
		String currSurname = Utils.getInput();
		while(currSurname .matches(".*\\d.*")) {
			LOGGER.info("Please enter the new or currently used surname for update");
			currSurname  = Utils.getInput();
		}
	
		long custId = getCustomerId.getCustomerId(new Customer(currFirstName, currSurname));
	  return custId;
		
	}
	
}
