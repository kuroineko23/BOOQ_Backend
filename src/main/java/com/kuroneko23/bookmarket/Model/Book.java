package com.kuroneko23.bookmarket.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "uuid", updatable = false, nullable = false, columnDefinition = "NVARCHAR(36)")
    private String uuid;
    @Column(columnDefinition = "NVARCHAR(36)")
    private String owner;
    @Column(columnDefinition = "NVARCHAR(36)")
    private String category;
    @Column(columnDefinition = "NVARCHAR(250)")
    private String author;
    @Column(columnDefinition = "NVARCHAR(36)")
    private String image;
    @Column(columnDefinition = "int")
    private int qty;
    @Column(columnDefinition = "NVARCHAR(250)")
    private String title;
    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String description;
    @Digits(integer = 12, fraction = 2)
    @Column(columnDefinition = "decimal(12,2)")
    private BigDecimal price;

    public Book() {
    }

    //region Getter Setter
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    //endregion
}
