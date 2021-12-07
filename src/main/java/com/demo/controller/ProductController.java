package com.demo.controller;

import com.demo.model.Product;
import com.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ModelAndView getProducts() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("products");
        List<Product> products = productService.listProducts();
        modelAndView.addObject("products", products);
        return modelAndView;
    }


    @GetMapping("/new")
    public ModelAndView newProduct() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("new_product");
        Product product = new Product();
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveProduct(@ModelAttribute Product product) {
        productService.save(product);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editProduct(@PathVariable long id) {
        ModelAndView modelAndView = new ModelAndView();
        Product product = productService.get(id);
        modelAndView.setViewName("edit_product");
        modelAndView.addObject("product", product);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteProduct(@PathVariable long id) {
        productService.delete(id);
        return new ModelAndView("redirect:/");
    }
}
