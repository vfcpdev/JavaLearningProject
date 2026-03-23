package com.javalearning.cli;

import java.util.Scanner;

// Clases dentro de CLI para el ejemplo
class Vehiculo {
    protected String marca;
    public Vehiculo(String marca) { this.marca = marca; }
    public void pitar() { System.out.println("Vehículo " + marca + " hace: ¡Beep beep!"); }
}

class Coche extends Vehiculo {
    private String modelo;
    public Coche(String marca, String modelo) { super(marca); this.modelo = modelo; }
    @Override
    public void pitar() { System.out.println("Coche " + marca + " " + modelo + " hace: ¡Boooooop!"); }
}

public class OOPCLI {
    public static void run(Scanner scanner) {
        System.out.println("\n--- Programación Orientada a Objetos (POO) ---");
        System.out.println("\n1. CLASES Y OBJETOS");
        System.out.println("Las clases son diagramas/plantillas y los objetos son las instancias de estas clases.");
        Vehiculo v1 = new Vehiculo("Genérico");
        System.out.print("  -> Instancia de Vehículo: ");
        v1.pitar();
        
        System.out.println("\n2. HERENCIA Y POLIMORFISMO");
        System.out.println("La herencia permite a una clase 'Coche' heredar atributos de 'Vehiculo'.");
        System.out.println("El polimorfismo permite reescribir métodos con el mismo nombre y diferente comportamiento.");
        Coche miCoche = new Coche("Toyota", "Corolla");
        System.out.print("  -> Instancia de Coche (Herencia): ");
        miCoche.pitar();
        
        System.out.println("\nPresiona Enter para volver...");
        scanner.nextLine();
        scanner.nextLine();
    }
}
