package com.fundamentosplatzi.springboot.fundamentos.configuration;

import com.fundamentosplatzi.springboot.fundamentos.bean2practice.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyOwnConfiguration {
    @Bean
    public ToPractice toPractice() {
        return new ToPracticeDependency();
    }

    @Bean
    public MySubtract mySubtract() {
        return new MySubtractImplement();
    }

    @Bean
    public MySubtractWithDependency mySubtractWithDependency(MySubtract mySubtract ) {
        return new MySubtractWithDependencyImplement(mySubtract);
    }

}
