
package com.Reto2.repository.crud;

import com.Reto2.model.Product;
import com.Reto2.model.User;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface ProductCrudRepository extends MongoRepository<Product, String>{
    
    public List<Product> findByPriceLessThanEqual(double price);

    public List<Product> findByCategory(String category);

    /*@Query("{'nombre':{'$regex':'?0','$options':'i'}}")
    public List<Product> findByNombreLike(String nombre);*/
}
