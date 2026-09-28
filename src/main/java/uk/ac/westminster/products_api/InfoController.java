package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Week 1 stretch task (Activity 5).
 *   GET /info -> a short description of the application
 */

@RestController
public class InfoController {

    @GetMapping("/info")
    public String info(){
        return "Products API - 5COSC019W Object Oriented Programming, Tutorial 1 Spring Boot demo";
    }

}
