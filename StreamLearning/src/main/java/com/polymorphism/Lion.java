package com.polymorphism;

public class Lion extends Animal{

    @Override
    public void makeSound() {
        System.out.println("Roar");
    }

    @Override
    public void walk() {
        super.walk();
    }

    public void carniVores(){
        System.out.println("Carnivores");
    }
}
