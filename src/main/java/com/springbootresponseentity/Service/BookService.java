package com.springbootresponseentity.Service;

import com.springbootresponseentity.Entity.Book;
import com.springbootresponseentity.Repository.BookRepo;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class BookService {

    private final BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book saveBook(Book book){
        return this.bookRepo.save(book);
    }

    public List<Book> saveAllBook(List<Book> bookList){
        return this.bookRepo.saveAll(bookList);
    }
    public List<Book> getBook(){
        return this.bookRepo.findAll();
    }

    public Optional<Book> getById(int id){
        return this.bookRepo.findById(id);
    }

    public Book updateBook(Book book){
        return this.bookRepo.save(book);
    }

    public void deleteBookById(int id){
        this.bookRepo.deleteById(id);
    }
}
