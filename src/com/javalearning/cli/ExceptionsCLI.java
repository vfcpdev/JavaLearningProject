package com.javalearning.cli;

import java.util.Scanner;

public class ExceptionsCLI {
    public static void run(Scanner scanner) {
        System.out.println("\n--- Manejo de Excepciones ---");
        System.out.println("\nEn Java podemos prevenir que el programa se cuelgue al haber errores, usando Bloques Try-Catch.");
        
        System.out.println("Simulando una división por cero (ArithmeticException):");
        try {
            int division = 10 / 0;
            System.out.println(division);
        } catch (ArithmeticException e) {
            System.out.println("  -> [Excepción Capturada]: No se puede dividir por cero. Mensaje del sistema: " + e.getMessage());
        }
        
        System.out.println("\nSimulando acceso a índice de arreglo no existente (ArrayIndexOutOfBoundsException):");
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("  -> [Excepción Capturada]: Intentaste acceder a una posición fuera del arreglo.");
        } finally {
            System.out.println("  -> [Bloque Finally]: Este código siempre se ejecuta, haya ocurrido o no el error.");
        }
        
        System.out.println("\nPresiona Enter para volver...");
        scanner.nextLine();
        scanner.nextLine();
    }
}
