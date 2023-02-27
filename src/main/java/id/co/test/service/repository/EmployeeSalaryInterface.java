package id.co.test.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.co.test.service.entity.EmployeeSalaryData;

@Repository
public interface EmployeeSalaryInterface extends JpaRepository<EmployeeSalaryData, String> {
	
	EmployeeSalaryData findByNik(String nik) throws Exception;

}
