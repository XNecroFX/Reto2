package com.Reto3.repository.crud;

import com.Reto3.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductCrudRepository extends MongoRepository<Product, String>{

}
