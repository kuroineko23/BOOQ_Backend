package com.kuroneko23.bookmarket.Repository;

import com.kuroneko23.bookmarket.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BookRepository extends JpaRepository<Book, String> {
}
