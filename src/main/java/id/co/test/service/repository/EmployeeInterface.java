package id.co.test.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import id.co.test.service.entity.Employee;

@Repository
public interface EmployeeInterface extends JpaRepository<Employee, String> {
	
    Employee findByNik(String nik) throws Exception;
    
    @Query(value = "SELECT * FROM EMPLOYEE WHERE nik LIKE %?1% OR full_name LIKE %?1%", nativeQuery = true)
    List<Employee> findBySearching(String search) throws Exception;
}
