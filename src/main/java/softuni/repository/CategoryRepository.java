package softuni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.model.entity.Category;
import softuni.model.entity.CategoryName;

import java.util.Optional;

@RequestMapping
public interface CategoryRepository extends JpaRepository<Category,String> {
    Optional<Category> findByName(CategoryName categoryName);
}
