package com.Reto2.repository.crud;

import com.Reto2.model.User;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserCrudRepository extends MongoRepository<User, Integer> {
    
    public Optional<User> findByEmail(String email);

    public Optional<User> findByEmailAndPassword(String email, String password);
}
