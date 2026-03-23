package com.javalearning.cli;

import java.util.Scanner;
import java.util.List;

public class ModernJavaCLI {
    
    // 1. Uso de Records (Java 14+) - Define objetos inmutables en una sola línea. 
    // Mágico reemplazo para los molestos auto Getters/Setters antiguos.
    public record Persona(String nombre, int edad) {}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        run(scanner);
        scanner.close();
    }

    public static void run(Scanner scanner) {
        System.out.println("\n=======================================================");
        System.out.println("   JAVA MODERNO: RECORDS Y STREAMS SIMPLIFICADOS");
        System.out.println("=======================================================");
        
        System.out.println("\n[1] RECORDS (Moldes limpios y veloces)");
        System.out.println("Creamos una persona llamada 'Maria' usando 'record Persona(String nombre, int edad) {}'");
        Persona persona = new Persona("Maria", 25);
        System.out.println("Resultado Automático: " + persona);
        
        System.out.println("\n[2] TUBERÍAS DE LISTAS (Streams API)");
        System.out.println("Vamos a registrar un grupo de 3 personas y usaremos Java Moderno para evaluarlos.");
        
        List<Persona> grupo = List.of(
            new Persona("Maria", 25),
            new Persona("Juanito", 15),
            new Persona("Victor", 30)
        );
        
        System.out.println("Lista base creada: " + grupo);
        System.out.print("\n-> Presiona ENTER para aplicar un FÍLTRO que extraiga SÓLO a los mayores de edad (edad >= 18): ");
        scanner.nextLine();
        
        System.out.println("\n[FILTRANDO UTILIZANDO '.stream().filter()' ...]");
        
        grupo.stream()
            .filter(per -> per.edad() >= 18)
            .forEach(per -> System.out.println("   + Mayores de edad detectado: " + per.nombre() + " (Edad " + per.edad() + ")"));
               
        System.out.println("\nNota cómo 'Juanito' con 15 años fue evadido automáticamente por el filtro.");
        System.out.println("\n=======================================================");
        System.out.println("Presiona Enter para terminar el laboratorio...");
        if(scanner.hasNextLine()) scanner.nextLine();
    }
}
