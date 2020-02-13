package com.qa.persistence.domain;

public class Customer{

	private long id;
	private String firstName;
	private String surname;
	private String email;

	
	public Customer(String firstName, String surname, String email) {
		this.firstName = firstName;
		this.surname = surname;
		this.email=email;
		
	}

	public Customer(long id, String firstName, String surname, String email) {
		this.id = id;
		this.firstName = firstName;
		this.surname = surname;
		this.email=email;
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
		return "\n"+ "Id: " + id + "\n"+ "First name: " + firstName +"\n"+ "Surname: " + surname+"\n"+ "Email: "+email + "\n" + "...................................................." ;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
