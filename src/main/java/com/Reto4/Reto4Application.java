package com.Reto4;

import com.Reto4.repository.crud.OrderCrudRepository;
import com.Reto4.repository.crud.ProductCrudRepository;
import com.Reto4.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Reto4Application implements CommandLineRunner {
    
    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private ProductCrudRepository productCrudRepository;
    @Autowired
    private OrderCrudRepository orderCrudRepository;

    public static void main(String[] args) {
	SpringApplication.run(Reto4Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
      System.out.println("Aqui se ejecutaran la creación de documentos de mongo...");
        
        userCrudRepository.deleteAll();
        productCrudRepository.deleteAll();  
    }
}