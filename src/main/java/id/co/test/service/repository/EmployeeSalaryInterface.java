package id.co.test.service.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import id.co.test.service.entity.EmployeeSalaryData;

@Repository
public interface EmployeeSalaryInterface extends JpaRepository<EmployeeSalaryData, String> {

	@Query(value = "SELECT es.*, e.FULL_NAME FROM EMPLOYEE e JOIN EMPLOYEE_SALARY es ON (e.NIK=es.NIK) WHERE e.NIK = :nik", nativeQuery = true)
	EmployeeSalaryData findDetail(@Param("nik") String nik) throws Exception;

}
