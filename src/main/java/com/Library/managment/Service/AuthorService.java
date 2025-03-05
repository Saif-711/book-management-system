package com.Library.managment.Service;

import com.Library.managment.Model.Author;
import com.Library.managment.Repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepo authorRepo;
    public ResponseEntity<Author> getAuthorDetails(Integer id) {
        Optional<Author> author = authorRepo.findById(id);
        if(author.isPresent()) {
            return new ResponseEntity<>(author.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public void addAuthor(Author author) {
        authorRepo.save(author);
    }

    public boolean deleteAuthorById(Integer id) {
        for(Author author: authorRepo.findAll()) {
            if(author.getId().equals(id)) {
                authorRepo.delete(author);
                return true;
            }
        }
        return false;
    }
    public ResponseEntity<Author>updateAuthor(Integer id,Author author) {
        Optional<Author> author1 = authorRepo.findById(id);
        boolean isExist = authorRepo.existsById(id);
        if(isExist) {
            Author author2=author1.get();
            author2.setName(author.getName());
            author2.setBiography(author.getBiography());
            authorRepo.save(author2);
            return new ResponseEntity<>(author2, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
