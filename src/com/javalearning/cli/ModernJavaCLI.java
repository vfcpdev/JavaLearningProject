package com.javalearning.cli;

import java.util.Scanner;
import java.util.List;

public class ModernJavaCLI {
    
    // 1. Uso de Records (Java 14+) - Portador de datos inmutable compacto
    public record ServerNode(String ip, int port, String status) {}

    public static void run(Scanner scanner) {
        System.out.println("\n--- Modern Java (Características avanzadas según dev.java/learn) ---");
        
        System.out.println("\n1. RECORDS (Estructuras de Datos Inmutables)");
        System.out.println("   (EJERCICIO) Vamos a crear tu nodo servidor usando la nueva directiva Record.");
        System.out.print("   -> Ingresa una llave de IP para inicializar el nodo (Ej. 10.0.0.1): ");
        String ip = scanner.nextLine();
        System.out.print("   -> Ingresa el puerto (Ej. 80 o 443): ");
        int port = 80;
        try { port = Integer.parseInt(scanner.nextLine()); } catch(Exception e) {}
        
        ServerNode node = new ServerNode(ip, port, "ACTIVE");
        System.out.println("    Record instanciado automáticamente (El constructor y toString se generan solos): " + node);
        System.out.println("    Acceso sin escribir 'getters' manuales. Tu dato node.ip() es = " + node.ip());
        
        System.out.println("\n2. PATTERN MATCHING para instanceof (Desde JDK 16+)");
        Object obj = node;
        System.out.println("    Evaluando el objeto base polimórfico en memoria...");
        if (obj instanceof ServerNode n) {
            // Ya no requiere casteo manual: (ServerNode) obj;
            System.out.println("    ¡Pattern Matching detectado! Variable local 'n' inicializada de forma segura en el cuerpo del 'if'.");
            System.out.println("    Verificación cruzada de dato: " + n.port());
        }
        
        System.out.println("\n3. THE STREAM API (Pipeline Funcional sobre Colecciones)");
        List<ServerNode> cluster = List.of(
            node, 
            new ServerNode("192.168.1.1", 22, "OFFLINE"),
            new ServerNode("10.5.5.5", 8080, "ACTIVE")
        );
        System.out.println("    Se inyectó una lista List.of() creando un arreglo de " + cluster.size() + " nodos.");
        
        System.out.print("   (EJERCICIO) Presiona Enter para pasar los objetos a lo largo del conducto funcional de Stream()");
        scanner.nextLine();
        System.out.println("   -> Aplicando .filter() lambda eliminando los que digan 'OFFLINE'...");
        
        cluster.stream()
               .filter(srv -> srv.status().equals("ACTIVE"))
               .forEach(srv -> System.out.println("       >> Transición final de stream: Nodo ¡" + srv.status() + "! fluyendo: " + srv.ip()));
               
        System.out.println("\nPresiona Enter para cerrar y volver al menú principal de ejercicios...");
        scanner.nextLine();
    }
}
