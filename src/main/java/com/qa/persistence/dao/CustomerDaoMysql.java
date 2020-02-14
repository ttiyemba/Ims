package com.qa.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.controller.CustomerController;
import com.qa.persistence.domain.Customer;
import com.qa.utils.Config;

public class CustomerDaoMysql implements Dao<Customer> {
	
	public static final Logger logger = Logger.getLogger(CustomerController.class);
	private Connection connection;
	
	public String databaseConnection() {
	 try {
		 this.connection= DriverManager.getConnection("jdbc:mysql://35.228.215.111/IMS", Config.username, Config.password); 
		 return "Connection passed";
	 }catch(Exception e) {
		 logger.error("Connection failed");
		 return "Connection failed";
	 } 		
		
	}
		

	/**
	 * reads all customers
	 */
	public List<Customer> readAll() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try  {
			databaseConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from customers");
			while (resultSet.next()) {
				long id = (long) resultSet.getInt("id");
				String firstName = resultSet.getString("firstName");
				String surname = resultSet.getString("surname"); 
				Customer customer = new Customer(id, firstName, surname);
				customers.add(customer);
				statement.closeOnCompletion();
				connection.close();
			}
		} catch (Exception e) {
			logger.error("error displaying the list of customers");
		}
		return customers;
		
	}
	/**
	 * creates an customer
	 */
	public void create(Customer customer) {
		try{
			databaseConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into customers(firstname, surname) values('" + customer.getFirstName() + "','" + customer.getSurname()+ "')" );
			logger.info("Customer created");
			connection.close();
		} catch (Exception e) {
			logger.error("error inserting the customer details");
		} 
	}
	/**
	 * gets the customer id
	 */
public long getCustomerId(Customer c) {
	String sql = "SELECT id from customers WHERE firstname= ? && surname= ? ";
	long id =(long) 0;
	try {
		databaseConnection();
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, c.getFirstName());
		stmt.setString(2, c.getSurname());
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			
			 id = (long) rs.getInt("id");
			
		}
		if(id==0) {
			logger.error("This customer does not exist in  the database");
		}else {
			logger.info("Customerid obtained");
		}
		
		rs.close();
		connection.close();
}catch(Exception e) {
	 logger.error("Customerid not obtained");
	 id= (long) 0;
	 
 }
	logger.info("The customerid is "+id);
	return id;
}
	/**
	 * updates a customer
	 */
	public void update(long id, Customer customer) {
		int custId = (int)id;
		String sql = "UPDATE customers SET firstname= ?, surname= ? WHERE id=" + custId  ;
		try {
			databaseConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, customer.getFirstName());
			stmt.setString(2, customer.getSurname());
			stmt.execute();
			if(custId==0) {
				logger.error("This customer does not exist in the database");
			}else {
				logger.info("Update complete");
			}
			connection.close();
	}catch(Exception e) {
		 logger.info(e);
		 
	 }

	}
	/**
	 * deletes a customer
	 */
	public void delete(Customer customer) {
		
		String sql = "DELETE FROM customers WHERE firstname= ? && surname= ? ";
		try {
			databaseConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, customer.getFirstName());
			stmt.setString(2, customer.getSurname());
			stmt.execute();
			logger.info("Delete complete");
			connection.close();
	}catch(Exception e) {
		 logger.info(e);;
		 
	 }
	}




	
}



