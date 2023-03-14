package com.kendemescode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public GreetResponse greet(){
        GreetResponse response = new GreetResponse(
                "Hello Kendrick",
                List.of("Java", "Python", "Javascript"),
                new Person(
                        "Udeme",
                        24,
                        5000.00
                )
        );
        return response;
    }

    record Person(String name, int age, double cashAvailable){
    }
    record GreetResponse(
            String greet,
            List<String> favProgLang,
            Person person
    ){}
}
