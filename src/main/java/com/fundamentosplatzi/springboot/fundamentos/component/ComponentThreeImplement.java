package com.fundamentosplatzi.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
class ComponentThreeImplement implements ComponentDependecy{

    @Override
    public void saludar() {
        System.out.println("Callese o lo meo");
    }
}
