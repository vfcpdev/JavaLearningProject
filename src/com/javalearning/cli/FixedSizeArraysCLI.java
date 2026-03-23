package com.javalearning.cli;

import java.util.Arrays;
import java.util.Scanner;

public class FixedSizeArraysCLI {
    public static void main(String[] args) {
        java.util.Scanner s = new java.util.Scanner(System.in);
        run(s);
    }

    public static void run(Scanner scanner) {
        System.out.println("\n--- Arreglos de Tamaño Fijo y Matrices ---");
        
        System.out.println("\n1. DECLARACIÓN E INICIALIZACIÓN");
        int[] notas = new int[5]; // Declaración definiendo tamaño
        notas[0] = 100; // Uso de la variable para evitar warning del IDE
        int[] edades = {20, 25, 30, 22, 28}; // Declaración con inicialización directa
        System.out.println("  -> Se han inicializado en memoria dos arreglos (notas[0]=" + notas[0] + " y edades).");
        
        System.out.println("\n2. RECORRIDO DE ARREGLOS");
        System.out.print("  -> Edades registradas usando ciclo 'for' estándar: ");
        for (int i = 0; i < edades.length; i++) {
            System.out.print(edades[i] + (i < edades.length - 1 ? ", " : ""));
        }
        System.out.println();
        
        System.out.println("\n3. UTILIDADES ESTÁNDAR (java.util.Arrays)");
        Arrays.sort(edades);
        System.out.println("  -> Edades tras aplicar 'Arrays.sort()': " + Arrays.toString(edades));
        
        System.out.println("\n4. CÁLCULO DE LA DESVIACIÓN ESTÁNDAR");
        double sum = 0;
        for (int edad : edades) sum += edad; 
        double media = sum / edades.length; // Cálculo de media
        
        double varianzaSum = 0;
        for (int edad : edades) varianzaSum += Math.pow(edad - media, 2);
        double stdDev = Math.sqrt(varianzaSum / edades.length); // Desviación Estándar
        System.out.println("  -> Media del grupo: " + media);
        System.out.println("  -> Desviación Estándar del conjunto: " + stdDev);
        
        System.out.println("\n5. ARREGLOS DE DOS DIMENSIONES (Matrices)");
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6}
        };
        System.out.println("  -> Matriz 2x3 inicializada. El elemento en la posición [1][2] (Fila 2, Columna 3) es: " + matriz[1][2]);
        
        System.out.println("\n6. ARREGLOS DE N DIMENSIONES (Multidimensionales)");
        int[][][] cubo = new int[2][2][2];
        cubo[0][1][1] = 42;
        System.out.println("  -> Arreglo 3D creado. Valor manual insertado en cubo[0][1][1]: " + cubo[0][1][1]);
        
        System.out.println("\nPresiona Enter para volver a la pantalla inicial...");
        scanner.nextLine();
        scanner.nextLine();
    }
}
