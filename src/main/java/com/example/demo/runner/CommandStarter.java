package com.example.demo.runner;

import com.example.demo.entity.Client;
import com.example.demo.entity.Product;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandStarter implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        Client client = new Client();
        client.setFirstName("Georgi");
        client.setLastName("Georgiev");
        client.setAge(30);
        Client savedClient =  clientRepository.save(client);




        Product car = new Product();
        car.setBrand("Lexus");
        car.setModel("GS");
        car.setManufacturerId(12);
        car.setClient(savedClient);

        productRepository.save(car);


    }
}
