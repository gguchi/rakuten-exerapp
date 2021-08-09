package com.rakuten.rakutenweb.controller;
import com.rakuten.rakutenweb.model.Product;
import com.rakuten.rakutenweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
@Controller
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("productList", service.listAll());
        return "index";
    }

    @GetMapping("/newProductForm")
    public String newProductForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "newproduct";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("newproduct") Product product){
        service.save(product);
        return "redirect:/";
    }

    @GetMapping("/showUpdateForm/{id}")
    public String showUpdateForm(@PathVariable (value = "id") long id, Model model){
        Product product = service.getProductByID(id);
        model.addAttribute("product", product);
        return "updateproduct";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable (value = "id") long id){
        this.service.deleteProductByID(id);
        return "redirect:/";
    }

}