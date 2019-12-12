package com.example.conditional.conditionalOnClass;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Fa
 * @date 2019-11-19 18:58
 */
@Configuration
@ConditionalOnClass({Banana.class})
public class Van2Config {
    @Bean
    public Fighter banana(){
        return new Banana();
    }

    @Bean
    public Van van(){
        return new Van(banana());
    }
}