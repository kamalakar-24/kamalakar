package com.example.Employee.Service;

import java.util.List;
import java.util.Map;

import com.example.Employee.Entity.Employee;

public interface EmployeeService {
	
	Employee save(Employee employee);
	
	Employee update(Employee empId);
	
	String delete(Long empId);
	
	List<Employee> getEmployees();
	
	List<String > getCompanyNames();
	
	List<Employee> saveEmployees(List<Employee> employee);
	
	Employee basedOnMail(String email);
	
	Employee getEmployeebasedOnId (Long empId);
	
	List<Employee> basedOnSalary();
	
//	Employee basedOnCompanyNameAndEmail(String cmpname , String email);
	
	String deleteEmployees(List<Long> empIds);
	
	List<Map<String, String>> basedOnName(String empName);
	
	

}
