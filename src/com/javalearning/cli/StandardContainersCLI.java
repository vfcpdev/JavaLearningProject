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
        
        System.out.println("\n2. PILAS (Stacks - LIFO) -> Historial de Comandos de Terminal");
        Stack<String> bashHistory = new Stack<>();
        bashHistory.push("mkdir web_server");
        bashHistory.push("chmod 777 web_server");
        System.out.println("  -> Historial de la terminal bash: " + bashHistory);
        System.out.println("  -> ¡Ejecutando Ctrl+Z! Último comando revertido (pop): " + bashHistory.pop());
        System.out.println("  -> Historial actual remanente: " + bashHistory);
        
        System.out.println("\n3. COLAS (Queues - FIFO) -> Cola o Spooler de Impresión en Red");
        Queue<String> printSpooler = new LinkedList<>();
        printSpooler.offer("Doc_Finanzas.pdf");
        printSpooler.offer("Reporte_Mensual.docx");
        System.out.println("  -> Documentos esperando en la cola (Spooler): " + printSpooler);
        System.out.println("  -> Impresora consumiendo y sacando el primer documento formado (poll): " + printSpooler.poll());
        
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
