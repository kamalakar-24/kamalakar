package com.test.Students.Service;

import java.util.List;

import com.test.Students.Entity.Student;

public interface StudentService {

	Student save(Student student);

	Student update(Student id);

	List<Student> getAll();

	String delete(Long id);

	Student isStudentAvailable(Long id);

//	List<Student> isStudentAvailable(Long id);

}
