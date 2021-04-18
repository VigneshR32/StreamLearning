package com.test;

import com.polymorphism.Animal;
import com.polymorphism.Lion;

public class TestPoly {
    public static void main(String[] args) {
        Animal a = new Lion();
        a.makeSound();
        a.walk();
        Animal animal = new Animal();
        animal.walk();
        animal.swim();
        animal.makeSound();
        Lion lion = new Lion();
        lion.makeSound();
        lion.walk();
        lion.swim();
        lion.carniVores();
    }
}
