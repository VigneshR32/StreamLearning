package com.polymorphism;

public class Peacock extends Animal{
    @Override
    public void makeSound() {
        System.out.println("Ahavum");
    }

    @Override
    public void walk() {
        System.out.println("Flies");
    }

    public void eat(){
        System.out.println("Eat");
    }
}
