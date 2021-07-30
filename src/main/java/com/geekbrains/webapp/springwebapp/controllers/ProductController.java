package com.geekbrains.webapp.springwebapp.controllers;

import com.geekbrains.webapp.springwebapp.model.Product;
import com.geekbrains.webapp.springwebapp.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    private ProductsService productsService;

    @Autowired
    public ProductController(ProductsService productsService) {
        this.productsService = productsService;
    }

    // root = http://localhost:8189/app

    // GET [http://localhost:8189/app]/show_all
    @GetMapping("/show_all")
    public String showProductsPage(Model model) {
        model.addAttribute("products", productsService.findAll());
        return "products";
    }

    // GET [http://localhost:8189/app]/show/{id}
    @GetMapping("/show/{id}")
    public String showProductsPage(Model model, @PathVariable Long id) {
        model.addAttribute("product", productsService.findById(id));
        return "product_info";
    }

    @GetMapping("/create")
    public String showCreateForm() {
        return "create_product";
    }

    @PostMapping("/create")
    public String saveProduct(@RequestParam Long id, @RequestParam String name, @RequestParam int price) {
        Product product = new Product(id, name, price);
        productsService.save(product);
        return "redirect:/show_all";
    }
}
