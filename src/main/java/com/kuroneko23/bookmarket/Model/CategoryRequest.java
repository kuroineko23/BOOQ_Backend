package com.kuroneko23.bookmarket.Model;

import jakarta.persistence.Column;

public class CategoryRequest {
    private String category;
    private String description;

    //region Getter Setter
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //endregion
}
