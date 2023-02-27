package id.co.test.service.model;

import java.sql.Timestamp;
import java.util.List;

import id.co.test.service.entity.Employee;

public class GetEmployeeResponse extends StandardResponse {

	private List<Employee> employeeList;

	public GetEmployeeResponse(String responseCode, String responseDesc) {
		super(responseCode, responseDesc, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
}
