package com.geekbrains.webapp.springwebapp.services;

import com.geekbrains.webapp.springwebapp.model.Product;
import com.geekbrains.webapp.springwebapp.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    public Product findById(Long id) {
        return productsRepository.findById(id);
    }

    public void save(Product product) {
        productsRepository.save(product);
    }

    /*public void plusPrice(Long id) {
        productsRepository.plusPrice(id);
    }

    public void minusPrice(Long id) {
        productsRepository.minusPrice(id);
    }*/
}
