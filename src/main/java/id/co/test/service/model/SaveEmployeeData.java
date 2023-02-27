package id.co.test.service.model;

import id.co.test.service.entity.Employee;
import id.co.test.service.entity.EmployeeSalaryData;

public class SaveEmployeeData {

	private Employee data;
	private EmployeeSalaryData salary;
	public Employee getData() {
		return data;
	}
	public void setData(Employee data) {
		this.data = data;
	}
	public EmployeeSalaryData getSalary() {
		return salary;
	}
	public void setSalary(EmployeeSalaryData salary) {
		this.salary = salary;
	}
	
	
}
