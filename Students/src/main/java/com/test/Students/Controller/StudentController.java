package com.test.Students.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.Students.Entity.Student;
import com.test.Students.Service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentService studentservice;

	@PostMapping("/save")
	public Student save(@RequestBody Student student) {
		return studentservice.save(student);
	}

	@PutMapping("/update")
	public Student update(@RequestBody Student id) {
		return studentservice.update(id);
	}

	@GetMapping("/getAll")
	public List<Student> getAll() {
		return studentservice.getAll();
	}

	@DeleteMapping("/delete")
	public String dekete(@PathVariable Long id) {
		return studentservice.delete(id);
	}
	@GetMapping("/getStudent/{id}")
	public Student isStudentAvailable(@PathVariable Long id) {
		return studentservice.isStudentAvailable(id);
		
	}
}
