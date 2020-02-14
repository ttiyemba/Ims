package com.qa.persistence.domain;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	

	private Item item;
	private Item otherItem;

	@Before
	public void setUp() {
		item = new Item(1,"ITEM1",2,4);
		setOtherItem(new Item(1,"Item2", 50, 3));
		
	}

	@Test
	public void settersTest() {
		assertNotNull(item.getId());
		assertNotNull(item.getName());
		assertNotNull(item.getPrice());

		item.setId(1);
		assertNull(null);
		item.setName("Item1");
		assertNull(null);
		item.setPrice(45);
		assertNull(null);

	}

	@Test
	public void equalsWithNull() {
		assertFalse(item.equals(null));
	}

	@Test
	public void equalsWithDifferentObject() {
		assertFalse(item.equals(new Object()));
	}



	@Test
	public void checkEquality() {
		assertFalse(item.equals(otherItem));
	}

	@Test
	public void checkEqualityBetweenDifferentObjects() {
		assertFalse(item.equals(otherItem));
	}

	@Test
	public void itemNameNullButOtherNameNotNull() {
		item.setName(null);
		assertFalse(item.equals(otherItem));
	}

	@Test
	public void itemNamesNotEqual() {
		item.setName("Chair");
		assertFalse(item.equals(otherItem));
	}

	@Test
	public void checkEqualityBetweenDifferentObjectsNullName() {
		item.setName("t");
		otherItem.setName("t");
		assertFalse(item.equals(otherItem));
	}

	@Test
	public void nullId() {
		item.setId(1l);
		assertFalse(item.equals(otherItem));
	}

	@Test
	public void nullIdOnBoth() {
		Item item = new Item("grape");
		Item item2  = new Item("chair");
		item.setId(1L);;
		item2.setId(2L);
		assertFalse(item.equals(item2));
	}


	@Test
	public void constructorWithoutId() {
		Item item = new Item("yoo");
		assertNull(null);
		assertNotNull(item.getName());
		assertNotNull(item.getName());
	}
	
	@Test
	public void otherIdDifferent() {
		item.setId(3);
		assertFalse(item.equals(otherItem));
	}


	public Item getOtherItem() {
		return otherItem;
	}

	public void setOtherItem(Item otherItem) {
		this.otherItem = otherItem;
	}
		@Test
		public void constructorWithoutId4() {
			Item item = new Item("yoo");
			assertNull(null);
			assertNotNull(item.getName());
			assertNotNull(item.getName());
		}
		
		@Test
		public void constructorWithoutId3() {
			Item item = new Item("yoo");
			assertNull(null);
			assertNotNull(item.getName());
			assertNotNull(item.getName());
		}

}
