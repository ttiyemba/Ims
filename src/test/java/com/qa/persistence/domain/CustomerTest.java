package com.qa.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Customer;

public class CustomerTest {
	private Customer customer;
	private Customer other;

	@Before
	public void setUp() {
		customer = new Customer(1L,"Tapiwa", "Tiyemba");
		other = new Customer(1L,"Test", "Test");
	}

	@Test
	public void settersTest() {
		assertNotNull(customer.getId());
		assertNotNull(customer.getFirstName());
		assertNotNull(customer.getSurname());

		customer.setId(1);
		assertNull(null);
		customer.setFirstName("Tapiwa");
		assertNull(null);
		customer.setSurname("Tiyemba");
		assertNull(null);

	}

	@Test
	public void equalsWithNull() {
		assertFalse(customer.equals(null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(customer.equals(new Object()));
	}

	@Test
	public void createCustomerWithId() {
		assertEquals(1L, customer.getId(), 0);
		assertEquals("Tapiwa", customer.getFirstName());
		assertEquals("Tiyemba", customer.getSurname());
	}

	@Test
	public void checkEquality() {
		assertTrue(customer.equals(customer));
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertTrue(customer.equals(other));
	}

	@Test
	public void customerNameNullButOtherNameNotNull() {
		customer.setFirstName(null);
		assertFalse(customer.equals(other));
	}

	@Test
	public void customerNamesNotEqual() {
		other.setFirstName("Test");
		assertFalse(customer.equals(other));
	}

	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		customer.setFirstName("Tapiwa");
		other.setFirstName("Tapiwa");
		assertTrue(customer.equals(other));
	}

	@Test
	public void nullId() {
		customer.setId(1);
		assertFalse(customer.equals(other));
	}

	@Test
	public void nullIdOnBoth() {
		customer.setId(1L);
		other.setId(1L);
		assertTrue(customer.equals(other));
	}

	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(customer.equals(other));
	}

	@Test
	public void nullSurname() {
		customer.setSurname(null);
		assertFalse(customer.equals(other));
	}

	@Test
	public void nullSurnameOnBoth() {
		customer.setSurname(null);
		other.setSurname(null);
		assertFalse(customer.equals(other));
	}

	@Test
	public void otherSurnameDifferent() {
		other.setSurname("Test");
		assertFalse(customer.equals(other));
	}

	@Test
	public void constructorWithoutId() {
		Customer customer = new Customer("Tapiwa", "Tiyemba");
		//assertNull(customer.getId());
		assertNotNull(customer.getFirstName());
		assertNotNull(customer.getSurname());
	}

	@Test

	public void toStringTest() {
		String toString = "\n"+ "Id: 1"  + "\n"+ "First name: Tapiwa"  +"\n"+ "Surname: Tiyemba";
		assertEquals(toString, customer.toString());
	}
}