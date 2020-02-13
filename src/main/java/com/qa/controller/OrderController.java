package com.qa.controller;
import java.util.concurrent.TimeUnit;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.Logger;

import com.qa.persistence.domain.Customer;
import com.qa.persistence.domain.Item;
import com.qa.persistence.domain.Order;
import com.qa.persistence.domain.OrderLine;
import com.qa.services.CrudServices;
import com.qa.services.GetCustomerId;
import com.qa.services.GetItemId;
import com.qa.services.GetOrderDetails;
import com.qa.services.OrderLineServices;
import com.qa.utils.Utils;

public class OrderController implements CrudController<Order>,GetItemListController<Item>,GetCustomerIdController<Customer>, GetItemIdController<Item>, GetOrderIdController<Order>, GetOrderItemDetailsController{
	public static final Logger LOGGER = Logger.getLogger(OrderController.class);
	private String itemName;
	private CrudServices<Order> orderService;
	public GetCustomerId<Customer> getCustomerId;
	public GetItemId<Item> getItemId;
	private GetOrderDetails<Order,Item,Customer> getOrderDetails;
	private OrderLineServices orderLineService;
	//private List<Integer> itemQuantityList;
	
	
	public OrderController(CrudServices<Order> orderService, GetCustomerId<Customer> getCustomerId, GetOrderDetails<Order, Item,Customer> getOrderDetails, GetItemId<Item> getItemId,OrderLineServices orderLineService ) {
		this.orderService= orderService;
		this.getCustomerId = getCustomerId;
		this.getItemId = getItemId;
		this.getOrderDetails = getOrderDetails;
		this.orderLineService= orderLineService;
	}
	@Override
	public void readAll() {
		for(Order order: orderService.readAll()) {
			LOGGER.info(order.toString());
		}
		
	}
	

	@Override
	public void create() {
		ArrayList<Long> idList = new ArrayList<Long>();
		ArrayList<Integer> quantityList = new ArrayList<Integer>();
     	double totalPrice = 0.00;
		long custId= getCustomerId();
		itemsDisplay();
		while(true) { 
			
			LOGGER.info("Please enter the name of the item to purchase. Enter stop to end.");
			 this.itemName = Utils.getInput();
			if(this.itemName.equalsIgnoreCase("stop")){
				break;
			}
			long id= getItemId();
			idList.add(id);
			
			double price =getOrderDetails.itemsPrice(new Item(itemName));
			LOGGER.info("Please enter the quantity");
			String quantity = Utils.getInput();
			int quantityinteger = Integer.parseInt(quantity);
			quantityList.add(quantityinteger);
			double totalPriceForEachItem = quantityinteger * price;
			totalPrice = totalPrice + totalPriceForEachItem;
			
			
		}
		
		orderService.create(new Order(totalPrice,custId));
		System.out.println(totalPrice);
		try {
			TimeUnit.SECONDS.sleep(25);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		DecimalFormat df = new DecimalFormat("0.00");      
		double total = Double.parseDouble(df.format(totalPrice));
		long result= getOrderId(custId,total);
		
		System.out.println("order id = "+result);
		if(result!=0) {
			for(int i=0; i<quantityList.size();i++) {
				System.out.println("list of id"+idList.get(i));
				System.out.println("list of quantity"+quantityList.get(i));
			
				orderLineCreate(result,idList.get(i),quantityList.get(i));
			}
			
		}
	}

	@Override
	public void update() {
		readAllOrderLine();		
		
	}

	@Override
	public void delete() {
		long custId= getCustomerId();
		
		for(Order order:orderDetailsDisplay(custId)) { 
			LOGGER.info(order.toString());
		}
		while(true) {
			LOGGER.info("Please enter the id of the order sabyou want to delete, please enter stop to end");
			String id = Utils.getInput();
			if(id.equalsIgnoreCase("stop")){
				break;
			}
			long orderId = Long.parseLong(id);
			orderService.delete(new Order(orderId));
		}
			
	}
	@Override
	public long getCustomerId() {
		// TODO Auto-generated method stub
				LOGGER.info("Please enter your first name");
				String firstName = Utils.getInput();
				while(firstName.matches(".*\\d.*")) {
					LOGGER.info("Please enter a first name");
					firstName = Utils.getInput();
				}
				LOGGER.info("Please enter your surname");
				String surname = Utils.getInput();
				while(surname.matches(".*\\d.*")) {
					LOGGER.info("Please enter a surname");
					surname = Utils.getInput();
				}
			
				long custId = getCustomerId.getCustomerId(new Customer(firstName, surname));
			  return custId;
	}
	@Override
	public long getOrderId(long custId, double price) {
		long  orderId =  getOrderDetails.getOrderId(custId, price);
		// TODO Auto-generated method stub
		return orderId;
	}
	@Override
	public long getItemId() {
		
		long itemId = getItemId.getItemId(new Item(itemName));
	  return itemId;
		
	}
	@Override
	public void itemsDisplay() {
		for(Item item: getOrderDetails.itemsDisplay()) {
			LOGGER.info(item.toString());
		}
		
		
	}


	@Override
	public List<Order> orderDetailsDisplay(long id) {
		List<Order> orders = new ArrayList<Order>();
		orders = getOrderDetails.orderDetailsDisplay(id);
		return orders;
	}
	@Override
	public void readAllOrderLine() {
		// TODO Auto-generated method stub
		for(OrderLine orderLine: orderLineService.readAll()) {
			LOGGER.info(orderLine.toString());
			}
	}
	@Override
	public void orderLineCreate(long orderId, long itemId, int quantity) {
		// TODO Auto-generated method stub
		orderLineService.create(new OrderLine(orderId,itemId,quantity));
	}
	@Override
	public void orderLineUpdate() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void orderLineDelete() {
		// TODO Auto-generated method stub
		
	}
	
	
	


}
