package com.javalearning.cli;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;

public class StandardContainersCLI {
    public static void run(Scanner scanner) {
        System.out.println("\n=== VISUALIZADOR CLI: EJECUCIÓN PASO A PASO (LIFO / FIFO) ===");
        
        System.out.println("\n--- [LIFO] EJECUTANDO: Pila / Stack (Historial Web) ---");
        Stack<String> webHistory = new Stack<>();
        System.out.println("  -> EXPLICACIÓN: Se inicializó el Stack genérico.");
        
        System.out.println("  -> CÓDIGO EJECUTANDOSE EN BUCLE: webHistory.push(\"Dirección \" + i);");
        for (int i = 1; i <= 3; i++) {
            webHistory.push("Dirección " + i);
            System.out.println("     ++ Inyectando PUSH O(1): " + webHistory.peek());
        }
        
        System.out.println("  -> ESTADO DE LA MEMORIA: " + webHistory);
        System.out.print("  -> (SIMULADOR) Oprime Enter para dar clic al botón 'ATRÁS' tres veces mediante CLI...");
        scanner.nextLine();
        
        for(int x = 1; x <= 3; x++) {
            System.out.println("\n>> LÍNEA EJECUTADA: String url = webHistory.pop();");
            System.out.println("   // EXPLICACIÓN: El método genérico destruye la posición superior de la Tabla de Pilas.");
            System.out.println("   -> Has pulsado Atrás (POP). Se esfumó temporalmente: [" + webHistory.pop() + "]");
            System.out.println("   -> Quedan remanentes: " + webHistory.size());
        }
        
        System.out.println("\n--- [FIFO] EJECUTANDO: Cola / Queue (Descargas Web) ---");
        Queue<String> managerDescargas = new LinkedList<>();
        System.out.println("   // EXPLICACIÓN: La Cola hereda Listas Enlazadas para respetar las posiciones de frente horizontal.");
        
        System.out.println("\n>> LÍNEA EJECUTADA: managerDescargas.offer(\"archivo.zip\");");
        managerDescargas.offer("Java_JDK.exe");
        managerDescargas.offer("Manual_PDF.pdf");
        System.out.println("   -> EXPLICACIÓN: Offer inyecta el valor AL FINAL de los nodos.");
        System.out.println("   -> RAM ACTUAL: " + managerDescargas);
        
        System.out.println("\n>> LÍNEA EJECUTADA: String completado = managerDescargas.poll();");
        System.out.println("   -> EXPLICACIÓN: Respetando el orden orgánico de llegada, finaliza mágicamente la descarga del primer archivo.");
        System.out.println("   -> DESCARGADO/PROCESADO: [" + managerDescargas.poll() + "]");
        System.out.println("   -> AÚN ESPERANDO: " + managerDescargas);
        
        System.out.println("\n>> LÍNEA EJECUTADA: PriorityQueue<Integer> pq = new PriorityQueue<>();");
        PriorityQueue<Integer> scheduler = new PriorityQueue<>();
        System.out.println("   // EXPLICACIÓN: Usando Cola de Prioridad. Procesará el número entero más pequeño sin importar su orden de llegada.");
        
        scheduler.offer(50); 
        scheduler.offer(1);  
        scheduler.offer(20); 
        System.out.println("\n>> LÍNEA EJECUTADA: scheduler.poll();");
        System.out.println("   -> RAM CARGADA CON: (50), (1), (20).");
        System.out.println("   -> PROCESO QUE TOMÓ LA DELANTERA (POLL DE PRIORIDAD 1 URGENCIA MÁXIMA): [" + scheduler.poll() + "]");
        
        System.out.println("\nPresiona Enter para cerrar el modo visualizador CLI devolviéndote al menú principal...");
        scanner.nextLine();
    }
}
