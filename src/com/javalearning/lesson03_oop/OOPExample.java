package com.javalearning.lesson03_oop;

/**
 * Superclase de ejemplo (Concepto de Herencia).
 */
class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println("Animal hace sonido");
    }
}

/**
 * Subclase de ejemplo (Hereda de Animal).
 * Demuestra herencia y polimorfismo.
 */
class Dog extends Animal {

    public Dog(String name) {
        super(name); // Llama al constructor de la superclase
    }

    @Override
    public void makeSound() {
        System.out.println(name + " hace: Guau Guau!");
    }
}

/**
 * Clase principal de ejemplo para la Lección 3: OOP.
 * Aquí probamos las Clases, herencia y polimorfismo.
 */
public class OOPExample {

    /**
     * Muestra instanciación de objetos y polimorfismo.
     */
    public void runExamples() {
        System.out.println("=== Lección 3: Programación Orientada a Objetos (OOP) ===");

        // Creación del objeto Dog, que hereda de Animal (Clases y herencia)
        Animal myDog = new Dog("Firulais"); 

        // Polimorfismo: myDog es tipo Animal, pero llama al makeSound de Dog
        myDog.makeSound();

        System.out.println("El encapsulamiento y otros principios se demostrarán después.");
        System.out.println();
    }
}
