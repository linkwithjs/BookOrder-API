package com.rj.bookmanagement.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.rj.bookmanagement.DAO.BookRepo;
import com.rj.bookmanagement.Model.Book;

@Component
public class BookService {
    // private static List<Book> list = new ArrayList<>();
    // static {
    // list.add(new Book(12, "Java Complete Ref.", "Js", 25, 2000));
    // list.add(new Book(13, "Java Code Ref.", "James", 50, 15000));
    // list.add(new Book(14, "Java Tut Ref.", "David", 10, 500));
    // }

    @Autowired
    private BookRepo bookRepo;

    // get all books
    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookRepo.findAll();
        System.out.println("books>> " + list);
        return list;
    }

    // get single book by id
    public Book getBookById(int id) {
        Book book = null;
        try {
            book = this.bookRepo.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    // adding the book
    public Book addBook(Book b) {
        Book result = bookRepo.save(b);
        return result;
    }

    // Delete a book
    public void deleteBook(int bid) {
        System.out.println("book id is: " + bid);
        bookRepo.deleteById(bid);
    }

    // Update book
    public void updateBook(Book book, int bookId) {
        book.setId(bookId);
        bookRepo.save(book);
    }

}
