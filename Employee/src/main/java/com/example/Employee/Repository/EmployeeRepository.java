package com.example.Employee.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Employee.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	Optional<Employee> findByempEmail(String email);
	Optional<Employee > findByempId(Long empId);
//	Optional<Employee> findByCompanyNameAndEmail(String cmpname, String email);

}
