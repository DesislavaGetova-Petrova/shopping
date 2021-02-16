package softuni.service.impl;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.model.entity.CategoryName;
import softuni.model.entity.Product;
import softuni.model.service.ProductServiceModel;
import softuni.model.view.ProductViewModel;
import softuni.repository.ProductRepository;
import softuni.service.CategoryService;
import softuni.service.ProductService;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

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
    public void add(ProductServiceModel productServiceModel) {
        Product product=this.modelMapper.map(productServiceModel,Product.class);
        product.setCategory(this.categoryService.findByCategoryName(productServiceModel.getCategory()));
        this.productRepository.saveAndFlush(product);

                }

    @Override
    public BigDecimal getTotalSum() {
        return this.productRepository.findTotalProductsSum();
    }

    @Override
    public List<ProductViewModel> findAllProductsByCategory(CategoryName categoryName) {
        return productRepository.findAllByCategory_Name(categoryName)
                .stream().map(product -> modelMapper.map(product, ProductViewModel.class))
                .collect(Collectors.toList());
    }
}
