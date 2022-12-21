package com.example.Employee.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService empservice;

	@PostMapping("/save")
	public ResponseEntity save(@RequestBody Employee employee) {
		empservice.save(employee);
		ResponseEntity response = new ResponseEntity("You'r Record is saved successfully", HttpStatus.CREATED);
		return response;
	}

	@PutMapping("/update")
	public ResponseEntity update(@RequestBody Employee empId) {
		empservice.update(empId);
		ResponseEntity response = new ResponseEntity("You'r Record is updated Successfuly", HttpStatus.OK);
		return response;
	}

	@DeleteMapping("/deleteEmployee/{empId}")
	public String delete(@PathVariable Long empId) {
		return empservice.delete(empId);
	}

	@GetMapping("/getEmployees")
	public ResponseEntity<Employee> getEmployees() {
		List<Employee> employeeList = empservice.getEmployees();
		ResponseEntity response = new ResponseEntity(employeeList, HttpStatus.OK);
		return response;
	}

	@PostMapping("/saveEmployees")
	public ResponseEntity<Employee> saveEmployees(@RequestBody List<Employee> employee) {
		List<Employee> employees = empservice.saveEmployees(employee);
		ResponseEntity response = new ResponseEntity(employees, HttpStatus.CREATED);
		return response;
	}

	@GetMapping("/getEmployee/{email}")
	public ResponseEntity basedOnMail(@PathVariable String email) {
		Employee employee = empservice.basedOnMail(email);
		ResponseEntity response = new ResponseEntity(employee, HttpStatus.OK);
		return response;
	}

	@GetMapping("/getEmployeebasedOnId/{empId}")
	public ResponseEntity getEmployeebasedOnId(@PathVariable Long empId) {
		Employee employee = empservice.getEmployeebasedOnId(empId);
		ResponseEntity response = new ResponseEntity(employee, HttpStatus.OK);
		return response;
	}

	@GetMapping("/basedOnSalary")
	public ResponseEntity<Employee> basedOnSalary() {
		List<Employee> employee = empservice.basedOnSalary();
		ResponseEntity response = new ResponseEntity(employee, HttpStatus.OK);
		return response;
	}
//	@GetMapping("/basedOnCompanyNameAndEmail/cmpName/{cmpname}/Email/{email}")
//	public ResponseEntity basedOnCompanyNameAndEmail(@PathVariable String cmpname , @PathVariable String email){
//	Employee employee	=empservice.basedOnCompanyNameAndEmail(cmpname, email);
//		ResponseEntity response = new ResponseEntity(employee , HttpStatus.OK);
//		return response;

//	}

	@DeleteMapping("/deleteEmployees/{empIds}")
	public ResponseEntity deleteEmployees(@PathVariable List<Long> empIds) {
		String emp = empservice.deleteEmployees(empIds);
		ResponseEntity response = new ResponseEntity(emp, HttpStatus.OK);
		return response;
	}

	@PostMapping("/basedOnName/{empName}")
	public ResponseEntity<Map<String, String>> basedOnName(@PathVariable String empName) {
		List<Map<String, String>> emp = empservice.basedOnName(empName);
		ResponseEntity response = new ResponseEntity(emp, HttpStatus.OK);
		return response;

	}
}
