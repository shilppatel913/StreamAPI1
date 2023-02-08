package com.functionalinterfaces.app;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Assignment2 {

	public static void main(String[] args) {
		Employee emp1=new Employee(1,"Shilp",3000,"Backend");
		Employee emp2=new Employee(2,"Isha",4000,"Developer");
		Employee emp3=new Employee(3,"Harsh",6000,"Developer");
		Employee emp4=new Employee(4,"Chavi",1000,"Masters");
		Employee emp5=new Employee(5,"Utkarsh",2000,"Backend");
		
		List<Employee> employeeList=new ArrayList<>();
		employeeList.add(emp1);
		employeeList.add(emp2);
		employeeList.add(emp3);
		employeeList.add(emp4);
		
		
		/*Filter all the employees with salary>3500*/
		
		List<Employee>temp=employeeList
			.stream()
			.filter((emp)->{
				return emp.getSalary()>3500;
			}).collect(Collectors.toList());
		System.out.println(temp);
		System.out.println("----------------------------------------");

		/*getting all the distinct title */
		List<String> titles=employeeList.stream()
		.map((emp)->emp.getTitle())
		.distinct()
		.collect(Collectors.toList());
		
		System.out.println(titles);
		System.out.println("----------------------------------------");
		
		/*Sort all the employees in descending order of their salary */
		List<Employee>sortedDesc=employeeList.stream()
			.sorted().collect(Collectors.toList());
		System.out.println(sortedDesc);
		System.out.println("----------------------------------------");
		
		
		/*Get the addition of the salaries of all employees*/
		int sum=employeeList.stream()
							.map(emp->emp.getSalary())
							.reduce((sal1,sal2)->sal1+sal2).orElse(0);
		System.out.println(sum);
		System.out.println("----------------------------------------");
		
		
		/*Just print all the employee names*/
		employeeList.stream()
		.forEach(emp->System.out.println(emp.getName()));
		System.out.println("----------------------------------------");
		
		
		/*Check if all(using all match) the employees have salaries greater than 2000*/
		
		boolean answer=employeeList.stream()
					.allMatch(emp->emp.getSalary()>2000);
		System.out.println(answer);
		System.out.println("----------------------------------------");
		
		/*Check if any(any match) of the employee names are harsh*/
		boolean ans=employeeList.stream()
					.anyMatch(emp->emp.getName().equalsIgnoreCase("Harsh"));
		System.out.println(ans);
		System.out.println("----------------------------------------");
		
		/*Find the min salary and the max salary for the company */
		
		Integer minValue=employeeList.stream()
		.map(emp->emp.getSalary())
		.min(Integer::compare).get();
		
		System.out.println("The minimum salary is "+minValue);
		System.out.println("----------------------------------------");
		
		Integer maxValue=employeeList.stream()
				.map(emp->emp.getSalary())
				.max(Integer::compare).get();
		
		System.out.println("The maximum salary is "+maxValue);
		
	}

}
