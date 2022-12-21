package com.example.Employee.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Repository.EmployeeRepository;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository emprepo;

	@Override
	public Employee save(Employee employee) {
		
		return emprepo.save(employee);
	}

	@Override
	public Employee update(Employee empId) {
		Optional<Employee> emp = emprepo.findById(empId.getEmpId());
		if (emp.isPresent()) {
			if (emp.get().getEmpId() == empId.getEmpId()) {
				return emprepo.save(empId);
			}

		}
		return empId;
	}

	@Override
	public String delete(Long empId) {
		emprepo.deleteById(empId);
		return "your Record Is Deleted Succeessfully";
	}

	@Override
	public List<Employee> getEmployees() {
		return emprepo.findAll();
	}

	@Override
	public List<String> getCompanyNames() {
		List<String> names = new ArrayList<>();
		List<Employee> emp = emprepo.findAll();
		for (Employee employee : emp) {
			names.add(employee.getCmpName());
		}

		return names;
	}

	@Override
	public List<Employee> saveEmployees(List<Employee> employee) {

		return emprepo.saveAll(employee);
	}

	@Override
	public Employee basedOnMail(String email) {

		Optional<Employee> optionEmployee = emprepo.findByempEmail(email);
		Employee employee = optionEmployee.get();
		System.out.println(employee);
		return employee;

		// This another way logic but this is not correct Because findall method will
		// check all employees then unnecessary we checking all the employees (server
		// also get late by checking all employees)
//		List<Employee> emp2= new ArrayList<>();
//		List<Employee> emp=	emprepo.findAll();
//		for (Employee employee : emp) {
//			if(employee.getEmpEmail().equals(email)) {
//			emp2.add(employee)	;
//			}else {
//				"You'r Email adress is Not Found In Database";
//			}
//		}

	}

	@Override
	public Employee getEmployeebasedOnId(Long empId) {
		Optional<Employee> emp = emprepo.findByempId(empId);
		Employee emp2 = emp.get();
		System.out.println(emp2);
		return emp2;

		// This another way logic but this is not correct Because findall method will
		// check all employees then unnecessary we checking all the employees (server
		// also get late by checking all employees)
//		List<Employee> emp2 = new ArrayList<>();
//		List<Employee> emp = emprepo.findAll();
//		for (Employee employee : emp) {
//			if (employee.getEmpId().equals(empId)) {
//				emp2.add(employee);
//			}
//		}

	}

	@Override
	public List<Employee> basedOnSalary() {
		List<Employee> emp = new ArrayList<>();
		List<Employee> employee = emprepo.findAll();
		for (Employee employee2 : employee) {
			if (employee2.getSalary() >= 70000) {
				emp.add(employee2);
			}
		}
		return emp;
	}

//	@Override
//	public Employee basedOnCompanyNameAndEmail(String cmpname, String email) {
//		
//		Optional<Employee> employee = emprepo.findByCompanyNameAndEmail(cmpname, email);
//		Employee emp2 = employee.get();
//		System.out.println(emp2);
//		return emp2;
//		
//	}

	@Override
	public String deleteEmployees(List<Long> empIds) {
		emprepo.deleteAllById(empIds);
		return "You'r Records are deleted successfully";
	}

	@Override
	public List<Map<String, String>> basedOnName(String empName) {
		List<Map<String, String>> emp2 = new ArrayList<>();
		Map<String, String> emp4 = new HashMap<>();
		List<Employee> employee = emprepo.findAll();
		for (Employee employee2 : employee) {
			emp4.put("cmpName", employee2.getCmpName());
			emp4.put("empAddress", employee2.getEmpAddress());
			emp2.add(emp4);
		}
		return emp2;
	}

}
