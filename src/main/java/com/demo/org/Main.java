package com.demo.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        // This runs the main application
        SpringApplication.run(Main.class, args);
    //  System.out.println("Hello Dum Dums");
    }

    // decorators starting with "*Mapping" indicates that these methods will be exposed to the port
    @GetMapping("/")
    public String home() {
        return "<h1>ceci est ma page d'accueil!</h1>";
    }

    // This method returns a JSON response. We did this, just by using MyRestResponse as the return type for this method
    @GetMapping("/rest")
    public MyRestResponse sample() {
        return new MyRestResponse("ceci est une réponse en REST");
    }
    // Then we used this line to introduce the return type mentioned in the above method
    record MyRestResponse(String sample){}
}
