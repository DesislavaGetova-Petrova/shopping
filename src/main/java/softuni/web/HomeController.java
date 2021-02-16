package softuni.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.model.entity.CategoryName;
import softuni.service.ProductService;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {

        if (httpSession.getAttribute("user") == null) {
            return "index";
        } else {
            model.addAttribute("totalSum", productService.getTotalSum());
            model.addAttribute("drinks", productService.findAllProductsByCategory(CategoryName.DRINK));
            model.addAttribute("food", productService.findAllProductsByCategory(CategoryName.FOOD));
            model.addAttribute("household", productService.findAllProductsByCategory(CategoryName.HOUSEHOLD));
            model.addAttribute("other", productService.findAllProductsByCategory(CategoryName.OTHER));
            return "home";
        }
    }
}
