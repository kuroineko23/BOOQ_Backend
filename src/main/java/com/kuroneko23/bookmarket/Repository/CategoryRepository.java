package com.kuroneko23.bookmarket.Repository;

import com.kuroneko23.bookmarket.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
