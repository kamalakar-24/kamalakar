package com.example.Employee.ServiceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Employee.Entity.Employee;
import com.example.Employee.Repository.EmployeeRepository;
import com.example.Employee.Service.EmployeeServiceImpl;

@SpringBootTest
public class EmployeeServiceTest {
	
	@InjectMocks
	EmployeeServiceImpl empservice;
	
	@Mock
	EmployeeRepository emprepo;
	
	@Test
	public void saveTest() {
		Employee employee= new Employee();
		employee.setCmpName("Cognizant");
		employee.setEmpAddress("Guntur");
		employee.setEmpEmail("tkr24@gmail.com");
		employee.setEmpJoin("2222-22-11");
		employee.setEmpName("Kamalakar");
		employee.setEmpQualification("B.tech");
		employee.setSalary(20000f);
		
		Mockito.when(emprepo.save(employee)).thenReturn(employee);
		Employee saveEmployee = empservice.save(employee);
		assertThat(saveEmployee.equals(saveEmployee));
	}
	@Test
	public void updateTest() {
		Employee employee = new Employee();
		
		employee.setCmpName("Cognizant");
		employee.setEmpAddress("Guntur");
		employee.setEmpEmail("tkr24@gmail.com");
		employee.setEmpJoin("2222-22-11");
		employee.setEmpName("Kamalakar");
		employee.setEmpQualification("B.tech");
		employee.setSalary(20000f);

			Optional<Employee> emp= Optional.of(employee);
			Mockito.when(emprepo.findById(employee.getEmpId())).thenReturn(emp);
			Employee saveEmployee = empservice.update(employee);
//			assertThat(saveEmployee.equals(employee));
			System.out.println("you Record is Updated");
			System.out.println(saveEmployee);
			System.out.println(employee);
			assertNotNull(saveEmployee);
	
	}
}
