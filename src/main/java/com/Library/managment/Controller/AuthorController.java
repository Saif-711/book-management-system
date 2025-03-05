package com.Library.managment.Controller;

import com.Library.managment.Model.Author;
import com.Library.managment.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @GetMapping("/show-author-detail-by-id")
    public ResponseEntity<Author> getAuthorDetails(@RequestParam Integer id) {
        return authorService.getAuthorDetails(id);
    }
    @PostMapping("/add-author")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete-author/{id}")
    public ResponseEntity<Author>deleteAuthor(@PathVariable("id") Integer id ){
        boolean isDeleted=authorService.deleteAuthorById(id);
        if(isDeleted){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/update-author/{id}")
    public ResponseEntity<Author>updateAuthor(@PathVariable("id") Integer id, @RequestBody Author author) {
        return authorService.updateAuthor(id, author);
    }

}
