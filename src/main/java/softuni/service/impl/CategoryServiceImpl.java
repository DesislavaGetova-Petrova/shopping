package softuni.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.model.entity.Category;
import softuni.model.entity.CategoryName;
import softuni.repository.CategoryRepository;
import softuni.service.CategoryService;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initCategories() {
        if(categoryRepository.count()==0){
            Arrays.stream(CategoryName.values())
                    .forEach((categoryName -> {
                        this.categoryRepository
                                .save(new Category(categoryName,
                                        String.format("Description for %s",categoryName.name())));
                    }));
        }
    }

    @Override
    public Category findByCategoryName(CategoryName categoryName) {
        return this.categoryRepository.findByName(categoryName)
                .orElse(null);
    }

}
