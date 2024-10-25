package com.main;

import java.util.ArrayList;

abstract class Employee {

	private String name;
	private int id;

	public Employee(String name, int id) {
		this.name = name;
		this.id = id;
	}

	public String getName(String name) {
		return name;
	}

	public int getId() {
		return id;
	}

	public abstract double calculateSalary();

	@Override
	public String toString() {
		return "Employee [name=" + name + ",id=" + id + ",salary=" + calculateSalary() + "]";
	}
}

class FullTimeEmployee extends Employee {

	private double monthlySalary;

	public FullTimeEmployee(String name, int id, double monthlySalary) {
		super(name, id);
		this.monthlySalary = monthlySalary;
	}

	@Override
	public double calculateSalary() {
		return monthlySalary;
	}

}

class PartTimeEmployee extends Employee {

	private int hoursWorked;
	private double hourlyRate;

	public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
		super(name, id);
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
	}

	@Override
	public double calculateSalary() {
		return hoursWorked * hourlyRate;
	}

}

class PayrollSystem {

	private ArrayList<Employee> employeelist;

	public PayrollSystem() {
		employeelist = new ArrayList<>();
	}

	public void addEmployee(Employee employee) {
		employeelist.add(employee);

	}

	public void removeEmployee(int id) {
		Employee employeeToRemove = null;

		for (Employee employee : employeelist) {
			if (employee.getId() == id) {
				employeeToRemove = employee;
				break;
			}

		}

		if (employeeToRemove != null) {
			employeelist.remove(employeeToRemove);

		}

	}

	public void displayEmployees() {
		for (Employee employee : employeelist) {
			System.out.println(employee);
		}

	}

}

public class Launch {

	public static void main(String[] args) {
		PayrollSystem payroll = new PayrollSystem();

		FullTimeEmployee emp1 = new FullTimeEmployee("Vijay", 12, 25000);
		FullTimeEmployee emp2 = new FullTimeEmployee("Raj", 13, 55000);
		FullTimeEmployee emp3 = new FullTimeEmployee("Kumar", 14, 65000);
		PartTimeEmployee emp4 = new PartTimeEmployee("raju", 25, 10, 12);
		PartTimeEmployee emp5 = new PartTimeEmployee("kaju", 26, 100, 102);
		PartTimeEmployee emp6 = new PartTimeEmployee("maju", 27, 1000, 120);

		payroll.addEmployee(emp1);
		payroll.addEmployee(emp2);
		payroll.addEmployee(emp3);
		payroll.addEmployee(emp4);
		payroll.addEmployee(emp5);
		payroll.addEmployee(emp6);

		System.out.println("Our Employee Details ");
		payroll.displayEmployees();

		System.out.println("Removing employee");
		payroll.removeEmployee(25);

		System.out.println("Now Perfect Team of Employees");
		payroll.displayEmployees();

	}

}
