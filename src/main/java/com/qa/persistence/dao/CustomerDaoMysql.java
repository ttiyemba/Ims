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
	
	public String checkConnection() {
	 try {
		 this.connection= DriverManager.getConnection("jdbc:mysql://35.246.124.49:3306/IMS", Config.username, Config.password); 
		 return "Connection passed";
	 }catch(Exception e) {
		 logger.error("Connection failed");
		 return "Connection failed";
	 } 		
		
	}
		

	
	@Override
	public List<Customer> readAll() {
		ArrayList<Customer> customers = new ArrayList<Customer>();
		try  {
			checkConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from Customers");
			while (resultSet.next()) {
				long id = (long) resultSet.getInt("id");
				String firstName = resultSet.getString("firstName");
				String surname = resultSet.getString("surname");
				String email = resultSet.getString("email");
				Customer customer = new Customer(id, firstName, surname, email);
				customers.add(customer);
				statement.closeOnCompletion();
			}
		} catch (Exception e) {
			logger.error("error displaying the list of customers");
		}
		return customers;
	}
	@Override
	public void create(Customer customer) {
		try{
			checkConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into Customers(firstName, surname, email) values('" + customer.getFirstName() + "','" + customer.getSurname()+ "','"+ customer.getEmail()+ "')" );
			logger.info("Customer created");
			connection.close();
		} catch (Exception e) {
			logger.error("error inserting the customer details");
		} 
	}
	@Override
public long getCustomerId(Customer c) {
	String sql = "SELECT id from Customers WHERE firstName= ? && surname= ? && email= ?";
	long id =(long) 0;
	try {
		checkConnection();
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, c.getFirstName());
		stmt.setString(2, c.getSurname());
		stmt.setString(3, c.getEmail());
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
	@Override
	public void update(long id, Customer customer) {
		int custId = (int)id;
		String sql = "UPDATE Customers SET firstName= ?, surname= ?, email= ? WHERE id=" + custId  ;
		try {
			checkConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, customer.getFirstName());
			stmt.setString(2, customer.getSurname());
			stmt.setString(3, customer.getEmail());
			stmt.execute();
			if(custId==0) {
				logger.error("This customer does not exist in the database");
			}else {
				logger.info("Update complete");
			}
			connection.close();
	}catch(Exception e) {
		 logger.error("Update failed");
		 
	 }

	}
	@Override
	public void delete(Customer customer) {
		
		String sql = "DELETE FROM Customers WHERE firstName= ? && surname= ? && email= ?";
		try {
			checkConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, customer.getFirstName());
			stmt.setString(2, customer.getSurname());
			stmt.setString(3, customer.getEmail());
			stmt.execute();
			logger.error("Delete complete");
			connection.close();
	}catch(Exception e) {
		 logger.error("Delete failed");
		 
	 }
	}




	
}



