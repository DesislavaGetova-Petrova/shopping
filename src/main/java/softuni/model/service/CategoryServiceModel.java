package softuni.model.service;

import softuni.model.entity.CategoryName;

public class CategoryServiceModel extends BaseServiceModel{
    private CategoryName name;
    private String description;

    public CategoryServiceModel() {
    }

    public CategoryName getName() {
        return name;
    }

    public CategoryServiceModel setName(CategoryName name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
