package com.javalearning.cli;

import java.util.Scanner;
import java.time.Year;

public class MathOpsCLI {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        run(scanner);
        scanner.close();
    }
    
    public static void run(Scanner scanner) {
        System.out.println("\n=======================================================");
        System.out.println("   MÓDULO 2 SENCILLO: ARITMÉTICA Y EDADES (CLI)");
        System.out.println("=======================================================");
        
        System.out.println("En este ejercicio usaremos la resta matemática básica de Java '-'.");
        
        int currentYear = Year.now().getValue();
        
        System.out.print("\n>>> Por favor, ingresa tu código aritmético (Año de Nacimiento Ej: 1995): ");
        String textInput = scanner.nextLine();
        
        try {
            int birthYear = Integer.parseInt(textInput);
            
            // Operación matemática súper sencilla
            int resultAge = currentYear - birthYear;
            
            System.out.println("\n[SISTEMA JVM CALCULANDO...]");
            System.out.println("Fórmula interna: " + currentYear + " - " + birthYear);
            System.out.println("\n¡Tu edad apróximada en el periodo contable actual es de: " + resultAge + " años!");
            
        } catch(NumberFormatException e) {
            System.out.println("\n[ERROR]: El procesador matemático de Java no puede restar letras o símbolos.");
        }
        
        System.out.println("\n=======================================================");
        System.out.println("Presiona Enter finalizar el laboratorio y volver...");
        if(scanner.hasNextLine()) scanner.nextLine();
    }
}
