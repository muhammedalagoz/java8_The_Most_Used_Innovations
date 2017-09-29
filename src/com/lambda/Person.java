package com.lambda;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Person {

    private Integer number;
    private String firstName;
    private String lastName;
    private LocalDate date;
    private BigDecimal salary;
	
    public Person(Integer number, String firstName, String lastName,
			LocalDate date, BigDecimal salary) {
		super();
		this.number = number;
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.setSalary(salary);
	}

    public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Person [number=" + number + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", date=" + date + ", salary="
				+ salary + "]";
	}

    
}