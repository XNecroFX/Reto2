package com.Reto3.repository;

import com.Reto3.model.User;
import com.Reto3.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository {
    
    @Autowired
    private UserCrudRepository crudInterface;

    public List<User> listAll() {
        return (List<User>) crudInterface.findAll();
    }

    public Optional<User> getUser(int id) {
        return crudInterface.findById(id);
    }

    public User create(User user) {
        return crudInterface.save(user);
    }
    
    public void update(User user) {
        crudInterface.save(user);
    }
    
    public void delete(User user) {
        crudInterface.delete(user);
    }

    public boolean emailExists(String email) {
        Optional<User> usuario = crudInterface.findByEmail(email);
        
        return !usuario.isEmpty();
    }
    
    public Optional<User> authenticateUser(String email, String password) {
        return crudInterface.findByEmailAndPassword(email, password);
    }
    
    public Optional<User> lastUserId(){
        return crudInterface.findTopByOrderByIdDesc();
    }
}
