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



		@Override
		public void readAllOrderLine() {
			
			for(OrderLine orderLine: orderLineService.readAll()) {
				LOGGER.info(orderLine.toString());
			}
		}

		
		@Override
		public void orderLineCreate(long orderId, long itemId, int quantity) {
			
			orderLineService.create(new OrderLine(orderId, itemId, quantity));
			
		}

		@Override
		public void orderLineUpdate() {
			
			
		}

		@Override
		public void orderLineDelete() {
			
			
		}




	}
