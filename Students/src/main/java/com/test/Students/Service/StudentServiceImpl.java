package com.test.Students.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Students.Entity.Student;
import com.test.Students.Repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepo;
	
	
	Logger  logger = org.slf4j.LoggerFactory.getLogger(StudentServiceImpl.class);

	@Override
	public Student save(Student student) {

		return studentRepo.save(student);
	}

	@Override
	public Student update(Student id) {
		Optional<Student> student = studentRepo.findById(id.getId());
		if (student.isPresent()) {
			if (id.getId() == student.get().getId()) {
				studentRepo.save(id);
			}
		}
		return id;
	}

	@Override
	public List<Student> getAll() {

		return studentRepo.findAll();
	}

	@Override
	public String delete(Long id) {
		studentRepo.deleteById(id);
		return "Your record is deleted successfully";
	}

	@Override
	public Student isStudentAvailable(Long id) {
		logger.info("LoadBalancingTest : "+id);
//		System.out.println("LoadBalancingTest : "+id);
		Optional<Student> student = studentRepo.findById(id);
		Student student1 = null;
		if (student != null) {
			student1 = student.get();
		}
		return student1;

	}

}
