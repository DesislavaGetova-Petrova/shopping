package softuni.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.model.binding.ProductAddBindingModel;
import softuni.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductsController {


        private final ProductService productService;
        private final ModelMapper modelMapper;

        public ProductsController(ProductService productService, ProductService productService1, ModelMapper modelMapper) {
            this.productService = productService1;
            this.modelMapper = modelMapper;
        }

        @GetMapping("/add")
        public String add(Model model) {
            if(!model.containsAttribute("productAddBindingModel")){
                model.addAttribute("productAddBindingModel",new ProductAddBindingModel());
            }
            return "product-add";
        }
}
