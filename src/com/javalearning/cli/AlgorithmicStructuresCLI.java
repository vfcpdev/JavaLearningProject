package com.javalearning.cli;

import java.util.Scanner;

public class AlgorithmicStructuresCLI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        run(scanner);
        scanner.close();
    }

    public static void run(Scanner scanner) {
        System.out.println("\n=======================================================");
        System.out.println("   MÓDULO 5: ESTRUCTURAS ALGORIÍTMICAS (INTERACTIVO)");
        System.out.println("=======================================================");
        
        System.out.println("\n[ 1. ASIGNACIÓN (=) ]");
        System.out.println("En programación, el signo igual (=) no significa equidad matemática.");
        System.out.println("Significa 'ASIGNAR' el valor de la derecha a la variable de la izquierda.");
        System.out.print(">>> Asigna un número límite (Ej: 7) para nuestro constructor: ");
        
        int limiteElegido = 5;
        try { limiteElegido = Integer.parseInt(scanner.nextLine().trim()); } catch(Exception e) {}
        System.out.println("-> CÓDIGO INYECTADO: int limite = " + limiteElegido + ";");

        System.out.println("\n[ 2. CONDICIÓN lógica (if / else) ]");
        System.out.println("El programa va a bifurcar su camino dependiendo del número asignado.");
        System.out.println("-> CÓDIGO EJECUTANDO: if (limite > 10) { ... } else { ... }");
        
        if (limiteElegido > 10) {
            System.out.println("-> RESULTADO IF: Como " + limiteElegido + " es mayor a 10, ejecutamos el bloque VERDADERO.");
        } else {
            System.out.println("-> RESULTADO ELSE: Como " + limiteElegido + " NO es mayor a 10, ejecutamos el bloque FALSO.");
        }

        System.out.println("\n[ 3. REPETICIÓN Cíclica (Ciclo FOR) ]");
        System.out.println("El FOR es el rey de la automatización. Le diremos a Java que cuente automáticamente");
        System.out.println("desde el número 1 hasta terminar en el límite " + limiteElegido + " que tú asignaste.");
        System.out.println("\n-> CÓDIGO EJECUTANDO: for (int i = 1; i <= limite; i++) { ... }");
        System.out.println("Arrancando turbinas del Bucle...");
        
        for (int i = 1; i <= limiteElegido; i++) {
            System.out.println("  [✔] Bucle FOR en el ciclo actual: variable 'i' vale " + i);
            try { Thread.sleep(350); } catch(Exception e) {} // Pausa teatral de 350ms para ver la repetición
        }
        
        System.out.println("-> FIN DEL BUCLE FOR: La condición (i <= " + limiteElegido + ") ya no se cumple.");

        System.out.println("\n=======================================================");
        System.out.println("Tres piezas fundamentales del universo Java evidenciadas.");
        System.out.println("Presiona Enter para finalizar y volver al Menú Principal...");
        if(scanner.hasNextLine()) scanner.nextLine();
    }
}
