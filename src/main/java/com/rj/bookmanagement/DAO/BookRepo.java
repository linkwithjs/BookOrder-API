package com.rj.bookmanagement.DAO;

import org.springframework.data.repository.CrudRepository;
import com.rj.bookmanagement.Model.Book;

public interface BookRepo extends CrudRepository<Book, Integer> {
    public Book findById(int id);
}
