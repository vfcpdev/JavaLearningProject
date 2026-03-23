package com.javalearning.cli;

import java.util.Scanner;

public class AlgorithmicStructuresCLI {
    public static void run(Scanner scanner) {
        System.out.println("\n--- Estructuras Algorítmicas Básicas ---");
        System.out.println("Enfoque práctico para Ingenieros de Sistemas");
        
        System.out.println("\n1. ASIGNACIÓN (Asignación de variables de servidor)");
        // Ejemplo cotidiano
        String serverIp = "192.168.1.10";
        int ramAssignedGB = 16;
        double cpuUsage = 45.5; // Porcentaje
        boolean isOnline = true;
        System.out.println("Servidor configurado en IP: " + serverIp);
        System.out.println("Memoria asignada: " + ramAssignedGB + "GB");
        System.out.println("Uso actual de CPU: " + cpuUsage + "%");
        System.out.println("Estado Online: " + isOnline);

        System.out.println("\n2. CONDICIÓN (Monitoreo de Recursos en Tiempo Real)");
        if (cpuUsage > 80.0) {
            System.out.println("[ALERTA] Uso de CPU crítico (" + cpuUsage + "%). Se requiere balanceo de carga en el cluster.");
        } else if (cpuUsage > 60.0) {
            System.out.println("[WARNING] Uso de CPU elevado (" + cpuUsage + "%). Monitorear de cerca.");
        } else {
            System.out.println("[OK] Sistema estable. CPU operando normalmente bajo carga aceptable.");
        }
        
        System.out.println("\n3. REPETICIÓN (Escaneo de puertos o pings continuos en red)");
        System.out.println("Simulando pings a varios nodos del cluster dentro del segmento usando un ciclo FOR:");
        for(int i = 1; i <= 5; i++) {
            System.out.println(" Haciendo PING a 192.168.1." + i + " ... Respuesta recibida (12ms)");
        }
        
        System.out.println("\nSimulando mecanismo de reintento de conexión a Base de Datos de producción usando un ciclo WHILE:");
        int intentos = 1;
        boolean dbConnected = false;
        while (!dbConnected && intentos <= 3) {
            System.out.println(" Intento de conexión a DB Host n° " + intentos + "...");
            if (intentos == 3) { // Simularemos que al tercer intento se conecta
                dbConnected = true;
                System.out.println(" ¡Conexión establecida con éxito al Host de DB!");
            }
            intentos++;
        }
        
        System.out.println("\nPresiona Enter para volver al Menú Principal...");
        scanner.nextLine();
        scanner.nextLine();
    }
}
