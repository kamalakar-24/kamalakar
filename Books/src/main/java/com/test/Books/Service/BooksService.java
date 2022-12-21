package com.test.Books.Service;

import java.util.List;

import com.test.Books.Entity.Books;

public interface BooksService {
	
	Books save (Books book);
	Books update(Books id);
	List<Books> getAll();
	String delete(Long id);

}
