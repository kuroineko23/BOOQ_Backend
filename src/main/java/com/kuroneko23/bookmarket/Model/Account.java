package com.kuroneko23.bookmarket.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "uuid", updatable = false, nullable = false, columnDefinition = "NVARCHAR(36)")
    private String uuid;
    @Column(name = "hashedPassword", updatable = true, nullable = false, columnDefinition = "NVARCHAR(61)")
    private String hashedPassword;
    @Column(columnDefinition = "NVARCHAR(250)")
    private String email;
    @Column(columnDefinition = "DATE")
    private Date updateDate;
    @Column(columnDefinition = "DATE")
    private Date createDate;

    @Column(columnDefinition = "NVARCHAR(10)")
    private String role;

    //region Constructor
    public Account(){}
    //endregion

    //region Getter Setter
    public String getUuid() {
        return uuid;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String password) {
        this.hashedPassword = password;
    }

    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.hashedPassword);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    //endregion
}
