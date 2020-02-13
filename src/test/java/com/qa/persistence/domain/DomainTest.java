package com.qa.persistence.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;



public class DomainTest {
	
	@Test
	public void customerTest() {
		Domain domain = Domain.CUSTOMER;
		assertTrue(domain.description().toLowerCase().contains("customer"));
	}
	
	@Test
	public void itemTest() {
		Domain domain = Domain.ITEM;
		assertTrue(domain.description().toLowerCase().contains("item"));
	}
	
	@Test
	public void orderTest() {
		Domain domain = Domain.ORDER;
		assertTrue(domain.description().toLowerCase().contains("order"));
	}
	
	@Test
	public void stopTest() {
		Domain domain = Domain.STOP;
		assertTrue(domain.description().toLowerCase().contains("close"));
	}

}
