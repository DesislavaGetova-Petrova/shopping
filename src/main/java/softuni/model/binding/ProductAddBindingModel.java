package softuni.model.binding;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import softuni.model.entity.CategoryName;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddBindingModel {
    private String name;
    private String description;
    private LocalDateTime neededBefore;
    private BigDecimal price;
    private CategoryName category;

    public ProductAddBindingModel() {
    }
    @NotBlank
    @Size(min=3,max=20, message = "Name must be between 3 and 20 characters!")
    public String getName() {
        return name;
    }

    public ProductAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }
    @Size(min=5, message = "Description must be more then 5 characters!")
    public String getDescription() {
        return description;
    }

    public ProductAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    @DateTimeFormat( pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent (message = "The date cannot be in the past")
    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public ProductAddBindingModel setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }
    @DecimalMin(value ="0",message = "Enter valid price")
    public BigDecimal getPrice() {
        return price;
    }

    public ProductAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
    @NotNull(message = "Enter valid category name")
    public CategoryName getCategory() {
        return category;
    }

    public ProductAddBindingModel setCategory(CategoryName category) {
        this.category = category;
        return this;
    }
}
