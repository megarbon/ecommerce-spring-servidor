package es.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import org.springframework.context.annotation.ComponentScan;

@RestController
// @ComponentScan(basePackages = "es.ecommerce.controller.*")

@RequestMapping("/")
public class SampleController {

    @GetMapping("hola")
    public String sayHello() {
        return "Esta mierda funciona, salu2.";
    }
}