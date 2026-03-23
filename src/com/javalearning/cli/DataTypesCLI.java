package com.javalearning.cli;

import java.util.Scanner;

public class DataTypesCLI {
    public static void run(Scanner scanner) {
        System.out.println("\n--- Tipos de Datos en Java ---");
        System.out.println("En Java, todas las variables deben tener un tipo de dato declarado.");
        System.out.println("Hay dos categorías principales: Primitivos y No Primitivos (Objetos).");
        
        System.out.println("\nTipos Primitivos:");
        byte b = 100;
        short s = 10000;
        int i = 100000;
        long l = 10000000000L;
        float f = 10.5f;
        double d = 20.99;
        boolean bool = true;
        char c = 'A';
        
        System.out.println("1. byte: Entero de 8 bits. Ejemplo: " + b);
        System.out.println("2. short: Entero de 16 bits. Ejemplo: " + s);
        System.out.println("3. int: Entero de 32 bits (muy usado). Ejemplo: " + i);
        System.out.println("4. long: Entero de 64 bits. Ejemplo: " + l);
        System.out.println("5. float: Decimal de 32 bits. Ejemplo: " + f);
        System.out.println("6. double: Decimal de 64 bits (doble precisión). Ejemplo: " + d);
        System.out.println("7. boolean: Verdadero/Falso. Ejemplo: " + bool);
        System.out.println("8. char: Un solo carácter. Ejemplo: " + c);
        
        System.out.println("\nTipos No Primitivos (Ejemplo String):");
        String texto = "Hola Mundo";
        System.out.println("- String: Secuencia de caracteres. Ejemplo: " + texto);
        
        System.out.println("\nPresiona Enter para continuar...");
        scanner.nextLine(); // Consume previous newline if any
        scanner.nextLine();
    }
}
