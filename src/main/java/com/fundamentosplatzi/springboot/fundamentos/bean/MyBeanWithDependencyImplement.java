package com.fundamentosplatzi.springboot.fundamentos.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWhitDependency() {
        LOGGER.info("Hemos ingresado printWithDependecy");
        int numero=1;
        LOGGER.debug("El numero enviado para la operación es: "+ numero);
        System.out.println(myOperation.sum(numero));
        System.out.println("Hola Desde un Bean con dependecia");

    }
}
