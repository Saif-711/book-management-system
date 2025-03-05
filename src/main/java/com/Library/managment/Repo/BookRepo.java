package com.Library.managment.Repo;

import com.Library.managment.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,Integer> {
    List<Book> getByTitle(String title);
    @Query("SELECT b from Book b where b.author.name=:name")
    List<Book>getByAuthorName(@Param("name") String author);
    List<Book>getByIsbn(String isbn);
    List<Book>getByPrice(Integer price);
}