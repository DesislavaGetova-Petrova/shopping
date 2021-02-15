package softuni.service;

import softuni.model.service.ProductServiceModel;

public interface ProductService {
    Object findAllItems();

    void addItem(ProductServiceModel productServiceModel);
}
