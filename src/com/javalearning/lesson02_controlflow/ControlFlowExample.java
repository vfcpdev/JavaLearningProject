package com.javalearning.lesson02_controlflow;

/**
 * Clase de ejemplo para la Lección 2: Control de Flujo.
 * Aquí mostramos el uso de condicionales (If) y ciclos (for, while), switch.
 */
public class ControlFlowExample {

    /**
     * Muestra ejemplos básicos de estructuras de control.
     */
    public void runExamples() {
        System.out.println("=== Lección 2: Control Flow (if, loops, switch) ===");

        // 1. Estructura Condicional: if/else
        int num = 10;
        if (num > 5) {
            System.out.println(num + " es mayor que 5.");
        } else {
            System.out.println(num + " no es mayor que 5.");
        }

        // 2. Ciclo: for
        System.out.print("Conteo (for): ");
        for (int i = 1; i <= 3; i++) {
            System.out.print(i + " ");
        }
        System.out.println(); // Salto de línea

        // 3. Estructura: Switch expression (Java moderno)
        int day = 3;
        String dayName = switch (day) {
            case 1 -> "Lunes";
            case 2 -> "Martes";
            case 3 -> "Miércoles";
            default -> "Otro día";
        };
        System.out.println("Día seleccionado: " + dayName);
        System.out.println();
    }
}
