package com.javalearning.cli;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class DataStructuresCLI {
    public static void main(String[] args) {
        java.util.Scanner s = new java.util.Scanner(System.in);
        run(s);
    }

    public static void run(Scanner scanner) {
        System.out.println("\n--- Estructuras de Datos en Java ---");
        
        System.out.println("1. Arreglos (Arrays):");
        System.out.println("Son estructuras de tamaño fijo que albergan elementos del mismo tipo.");
        int[] numeros = {10, 20, 30};
        System.out.println("Array 'numeros' índice 0: " + numeros[0]);
        System.out.println("Longitud del array: " + numeros.length);
        
        System.out.println("\n2. ArrayList (Listas dinámicas):");
        System.out.println("A diferencia de los Arrays, un ArrayList puede cambiar de tamaño en tiempo de ejecución.");
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Java");
        lista.add("Python");
        lista.add("C++");
        System.out.println("Lista completa inicial: " + lista);
        lista.remove("Python");
        System.out.println("Lista después de remover 'Python': " + lista);
        
        System.out.println("\n3. HashMap (Diccionarios / Clave-Valor):");
        System.out.println("Almacena datos en pares de Clave y Valor.");
        HashMap<String, Integer> edades = new HashMap<>();
        edades.put("Ana", 25);
        edades.put("Juan", 30);
        System.out.println("Mapa de edades: " + edades);
        System.out.println("Edad de Ana: " + edades.get("Ana"));
        
        System.out.println("\nPresiona Enter para continuar...");
        scanner.nextLine();
        scanner.nextLine();
    }
}
