package com.fundamentosplatzi.springboot.fundamentos.bean2practice;

public class ToPracticeDependency implements ToPractice{

    @Override
    public void message() {
        System.out.println("This is a message from my own Dependency");
    }
}
