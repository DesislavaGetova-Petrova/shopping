package softuni.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.model.entity.CategoryName;
import softuni.model.entity.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("select SUM(p.price) from Product p")
    BigDecimal findTotalProductsSum();

    List<Product> findAllByCategory_Name(CategoryName categoryName);
}
