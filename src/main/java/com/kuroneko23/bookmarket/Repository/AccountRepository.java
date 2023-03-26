package com.kuroneko23.bookmarket.Repository;

import com.kuroneko23.bookmarket.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, String> {
    public Optional<Account> findByEmail(String email);
}
