package com.functionalinterfaces.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assignment {

	public static void main(String[] args) {
		Employee emp1=new Employee(1,"Shilp",3000,"Backend");
		Employee emp2=new Employee(2,"Isha",4000,"Developer");
		Employee emp3=new Employee(1,"Harsh",6000,"Developer");
		Employee emp4=new Employee(1,"Chavi",1000,"Masters");
		
		List<Employee> employeeList=new ArrayList<>();
		employeeList.add(emp1);
		employeeList.add(emp2);
		employeeList.add(emp3);
		employeeList.add(emp4);
		
		Map<String,List<Employee>> output1=groupByJobTitle(employeeList);
		output1.forEach((title,empList)->System.out.println(title+" "+empList.toString()));
		double avgSalary=calculateAverage(employeeList);
		System.out.println("The average salary is"+avgSalary);

	}
	
	private static Map<String, List<Employee>> groupByJobTitle(List<Employee> employeeList) {
		Map<String,List<Employee>> resultMap=new HashMap<>();
		employeeList
		.stream()
		.forEach((employee)->{
			List<Employee> employeeSubList=resultMap.getOrDefault(employee.getTitle(), new ArrayList<>());
			employeeSubList.add(employee);
			resultMap.put(employee.getTitle(), employeeSubList);
		});
		return resultMap;
	}

	private static double calculateAverage(List<Employee> employeeList) {
		Integer sumTemp=employeeList
		.stream()
		.map((employee)->{
			return employee.getSalary();
		})
		.reduce((sal1,sal2)->sal1+sal2).orElse(0);
		
		double sum=(double)sumTemp;
		double count=(double)employeeList.size();
		return sum/count;
	}

	

}
