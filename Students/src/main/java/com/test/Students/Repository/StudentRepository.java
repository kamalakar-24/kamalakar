package com.test.Students.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.Students.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
