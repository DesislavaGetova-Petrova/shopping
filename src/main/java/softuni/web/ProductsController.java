package softuni.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.model.binding.ProductAddBindingModel;
import softuni.model.service.ProductServiceModel;
import softuni.service.ProductService;

import javax.validation.Valid;

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
                model.addAttribute("productAddBindingModel",new ProductAddBindingModel());            }
            return "product-add";
        }
    @PostMapping("/add")
    public String addConfirm(@Valid @ModelAttribute("productAddBindingModel") ProductAddBindingModel productAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel",bindingResult);
            return "redirect:add";
        }
        this.productService.addItem(this.modelMapper.map(productAddBindingModel, ProductServiceModel.class));
        return  "redirect:/";
    }
}
