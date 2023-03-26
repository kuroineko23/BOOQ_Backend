package com.kuroneko23.bookmarket.Model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "uuid", updatable = false, nullable = false, columnDefinition = "VARCHAR(36)")
    private String uuid;
    @Column(columnDefinition = "VARCHAR(36)")
    private String category;
    @Column
    private String image;
    @Column
    private String title;
    @Column
    private String altTitle;
    @Column
    private String description;
    @Column
    private BigDecimal price;
    @Column
    private Boolean isActive;
    @Column
    private Boolean isSoldOut;

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

    public String getAltTitle() {
        return altTitle;
    }

    public void setAltTitle(String altTitle) {
        this.altTitle = altTitle;
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Boolean getSoldOut() {
        return isSoldOut;
    }

    public void setSoldOut(Boolean soldOut) {
        isSoldOut = soldOut;
    }
    //endregion
}
