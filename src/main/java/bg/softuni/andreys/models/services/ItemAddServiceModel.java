package bg.softuni.andreys.models.services;

import bg.softuni.andreys.models.entities.enums.CategoryEnums;
import bg.softuni.andreys.models.entities.enums.GenderEnums;

import java.math.BigDecimal;

public class ItemAddServiceModel {
    private Long id;
    private String name;
    private String description;
    private CategoryEnums category;
    private GenderEnums gender;
    private BigDecimal price;

    public ItemAddServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public ItemAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ItemAddServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemAddServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public CategoryEnums getCategory() {
        return category;
    }

    public ItemAddServiceModel setCategory(CategoryEnums category) {
        this.category = category;
        return this;
    }

    public GenderEnums getGender() {
        return gender;
    }

    public ItemAddServiceModel setGender(GenderEnums gender) {
        this.gender = gender;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemAddServiceModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
