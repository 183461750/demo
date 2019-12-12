package com.example.conditional.conditionalOnClass;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Fa
 * @date 2019-11-19 18:57
 */
@Configuration
@ConditionalOnClass({Billy.class})
public class VanConfig {

    @Bean
    public Fighter billy(){
        return new Billy();
    }

    @Bean
    public Van van(){
        return new Van(billy());
    }
}