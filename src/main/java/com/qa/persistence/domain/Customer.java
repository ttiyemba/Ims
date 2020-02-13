package com.qa.persistence.domain;

public class Customer{

	private long id;
	private String firstName;
	private String surname;
	

	
	public Customer(String firstName, String surname) {
		this.firstName = firstName;
		this.surname = surname;
		
		
	}

	public Customer(long id, String firstName, String surname)  {
		this.id = id;
		this.firstName = firstName;
		this.surname = surname;
		
	}
	

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

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


