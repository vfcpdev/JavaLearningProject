package com.javalearning.cli;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;

public class StandardContainersCLI {
    public static void run(Scanner scanner) {
        System.out.println("\n--- Contenedores Estándar de Datos (Contexto de Infraestructura y SO) ---");
        
        System.out.println("\n1. LISTAS Y ARREGLOS (ArrayList) -> Nodos de Balanceo de Carga");
        ArrayList<String> balancerIps = new ArrayList<>();
        balancerIps.add("10.0.0.51");
        balancerIps.add("10.0.0.52");
        System.out.println("  -> IPs activas en el Load Balancer: " + balancerIps);
        
        System.out.println("\n2. PILAS (Stacks - LIFO) -> Historial de Navegador Web (El clásico botón 'Atrás')");
        Stack<String> webHistory = new Stack<>();
        System.out.println("  -> Simulación automática: Navegando profundo en la web (PUSH de Páginas)...");
        for (int i = 1; i <= 6; i++) {
            webHistory.push("Dirección " + i);
            System.out.println("     Visitando nueva URL: " + webHistory.peek());
        }
        
        System.out.println("  -> Memoria temporal de navegación retenida en RAM: " + webHistory);
        System.out.print("  -> (EJERCICIO) Oprime Enter para dar clic al botón 'ATRÁS' tres veces (Extracción Pop por LIFO)...");
        scanner.nextLine();
        
        System.out.println("     1. Pop: Cerramos (" + webHistory.pop() + "). Ahora ves la " + webHistory.peek());
        System.out.println("     2. Pop: Cerramos (" + webHistory.pop() + "). Ahora ves la " + webHistory.peek());
        System.out.println("     3. Pop: Cerramos (" + webHistory.pop() + "). Ahora ves la " + webHistory.peek());
        System.out.println("  -> Historial actual remanente tras aplicar reversión continua LIFO: " + webHistory);
        
        System.out.println("\n3. COLAS (Queues - FIFO) -> Gestor de Descargas Múltiples del Navegador");
        Queue<String> managerDescargas = new LinkedList<>();
        System.out.println("  -> Empujando peticiones de descarga (OFFER)...");
        managerDescargas.offer("Instalador_JDK_21.exe");
        managerDescargas.offer("Juego_Steam.zip");
        managerDescargas.offer("Documento_Guia.pdf");
        System.out.println("  -> Línea de descargas procesándose por orden de llegada (El primero en iniciar es el primero en acabar): " + managerDescargas);
        System.out.println("  -> Servidor completando al 100% y sacando la primera petición de la fila (POLL): [" + managerDescargas.poll() + "]");
        System.out.println("  -> Servidor completando la siguiente (POLL): [" + managerDescargas.poll() + "]");
        System.out.println("  -> Peticiones todavía esperando en la memoria Queue: " + managerDescargas);
        
        System.out.println("\n4. COLAS DE PRIORIDAD (Priority Queues) -> Planificador de Procesos (Scheduler)");
        PriorityQueue<Integer> scheduler = new PriorityQueue<>();
        // Simulando PID y Prioridad (Prioridad 1 = Root/Kernel, 50 = Usuario estándar)
        scheduler.offer(50); // Proceso de usuario regular
        scheduler.offer(1);  // Proceso crítico del Kernel
        scheduler.offer(20); // Servicio de red local
        System.out.println("  -> Procesos en cola con niveles de prioridad (1, 50, 20).");
        System.out.println("  -> El planificador CPU (Scheduler) otorga poder al hilo con MAYOR prioridad (menor constante '1'): Se atendió Nivel " + scheduler.poll());
        
        System.out.println("\nPresiona Enter para volver al Menú...");
        scanner.nextLine();
        scanner.nextLine();
    }
}
