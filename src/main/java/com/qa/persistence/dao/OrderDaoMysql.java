package com.qa.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

//import com.qa.controller.CustomerController;
import com.qa.controller.OrderController;
//import com.qa.controller.ItemController;
import com.qa.persistence.domain.Customer;
import com.qa.persistence.domain.Item;
import com.qa.persistence.domain.Order;
import com.qa.utils.Config;
public class OrderDaoMysql implements OrderDao<Order,Item,Customer> {
	public static final Logger logger = Logger.getLogger(OrderController.class);
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
	@Override
	public List<Order> readAll() {
		ArrayList<Order> orders = new ArrayList<Order>();
		try{
			databaseConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from orders");
			while (resultSet.next()) {
				long id = (long) resultSet.getInt("id");
				long custId = (long) resultSet.getInt("custId");
				double price  = resultSet.getDouble("price");
				Order order = new Order(id,custId,price);
				orders.add(order);
			}
			
		} catch (Exception e) {
			logger.error("error displaying the list of orders");
		}
		return orders;
	}

	public void create(Order order) {
		try{
			databaseConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into orders(custId,price) values('" + order.getCustId() + "','" + order.getPrice()+ "')" );
			logger.info("Order created");
		} catch (Exception e) {
			logger.error("error inserting the order details");
		}
		
	}
	@Override
	public void update(long id, Order t) {
		
		
	}
	@Override
	public void delete(Order order) {
		String sql = "DELETE FROM orders WHERE id= ?";
		try {
			databaseConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, (int)order.getId());
			stmt.execute();
			System.out.println("Delete complete ");
			connection.close();
	}catch(Exception e) {
		 logger.error("Delete failed");
		 
	 }
	}
		
	
@Override 
  public List<Item> itemsDisplay () {
	  ArrayList<Item> items = new ArrayList<Item>();
		try{
			databaseConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from items");
			while (resultSet.next()) {
				long id = (long) resultSet.getInt("id");
				String itemName = resultSet.getString("itemname");
				double price = resultSet.getDouble("price");
				long quantity = (long) resultSet.getInt("quantity");
				Item item = new Item(id, itemName, price, quantity);
				items.add(item);
			}
		} catch (Exception e) {
			logger.error("error displaying the list of items");
		}
		return items;
	  
  }
@Override
  public double itemsPrice(Item c) {
	  String sql = "SELECT price from items where itemname =?";
	  double price = (double)0;
	  try {
			databaseConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, c.getName());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				
				 price = rs.getDouble("price");
				
			}
			logger.info("price obtained");
			rs.close();
			connection.close();
	}catch(Exception e) {
		 logger.error("price not obtained");
		 price= (double) 0;
		 
	 }
	 return price;
  }

@Override
public long getCustomerId(Customer v) {
	String sql = "SELECT id from customers WHERE firstname= ? && surname= ? ";
	long id =(long) 0;
	try {
		databaseConnection();
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, v.getFirstName());
		stmt.setString(2, v.getSurname());
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			
			 id = (long) rs.getInt("id");
			
		}if(id==0) {
			logger.error("This customer does not exist in the database");
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
public long getOrderId(long custId, double price) {
	String sql = "SELECT id from orders WHERE custId= ? && price= ? ";
	long id =(long) 0;
	try {
		databaseConnection();
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setLong(1, custId);
		stmt.setDouble(2,price);
		
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			
			 id = (long) rs.getInt("id");
			
		}
		if(id==0) {
			logger.error("This order does not exist in the database");
		}else {
			logger.info("Orderid obtained");
		}
		rs.close();
		connection.close();
}catch(Exception e) {
	 logger.error(e);
	 id= (long) 0;
	 
 }
	logger.info("The orderid is "+id);
	return id;
	
}
@Override
public long getItemId(Item u) {
	String sql = "SELECT id from items WHERE itemname= ?";
	long id =(long) 0;
	try {
		databaseConnection();
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, u.getName());
	
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			
			 id = (long) rs.getInt("id");
			
		}
		if(id==0) {
			logger.error("This item does not exist in the database");
		}else {
			logger.info("Itemid obtained");
		}
		rs.close();
		connection.close();
}catch(Exception e) {
	 logger.error("Itemid not obtained");
	 id= (long) 0;
	 
 }
	logger.info("The itemid is "+id);
	return id;
}
@Override
public List<Order> orderDetailsDisplay(long id) {
	 ArrayList<Order> orders = new ArrayList<Order>();
		try {
			databaseConnection();
			String sql= "select * from orders where custId =? ";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet resultSet = stmt.executeQuery();
			
			while (resultSet.next()) {
				long idGet = (long) resultSet.getInt("id");
				long custId = resultSet.getLong("custId");
				double price = resultSet.getDouble("price");
				Order order = new Order(idGet, custId, price);
				orders.add(order);
			}
		} catch (Exception e) {
			logger.error("error displaying the list of items");
		}
		return orders;
}
	
	
}
