package com.kuroneko23.bookmarket.Controller;

import com.kuroneko23.bookmarket.Model.Account;
import com.kuroneko23.bookmarket.Model.AccountRequest;
import com.kuroneko23.bookmarket.Repository.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
public class AccountController {

    private final AccountRepository repository;

    public AccountController(AccountRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/account/login")
    public ResponseEntity<?> login(@RequestBody AccountRequest accountRequest){
        Optional<Account> account = repository.findByEmail(accountRequest.getEmail());
        if(account.isPresent()) {
            if(account.get().checkPassword(accountRequest.getPassword())) {
                return ResponseEntity.ok().body(account.get());
            } else {
                return new ResponseEntity<String>("Wrong email or password",HttpStatus.UNAUTHORIZED);
            }
        } else {
            return new ResponseEntity<String>("Wrong email or password",HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping("/account/register")
    public ResponseEntity<?> register(@RequestBody AccountRequest accountRequest){
        if(repository.findByEmail(accountRequest.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already exist!");
        }
        accountRequest.setHashedPassword(accountRequest.getPassword());
        Account newAccount = new Account();
        newAccount.setEmail(accountRequest.getEmail());
        newAccount.setHashedPassword(accountRequest.getPassword());
        newAccount.setRole("User");
        newAccount.setCreateDate(new Date());
        if(repository.save(newAccount) == newAccount) {
            return ResponseEntity.ok().body("Account created successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to create new account");
        }
    }
}
