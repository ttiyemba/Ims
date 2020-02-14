package com.qa.persistence.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.controller.ItemController;
import com.qa.persistence.domain.Item;
import com.qa.utils.Config;

public class ItemDaoMysql implements ItemDao<Item> {
	public static final Logger logger = Logger.getLogger(ItemController.class);
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
	 * returns all items
	 */

	public List<Item> readAll() {
		ArrayList<Item> items = new ArrayList<Item>();
		try{
			databaseConnection();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from items");
			while (resultSet.next()) {
				long id = (long) resultSet.getInt("id");
				String itemName = resultSet.getString("itemName");
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
	
	/**
	 * creates an item
	 */
	public void create(Item item) {
		try{
			databaseConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate("insert into items(itemname, price, quantity) values('" + item.getName() + "','" + item.getPrice()+ "','"+ item.getQuantity()+ "')" );
			logger.info("Item created");
		} catch (Exception e) {
			logger.error("error inserting the item details");
		} 
	}
	/**
	 * returns the itemId
	 */
public long getItemId(Item c) {
	String sql = "SELECT id from items WHERE itemname= ?";
	long id =(long) 0;
	try {
		databaseConnection();
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, c.getName());
	
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
	/**
	 * update an item
	 */
	public void update(long id, Item item) {
		int itemId = (int)id;
		
			String sql = "UPDATE items SET itemname= ?, price= ?, quantity= ? WHERE id=" + itemId  ;
			try {
				databaseConnection();
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setString(1, item.getName());
				stmt.setDouble(2, item.getPrice());
				stmt.setInt(3, (int)item.getQuantity());
				stmt.execute();
				if(itemId==0) {
					logger.error("This item does not exist in the database");
				}else {
					logger.info("Update complete");
				}
				connection.close();
		}catch(Exception e) {
			 logger.error("Update failed");
			 
		 }
		

	}
	
	/**
	 * update an item
	 */

	public void delete(Item item) {
		
		String sql = "DELETE FROM items WHERE itemname= ?";
		try {
			databaseConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, item.getName());
			stmt.execute();
			logger.error("Delete complete");
			connection.close();
	}catch(Exception e) {
		 logger.error("Delete failed");
		 
	 }
	}

}
