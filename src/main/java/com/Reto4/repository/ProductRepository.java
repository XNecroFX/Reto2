package com.Reto4.repository;

import com.Reto4.model.Product;
import com.Reto4.repository.crud.ProductCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
   @Autowired
    private ProductCrudRepository crudInterface;

    public List<Product> getAll() {
        return crudInterface.findAll();
    }

    public Optional<Product> getProduct(String reference) {
        return crudInterface.findById(reference);
    }

    public Product create(Product product) {
        return crudInterface.save(product);
    }

    public void update(Product product) {
        crudInterface.save(product);
    }

    public void delete(Product product) {
        crudInterface.delete(product);
    }
}