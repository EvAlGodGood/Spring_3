package com.geekbrains.webapp.springwebapp.repositories;


import com.geekbrains.webapp.springwebapp.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class ProductsRepository {
    //private List<Product> products;
    private SessionFactory factory;


    @PostConstruct //подготовка списка продуктов при инициализации
    public void init() {//данная часть может выброшена, т.к. база наполняется из схемы БД, а можно сделать через Save
//        this.products = new ArrayList<>(Arrays.asList(//для внутреннего листа
//                new Product(1L, "Salt", 25),
//                new Product(2L, "Bread", 40),
//                new Product(3L, "Oil", 100),
//                new Product(4L, "Сoffee", 190)
//        ));

        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        //Session session = null;

//        работает
//        try (Session session = factory.getCurrentSession()) {
//            session.beginTransaction();
//            Product product = session.get(Product.class, 2L);
//            product.print();
//            session.getTransaction().commit();
//            session.close();
//
//
//
//        }

        //Не работает!!!
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Product> prods = session.createQuery("FROM productsall").getResultList();
            System.out.println(prods);
            session.getTransaction().commit();
            session.close();
        }



    }
//весь список
    public List<Product> findAll() {
        //return Collections.unmodifiableList(products);//для внутреннего листа
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("from products_all").getResultList();
            session.getTransaction().commit();
            session.close();
            return Collections.unmodifiableList(products);
        }

    }
//выдача по ID
    public Product findById(Long id) {
        //return products.stream().filter(s -> s.getId().equals(id)).findFirst().get();//для внутреннего листа

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product s = session.get(Product.class, id);
            session.getTransaction().commit();
            session.close();
            return s;
        }

    }
//добавление продукта
    public void save(Product prS) {
        //products.add(product);//для внутреннего листа
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.save(prS);
            session.getTransaction().commit();
            session.close();
        }
        //
    }

    /*public void plusPrice(Long id){
        //для внутреннего листа
        products.stream().filter(s -> s.getId().equals(id)).findFirst().get().setPrice(products.stream().filter(s -> s.getId().equals(id)).findFirst().get().getPrice()+1);
        //
    }

    public void minusPrice(Long id){
        //для внутреннего листа
        products.stream().filter(s -> s.getId().equals(id)).findFirst().get().setPrice(products.stream().filter(s -> s.getId().equals(id)).findFirst().get().getPrice()-1);
        //
    }*/


}
