package com.Library.managment.Service;

import com.Library.managment.Model.Author;
import com.Library.managment.Model.Book;
import com.Library.managment.Repo.AuthorRepo;
import com.Library.managment.Repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private AuthorRepo authorRepo;
    public void addBook(Book book) {
        bookRepo.save(book);
    }

    public Book getBook(int id) {
        Optional<Book> book=bookRepo.findById(id);
        return book.orElse(null);
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public void updateBook(Integer id, Book book) {
        Optional<Book> existingBook = bookRepo.findById(id);

        if (existingBook.isPresent()) {
            Book bookToUpdate = existingBook.get();

            // Update book details
            bookToUpdate.setTitle(book.getTitle());
            bookToUpdate.setIsbn(book.getIsbn());
            bookToUpdate.setPrice(book.getPrice());

            // Get the author associated with the book
            Author authorToUpdate = bookToUpdate.getAuthor();

            if (authorToUpdate != null) {
                // Update the author's name and biography
                authorToUpdate.setName(book.getAuthor().getName());
                authorToUpdate.setBiography(book.getAuthor().getBiography());

                // Explicitly save the updated Author
                authorRepo.save(authorToUpdate);  // Save the updated author entity
            }

            // Save the updated book entity
            bookRepo.save(bookToUpdate);  // Save the updated book
        } else {
            throw new RuntimeException("Book not found with id: " + id);
        }
    }


    public void deleteBook(Integer id) {
        bookRepo.deleteById(id);
    }
    //view books by categories
    public List<Book> getBooks(String title, String authorName, String isbn, Integer price) {
        if (title != null) {
            return bookRepo.getByTitle(title);
        } else if (authorName != null) {
            return bookRepo.getByAuthorName(authorName);
        } else if (isbn != null) {
            return bookRepo.getByIsbn(isbn);
        }else if(price != null){
            return bookRepo.getByPrice(price);
        }
        return bookRepo.findAll();
    }
}
