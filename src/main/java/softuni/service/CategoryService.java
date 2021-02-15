package softuni.service;

import softuni.model.entity.Category;
import softuni.model.entity.CategoryName;

public interface CategoryService {
    void initCategories();

    Category findByCategoryName(CategoryName categoryName);
}
