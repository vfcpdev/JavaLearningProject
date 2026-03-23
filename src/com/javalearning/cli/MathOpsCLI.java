package com.javalearning.cli;

import java.util.Scanner;

public class MathOpsCLI {
    public static void run(Scanner scanner) {
        System.out.println("\n--- Operaciones Matemáticas en Java ---");
        int a = 15;
        int b = 4;
        
        System.out.println("Variables base -> a = " + a + ", b = " + b);
        System.out.println("Suma (a + b): " + (a + b));
        System.out.println("Resta (a - b): " + (a - b));
        System.out.println("Multiplicación (a * b): " + (a * b));
        System.out.println("División Entera (a / b): " + (a / b));
        System.out.println("Módulo o Resto (a % b): " + (a % b));
        
        System.out.println("\nUso de la clase Math:");
        System.out.println("Raíz cuadrada de 25 (Math.sqrt(25)): " + Math.sqrt(25));
        System.out.println("Potencia 2^3 (Math.pow(2, 3)): " + Math.pow(2, 3));
        System.out.println("Valor máximo (Math.max(a, b)): " + Math.max(a, b));
        
        System.out.println("\nPresiona Enter para continuar...");
        scanner.nextLine();
        scanner.nextLine();
    }
}
