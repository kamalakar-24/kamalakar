package com.test.Books.FeignServiceUtil;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.test.Books.Entity.Student;



@Service
@FeignClient(value="STUDENTS")
public interface FeignService {
	
	@GetMapping("/students/getStudent/{id}")
	public Student isStudentAvailable(@PathVariable Long id);
	

}
