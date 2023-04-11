package com.kuroneko23.bookmarket.Controller;

import com.kuroneko23.bookmarket.Model.Book;
import com.kuroneko23.bookmarket.Model.BookRequest;
import com.kuroneko23.bookmarket.Repository.AccountRepository;
import com.kuroneko23.bookmarket.Repository.BookRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@RestController
public class BookController {
    private static final String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";
    private final BookRepository repository;

    public BookController(BookRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/book/add") //https://www.baeldung.com/spring-boot-thymeleaf-image-upload
    public ResponseEntity<?> Add(@RequestBody BookRequest req, @RequestParam MultipartFile file){
        String uuid = UUID.randomUUID().toString();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, uuid);
        try {
            Files.write(fileNameAndPath, file.getBytes());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to save image");
        }

        Book newBook = new Book();
        newBook.setCategory(req.getCategory());
        newBook.setPrice(req.getPrice());
        newBook.setDescription(req.getDescription());
        newBook.setImage(uuid);

        repository.save(newBook);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/book/edit")
    public ResponseEntity<?> Edit(@RequestBody Book req, @RequestParam MultipartFile file){
        Optional<Book> checkBook = repository.findById(String.valueOf(UUID.fromString(req.getUuid())));
        if(checkBook.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        String uuid = req.getImage();
        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, uuid);
        try {
            Files.write(fileNameAndPath, file.getBytes());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to save image");
        }

        repository.save(req);

        return ResponseEntity.ok().build();
    }
}
