package es.ecommerce.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import es.ecommerce.Controller.ClienteController;

@SpringBootApplication
@ComponentScan(basePackageClasses = ClienteController.class)
public class EcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

}
