package com.Reto4.repository.crud;

import com.Reto4.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProductCrudRepository extends MongoRepository<Product, String>{

}
