package com.javalearning.lesson01_basics;

/**
 * Clase de ejemplo para la Lección 1: Fundamentos.
 * Aquí mostramos el uso de variables, tipos de datos primitivos y operadores.
 */
public class BasicsExample {

    /**
     * Muestra ejemplos de declaración de variables y operadores.
     */
    public void runExamples() {
        System.out.println("=== Lección 1: Basics (Variables, tipos, operadores) ===");
        
        // Declaración de variables de diferentes tipos de datos
        int age = 25;                  // Entero (int)
        double temperature = 36.5;     // Decimal (double)
        boolean isJavaFun = true;      // Booleano (boolean)
        char grade = 'A';              // Carácter (char)
        String name = "Estudiante";    // Cadena de texto (String - Clase, no primitivo)

        // Imprimir valores
        System.out.println("Nombre: " + name + " | Edad: " + age);
        
        // Operadores matemáticos básicos
        int a = 10;
        int b = 3;
        System.out.println("Suma (a + b): " + (a + b));
        System.out.println("Módulo (a % b): " + (a % b)); // Residuo de división
        System.out.println();
    }
}
