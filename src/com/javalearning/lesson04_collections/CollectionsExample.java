package com.javalearning.lesson04_collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Clase de ejemplo para la Lección 4: Colecciones en Java.
 * List, Set, Map.
 */
public class CollectionsExample {

    /**
     * Muestra las colecciones básicas.
     */
    public void runExamples() {
        System.out.println("=== Lección 4: Collections (Listas, mapas, conjuntos) ===");

        // 1. Array List: Mantiene orden, permite duplicados
        List<String> list = new ArrayList<>();
        list.add("Manzana");
        list.add("Naranja");
        list.add("Manzana"); 

        System.out.println("Lista (List): " + list);

        // 2. Hash Set: No mantiene orden, no permite duplicados
        Set<String> set = new HashSet<>(list); // Convertimos la lista a set
        System.out.println("Conjunto (Set): " + set); // Se eliminará la manzana extra

        // 3. Hash Map: Pares de Llave - Valor
        Map<String, Integer> studentGrades = new HashMap<>();
        studentGrades.put("Ana", 95);
        studentGrades.put("Luis", 80);
        
        System.out.println("Mapa (Map): " + studentGrades);
        System.out.println();
    }
}
