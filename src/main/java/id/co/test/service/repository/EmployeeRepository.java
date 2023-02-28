package id.co.test.service.repository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import id.co.test.service.entity.*;
import id.co.test.service.model.GetEmployeeDetailResponse;
import id.co.test.service.model.GetEmployeeResponse;
import id.co.test.service.model.GetSalaryDetail;
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
		salary.setEmployee(request.getData());

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

	public String doGetEmployeeDetail(String nik) {
		GetEmployeeDetailResponse response = null;

		try {
			EmployeeSalaryData data = salaryRepo.findDetail(nik);
			if (data != null) {
				response = new GetEmployeeDetailResponse(SUCCESS_CODE, SUCCESS_DESC);
				response.setNik(data.getEmployee().getNik());
				response.setFullName(data.getEmployee().getFullName());
				
				GetSalaryDetail salaryDetail = new GetSalaryDetail();
				
				salaryDetail.setPokok(data.getPokok());
				salaryDetail.setTunjangan(data.getTunjangan());
				salaryDetail.setBonus(data.getBonus());
				salaryDetail.setPotongan(data.getPotongan());
				salaryDetail.setPajak(data.getPajak());
				
				// Gaji Netto = (Gaji Pokok + Tunjangan + Bonus) - Potongan - Pajak
				// Persentase Pengurangan = (Potongan + Pajak) / Gaji Bruto x 100%
				BigDecimal bruto = salaryDetail.getPokok().add(salaryDetail.getTunjangan().add(salaryDetail.getBonus()));
				BigDecimal netto = bruto.subtract(salaryDetail.getPotongan().subtract(salaryDetail.getPajak()));
				BigDecimal a1 = salaryDetail.getPotongan().add(salaryDetail.getPajak());
				BigDecimal percentage = (a1.divide(bruto, 2, RoundingMode.HALF_EVEN)).multiply(new BigDecimal(100));
				
				salaryDetail.setNett(netto);
				salaryDetail.setPersentasePengurangan(percentage);
				response.setSalaryDetail(salaryDetail);
			} else {
				throw new Exception("NIK not Found");
			}

			

		} catch (Exception e) {
			e.printStackTrace();
			response = new GetEmployeeDetailResponse(ERROR_CODE, e.getMessage());
		}

		return gson.toJson(response);
	}

}
