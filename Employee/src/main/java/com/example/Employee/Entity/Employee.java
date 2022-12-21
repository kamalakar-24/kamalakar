package com.example.Employee.Entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
@Table(	name = "Employee", 
uniqueConstraints = { 
		@UniqueConstraint(columnNames = "empEmail") 
	})
@Transactional
public class Employee {
	
	
	@Override
	public int hashCode() {
		return Objects.hash(cmpName, empAddress, empEmail, empId, empJoin, empName, empQualification, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(cmpName, other.cmpName) && Objects.equals(empAddress, other.empAddress)
				&& Objects.equals(empEmail, other.empEmail) && Objects.equals(empId, other.empId)
				&& Objects.equals(empJoin, other.empJoin) && Objects.equals(empName, other.empName)
				&& Objects.equals(empQualification, other.empQualification) && Objects.equals(salary, other.salary);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;
	
	@NotBlank(message = "plz enter empName")
	private String empName;
	
	@NotBlank(message = "plz enter cmpName")
	private String cmpName;
	
	@NotNull(message = "plz enter salary")
	private Float salary;
	
	@NotBlank(message = "plz enter empAddress")
	private String empAddress;
	
	@NotBlank(message = "plz enter empQualification")
	private String empQualification;
	
	@Email
	@NotBlank
	@Size (min=4, max=25)
	private String empEmail;
	
	@NotNull
	@JsonFormat(pattern="yyyy-MM-DD")
	private String empJoin;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCmpName() {
		return cmpName;
	}

	public void setCmpName(String cmpName) {
		this.cmpName = cmpName;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpQualification() {
		return empQualification;
	}

	public void setEmpQualification(String empQualification) {
		this.empQualification = empQualification;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpJoin() {
		return empJoin;
	}

	public void setEmpJoin(String empJoin) {
		this.empJoin = empJoin;
	}

}
