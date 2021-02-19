package bg.softuni.andreys.models.binding;

import bg.softuni.andreys.models.entities.enums.CategoryEnums;
import bg.softuni.andreys.models.entities.enums.GenderEnums;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ItemAddBindingModel {

    private String name;
    private String description;
    private CategoryEnums category;
    private GenderEnums gender;
    private BigDecimal price;

    public ItemAddBindingModel() {
    }

    @NotBlank
    @Size(min = 3, message = "Username length must be more than two characters")
    public String getName() {
        return name;
    }

    public ItemAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    @NotBlank
    @Size(min = 4, message = "Description length must be more than three characters")
    public String getDescription() {
        return description;
    }

    public ItemAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @NotNull(message = "Category must be selected")
    public CategoryEnums getCategory() {
        return category;
    }

    public ItemAddBindingModel setCategory(CategoryEnums category) {
        this.category = category;
        return this;
    }

    @NotNull(message = "Gender must be selected")
    public GenderEnums getGender() {
        return gender;
    }

    public ItemAddBindingModel setGender(GenderEnums gender) {
        this.gender = gender;
        return this;
    }

    @DecimalMin(value = "0", message = "Must be a positive number")
    public BigDecimal getPrice() {
        return price;
    }

    public ItemAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
}
