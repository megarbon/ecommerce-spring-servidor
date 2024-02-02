package es.ecommerce.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.context.annotation.ComponentScan;


@RestController
//@ComponentScan(basePackages = "es.ecommerce.controller.*")

public class SampleController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String demo() {
                return "Endpoint Funcional";
    }
}