package com.functionalinterfaces.app;

public class Employee {

	private int id;
	private String name;
	private int salary;
	private String title;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Employee(int id, String name, int salary, String title) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.title = title;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}
	
	
	
}
