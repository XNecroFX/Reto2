package com.Reto4.service;

import com.Reto4.model.User;
import com.Reto4.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserRepository repositorio;
    
    public List<User> listAll() {
        return repositorio.listAll();
    }

    public Optional<User> getUser(int id) {
        
        return repositorio.getUser(id);
    }

    public User create(User user) {
        
        Optional<User> userIdMaximo = repositorio.lastUserId();
        
        if (user.getId() == null) {
            if (userIdMaximo.isEmpty())
                user.setId(1);
            else
                user.setId(userIdMaximo.get().getId() + 1);
        }
        
        Optional<User> e = repositorio.getUser(user.getId());
        if (e.isEmpty()) {
            if (emailExists(user.getEmail())==false){
                return repositorio.create(user);
            }else{
                return user;
            }
        }else{
            return user;
        }
        
    }

    public User update(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = repositorio.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
                
                repositorio.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    
    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            repositorio.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public boolean emailExists(String email) {
        return repositorio.emailExists(email);
    }

    public User authenticateUser(String email, String password) {
        Optional<User> usuario = repositorio.authenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }
}