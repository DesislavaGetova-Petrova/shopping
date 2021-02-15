package softuni.service.impl;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.model.entity.Product;
import softuni.model.service.ProductServiceModel;
import softuni.repository.ProductRepository;
import softuni.service.CategoryService;
import softuni.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Object findAllItems() {
        return null;
    }

    @Override
    public void addItem(ProductServiceModel productServiceModel) {
        Product product=this.modelMapper.map(productServiceModel,Product.class);
        product.setCategory(this.categoryService.findByCategoryName(productServiceModel.getCategory().getName()));
        this.productRepository.saveAndFlush(product);

                }
}
