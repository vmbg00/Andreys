package bg.softuni.andreys.models.entities;

import bg.softuni.andreys.models.entities.enums.CategoryEnums;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    private CategoryEnums name;
    private String description;

    public Category() {
    }

    @Enumerated(value = EnumType.STRING)
    public CategoryEnums getName() {
        return name;
    }

    public Category setName(CategoryEnums name) {
        this.name = name;
        return this;
    }

    @Column(columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
