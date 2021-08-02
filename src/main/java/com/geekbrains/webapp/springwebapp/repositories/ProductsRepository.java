package com.geekbrains.webapp.springwebapp.repositories;

import com.geekbrains.webapp.springwebapp.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductsRepository {
    private List<Product> products;

    @PostConstruct //подготовка списка продуктов при инициализации
    public void init() {
        this.products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Salt", 25),
                new Product(2L, "Bread", 40),
                new Product(3L, "Oil", 100),
                new Product(4L, "Сoffee", 190)
        ));
    }
//весь список
    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }
//выдача по ID
    public Product findById(Long id) {
        return products.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }
//добавление продукта
    public void save(Product product) {
        products.add(product);
    }

    public void plusPrice(Long id){
        products.stream().filter(s -> s.getId().equals(id)).findFirst().get().setPrice(products.stream().filter(s -> s.getId().equals(id)).findFirst().get().getPrice()+1);
    }

    public void minusPrice(Long id){
        products.stream().filter(s -> s.getId().equals(id)).findFirst().get().setPrice(products.stream().filter(s -> s.getId().equals(id)).findFirst().get().getPrice()-1);
    }


}
