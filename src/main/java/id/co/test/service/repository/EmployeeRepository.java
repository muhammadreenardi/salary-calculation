package id.co.test.service.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import id.co.test.service.config.SQLCustomStatement;
import id.co.test.service.entity.*;
import id.co.test.service.model.GetEmployeeResponse;
import id.co.test.service.model.SaveEmployeeData;
import id.co.test.service.model.SaveEmployeeResponse;

@Component
public class EmployeeRepository {

	@Autowired
	private EmployeeInterface employeeRepo;

	@Autowired
	private EmployeeSalaryInterface salaryRepo;

	@Autowired
	private Gson gson = new Gson();
	private static final String SUCCESS_CODE = "00";
	private static final String SUCCESS_DESC = "SUCCESS";
	private static final String ERROR_CODE = "99";

	public String doGetEmployeeList(String search) {
		GetEmployeeResponse response = null;

		try {
			response = new GetEmployeeResponse(SUCCESS_CODE, SUCCESS_DESC);

			if (search == null || search.isEmpty()) {
				List<Employee> list = employeeRepo.findAll();
				response.setEmployeeList(list);
			} else {
				List<Employee> list = employeeRepo.findBySearching(search);
				response.setEmployeeList(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = new GetEmployeeResponse(ERROR_CODE, e.getMessage());
		}

		return gson.toJson(response);
	}

	public String doSaveEmployee(SaveEmployeeData request) {
		Employee data = request.getData();
		SaveEmployeeResponse response = null;
		EmployeeSalaryData salary = request.getSalary();
		salary.setNik(request.getData().getNik());

		try {
			response = new SaveEmployeeResponse(SUCCESS_CODE, SUCCESS_DESC);
			employeeRepo.save(data);
			salaryRepo.save(salary);
		} catch (Exception e) {
			e.printStackTrace();
			response = new SaveEmployeeResponse(ERROR_CODE, e.getMessage());
		}

		return gson.toJson(response);
	}
}
