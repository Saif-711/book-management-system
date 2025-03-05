package com.Library.managment.Controller;

import com.Library.managment.Model.Book;
import com.Library.managment.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping("/add-book")
    public String addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return "Added Book Successfuly";
    }
    @GetMapping("get-book")
    public Book getBook(@RequestParam int id) {
        return bookService.getBook(id);
    }
    @GetMapping("/show-all")
    public List<Book> getAllBooks(){
       return bookService.getAllBooks();
    }
    @PutMapping("/update-Book/{id}")
    public String updataBook(@PathVariable("id") Integer id,@RequestBody Book book){
        bookService.updateBook(id,book);
        return "Updated Successfully";
    }
    @DeleteMapping("/delete-book")
    public ResponseEntity<String> deleteBook(@RequestParam("id") Integer id){
        bookService.deleteBook(id);
        return ResponseEntity.ok("Deleted Successfully");
    }
    @GetMapping("/view-books")
    public ResponseEntity<List<Book>>viewBooks(
            @RequestParam(required=false) String title,
            @RequestParam(required=false) String author,
            @RequestParam(required = false)String isbn,
            @RequestParam(required=false)Integer price
    )
    {
        return new ResponseEntity<>(bookService.getBooks(title,author,isbn,price), HttpStatus.OK);
    }


}
