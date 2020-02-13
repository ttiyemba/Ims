package com.qa.persistence.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.controller.OrderLineController;
import com.qa.persistence.domain.OrderLine;
import com.qa.utils.Config;

public class OrderLineDaoMysql implements OrderLineDao<OrderLine>{
	

		public static final Logger logger = Logger.getLogger(OrderLineController.class);
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

		public List<OrderLine> readAll() {
			ArrayList<OrderLine> orderLineList = new ArrayList<OrderLine>();
			try {
				databaseConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("select * from OrderLine");
				while (resultSet.next()) {
					Long id = (long) resultSet.getInt("id");
					long orderId = (long)resultSet.getInt("orderId");
					long itemId = (long)resultSet.getInt("orderId");
					int quantity =  resultSet.getInt("quantity");
				OrderLine orderLine = new OrderLine(id, orderId, itemId, quantity);
					orderLineList.add(orderLine);
				}
			} catch (Exception e) {
				logger.error("error displaying the list of items");
			}
			return orderLineList;
		}

		public void create(OrderLine t) {
			try{
				databaseConnection();
				Statement statement = connection.createStatement();
				statement.executeUpdate("insert into orderline(orderId, itemId, itemquantity) values('" + t.getOrderId() + "','" +t.getItemId() + "','"+t.getQuantity()+ "')" );
				logger.info("Orderline created");
			} catch (Exception e) {
				logger.error("error inserting to orderline table");
			} 
		}

	

		@Override
		public void update(long id, OrderLine t) {
			
			
		}

		@Override
		public void delete(OrderLine t) {
			
			
		}

		@Override
		public long getOrderIdForOrderLine(long custId, double price) {
			
			return 0;
		}

		
}
