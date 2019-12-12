package com.example.conditional.conditionalOnClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Fa
 * @date 2019-11-19 18:56
 */
@SpringBootApplication
public class SbfunApplication implements CommandLineRunner {

    @Autowired
    private Van van;

    public static void main(String[] args) {
        SpringApplication.run(SbfunApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //do something
        van.fight();
    }
}