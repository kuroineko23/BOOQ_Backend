package com.kuroneko23.bookmarket.Controller;

import com.kuroneko23.bookmarket.Model.Category;
import com.kuroneko23.bookmarket.Model.CategoryRequest;
import com.kuroneko23.bookmarket.Repository.CategoryRepository;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {
    private static final String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/uploads";
    private final CategoryRepository repository;

    public CategoryController(CategoryRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/category/add")
    public ResponseEntity<?> Add(@RequestBody CategoryRequest req) {
        Category category = new Category();
        category.setCategory(req.getCategory());
        category.setDescription(req.getDescription());

        repository.save(category);

        return ResponseEntity.ok("Data saved");
    }

    @PutMapping("/category/edit")
    public ResponseEntity<?> Edit(@RequestBody Category req) {
        repository.save(req);

        return ResponseEntity.ok("Data saved");
    }

    @DeleteMapping("/category/delete")
    public ResponseEntity<?> Delete(@RequestBody Category req) {
        repository.delete(req);

        if(repository.findById(req.getUuid()).isEmpty()) {
            return ResponseEntity.ok("Data deleted");
        } else {
            return ResponseEntity.internalServerError().body("Fail to delete data");
        }
    }
}
