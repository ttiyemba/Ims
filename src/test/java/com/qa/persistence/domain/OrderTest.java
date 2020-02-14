package com.qa.persistence.domain;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {

	private Order order;
	private Order order2;

	@Before
	public void setUp() {
		order = new Order(2.2, 2l, 3l, 3l);
		//order2(new Order(3.3, 5l, 6l, 3l));

	}

	@Test
	public void settersTest() {
		assertNotNull(order.getId());
		assertNotNull(order.getItemId());
		assertNotNull(order.getItemPrice());

		order.getId();
		assertNull(null);
		order.setItemId(3L);;
		assertNull(null);
		order.setItemPrice(23);
		assertNull(null);

	}

	@Test
	public void equalsWithNull() {
		assertFalse(order.equals(null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(order.equals(new Object()));
	}

	@Test
	public void checkEquality() {
		assertFalse(order.equals(order2));
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertFalse(order.equals(order2));
	}

	@Test
	public void itemNameNullButOtherNameNotNull() {
		order.setId(2l);
		assertFalse(order.equals(order2));
	}


}
