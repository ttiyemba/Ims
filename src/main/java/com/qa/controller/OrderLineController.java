package com.qa.controller;

import org.apache.log4j.Logger;
import com.qa.persistence.domain.OrderLine;
import com.qa.services.CrudServices;


	
	public class OrderLineController implements GetOrderItemDetailsController {
		
		public static final Logger LOGGER = Logger.getLogger(OrderLineController.class);
	private CrudServices<OrderLine> orderLineService;

		
		
		public OrderLineController(CrudServices<OrderLine> orderLineService) {
			this.orderLineService= orderLineService;
			
		}



		/**
		 * reads an orderline
		 */
		public void readAllOrderLine() {
			
			for(OrderLine orderLine: orderLineService.readAll()) {
				LOGGER.info(orderLine.toString());
			}
		}

		
		/**
		 * create an orderline 
		 */
		public void orderLineCreate(long orderId, long itemId, int quantity) {
			
			orderLineService.create(new OrderLine(orderId, itemId, quantity));
			
		}

		/**
		 * update an orderline
		 */
		public void orderLineUpdate() {
			
			
		}

		/**
		 * delete an order line
		 */
		public void orderLineDelete() {
			
			
		}




	}
