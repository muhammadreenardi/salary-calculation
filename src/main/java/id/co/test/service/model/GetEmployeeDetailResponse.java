package id.co.test.service.model;

import java.sql.Timestamp;

public class GetEmployeeDetailResponse  extends StandardResponse {
	
	private String nik;
	private String fullName;
	private GetSalaryDetail salaryDetail;
	
	public GetEmployeeDetailResponse(String responseCode, String responseDesc) {
		super(responseCode, responseDesc, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
	}

	public String getNik() {
		return nik;
	}

	public void setNik(String nik) {
		this.nik = nik;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public GetSalaryDetail getSalaryDetail() {
		return salaryDetail;
	}

	public void setSalaryDetail(GetSalaryDetail salaryDetail) {
		this.salaryDetail = salaryDetail;
	}

	
}
