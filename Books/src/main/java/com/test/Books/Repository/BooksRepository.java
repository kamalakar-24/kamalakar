package com.test.Books.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.Books.Entity.Books;

@Repository
public interface BooksRepository extends JpaRepository<Books, Long>{

}
