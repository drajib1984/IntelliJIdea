package com.springbootresponseentity.Controller;

import com.springbootresponseentity.Entity.Book;
import com.springbootresponseentity.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @PostMapping("/book")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        Book book1=null;
        try {
            book1=bookService.saveBook(book);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/books")
    public List<Book> saveAllBook(@RequestBody List<Book> bookList){
        return this.bookService.saveAllBook(bookList);
    }

    @GetMapping("/book")
    public ResponseEntity<List<Book>> getBook(){
        List<Book> books=bookService.getBook();
        if (books.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(books));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Optional<Book>> getById(@PathVariable int id){
       Optional<Book> book = bookService.getById(id);
        if (!book.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }
    @PutMapping("/book")
    public Book updateBook(@RequestBody Book book){
        return this.bookService.saveBook(book);
    }
    @DeleteMapping("/book/{id}")
    public void  deleteById(@PathVariable int id){
        this.bookService.deleteBookById(id);
    }

}
