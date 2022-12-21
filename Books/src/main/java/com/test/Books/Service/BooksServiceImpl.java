package com.test.Books.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.Books.Entity.Books;
import com.test.Books.Repository.BooksRepository;

@Service
public class BooksServiceImpl implements BooksService {

	@Autowired
	BooksRepository bookrepo;

	@Override
	public Books save(Books book) {
		return bookrepo.save(book);
	}

	@Override
	public Books update(Books id) {
		Optional<Books> book = bookrepo.findById(id.getId());
		if (book.isPresent()) {
			if (book.get().getId() == id.getId()) {
				return bookrepo.save(id);
			}
		}
		return id;
	}

	@Override
	public List<Books> getAll() {

		return bookrepo.findAll();
	}
 
	@Override
	public String delete(Long id) {
		bookrepo.deleteById(id);
		return "Your record is deleted successfully";
	}

}
