package com.qa.persistence.domain;

public class Customer{

	private long id;
	private String firstName;
	private String surname;
	

	
	public Customer(String firstName, String surname) {
		this.firstName = firstName;
		this.surname = surname;
		
		
	}
	
	/**
	 * Construtor to create a customer
	 * @param id
	 * @param firstName
	 * @param surname
	 */

	public Customer(long id, String firstName, String surname)  {
		this.id = id;
		this.firstName = firstName;
		this.surname = surname;
		
	}
	

	
	public Customer() {
		
	}

	/**
	 * 
	 * @return id
	 */
	public long getId() {
		return id;
	}
	/**
	 * set id
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * 
	 * @return surname
	 */
	public String getSurname() {
		return surname;
	}
	
	/**
	 * sets surname
	 * @param surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String toString() {
		return "\n"+ "Id: 1"  + "\n"+ "First name: Tapiwa"  +"\n"+ "Surname: Tiyemba" ;
	}

	public void setId(Long id) {
		this.id = id;
		
	}


}


