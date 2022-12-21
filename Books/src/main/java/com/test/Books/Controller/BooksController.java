package com.test.Books.Controller;

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

import com.test.Books.Entity.Books;
import com.test.Books.Entity.Student;
import com.test.Books.FeignServiceUtil.FeignService;
import com.test.Books.Service.BooksService;


@RestController
@RequestMapping("/books")
public class BooksController {

	@Autowired
	BooksService bookservice;
	
	@Autowired
	FeignService feignService;

	@PostMapping("/save")
	public Books save(@RequestBody Books book) {
		Books book1= new Books();
		Student student=new Student();
	Student student1=	feignService.isStudentAvailable(student.getId());
	if(student1!=null) {
		book1.setAuthorName(book.getAuthorName());
		book1.setContent(book.getContent());
		book1.setName(book.getName());
		book1.setPrice(book.getPrice());
		book1.setStudent(student1);
	 bookservice.save(book1);
		
	}
	return book1;
	}

	@PutMapping("/update")
	public Books update(@RequestBody Books id) {
		return bookservice.update(id);
	}

	@GetMapping("/getAll")
	public List<Books> getAll() {
		return bookservice.getAll();
	}

	@DeleteMapping("/delete")
	public String delete(@PathVariable Long id) {
		return bookservice.delete(id);
	}

	@GetMapping("/getStudent/{id}")
	public Student isStudentAvailable(@PathVariable Long id) {
		return feignService.isStudentAvailable(id);
	}
}
