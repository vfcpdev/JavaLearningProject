package com.javalearning.lesson05_advanced;

import java.util.Arrays;
import java.util.List;

/**
 * Clase de ejemplo para la Lección 5: Temas Avanzados.
 * Streams, Expresiones Lambda, Excepciones.
 */
public class AdvancedExample {

    /**
     * Demostración de excepciones y streams.
     */
    public void runExamples() {
        System.out.println("=== Lección 5: Advanced (Streams, excepciones, generics) ===");

        // 1. Excepciones: Try - Catch
        try {
            System.out.println(10 / 0);
        } catch (ArithmeticException e) {
            System.out.println("Excepción capturada: No se puede dividir por cero.");
        }

        // 2. API de Streams (Java 8+) y Expresiones Lambda
        List<String> names = Arrays.asList("Carlos", "Pedro", "Ana", "Carmen");
        
        System.out.print("Nombres que empiezan con C usando Streams: ");
        
        // Operación funcional: filtrar e imprimir
        names.stream()
             .filter(name -> name.startsWith("C")) // Lambda Expression
             .forEach(name -> System.out.print(name + " ")); // Stream iteración
        
        System.out.println();
        System.out.println();
    }
}
