package softuni.service;

import softuni.model.entity.CategoryName;
import softuni.model.service.ProductServiceModel;
import softuni.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    Object findAllItems();

    void add(ProductServiceModel productServiceModel);

    BigDecimal getTotalSum();

    List<ProductViewModel>  findAllProductsByCategory(CategoryName categoryName);

}
