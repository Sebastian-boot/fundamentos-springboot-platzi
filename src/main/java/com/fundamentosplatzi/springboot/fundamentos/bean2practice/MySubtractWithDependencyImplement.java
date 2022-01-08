package com.fundamentosplatzi.springboot.fundamentos.bean2practice;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;

public class MySubtractWithDependencyImplement implements MySubtractWithDependency{

    private MySubtract  mySubtract;

    public MySubtractWithDependencyImplement(MySubtract mySubtract) {
        this.mySubtract = mySubtract;
    }

    @Override
    public void printDepdendency() {
        int numero = 10;
        System.out.println(mySubtract.subtract(numero));
        System.out.println("This is a message from my own Bean with a Dependency");
    }
}
