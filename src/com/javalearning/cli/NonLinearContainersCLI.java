package com.javalearning.cli;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

public class NonLinearContainersCLI {
    public static void run(Scanner scanner) {
        System.out.println("\n--- Contenedores No Lineales (Contexto de Software y Networking) ---");
        
        System.out.println("\n1. CONJUNTOS (Sets) -> Tablas ARP o Blacklist de Direcciones MAC de Red Únicas");
        System.out.println("   (Los Sets garantizan matemáticamente que no haya elementos duplicados en RAM)");
        Set<String> macAddresses = new HashSet<>();
        macAddresses.add("00:1A:2B:3C:4D:5E");
        System.out.println("  -> MAC base registrada de fábrica en el switch lógico: " + macAddresses);
        
        System.out.print("  -> (EJERCICIO) Por favor, simula como admin y digita una nueva MAC (Ej: AA:BB:CC:DD:EE:FF): ");
        String customMac = scanner.nextLine();
        macAddresses.add(customMac);
        
        System.out.print("  -> (EJERCICIO) ¡Atención! Intenta violar la seguridad registrando ESA MISMÍSIMA MAC repetida: ");
        String clonedMac = scanner.nextLine();
        
        boolean isAdded = macAddresses.add(clonedMac); // Evalúa si la colisión Hashing lo desvió
        System.out.println("  -> ¿El compilador logró inyectar la repetición? (true = si, false = Lo evadió con éxito): " + isAdded);
        System.out.println("  -> Tabla interna intacta (sólo exclusivas): " + macAddresses);
        
        System.out.println("\n2. MAPAS (HashMaps) -> Tablas de Resolución DNS Locales");
        System.out.println("   (Los Maps asocian íntimamente una Clave 'Key' a la que corresponde su Valor 'Value')");
        Map<String, String> dnsServer = new HashMap<>();
        dnsServer.put("google.com", "142.250.190.46");
        dnsServer.put("intranet.corp", "10.0.0.5");
        dnsServer.put("db-server.main", "192.168.1.100");
        
        System.out.println("  -> Registros DNS corporativos ingestados (Tamaño: " + dnsServer.size() + ").");
        System.out.println("  -> Consultando resolución de la clave 'intranet.corp'... Objeto extraído en milisegundos: " + dnsServer.get("intranet.corp"));
        
        System.out.println("  -> Mantenimiento en curso, mutando IP de db-server.main...");
        dnsServer.put("db-server.main", "192.168.1.200"); // Sobreescritura inteligente
        System.out.println("  -> Clave 'db-server' resolviendo a NUEVA IP: " + dnsServer.get("db-server.main"));
        
        System.out.println("\nPresiona Enter para cerrar y volver al menú principal...");
        scanner.nextLine();
        scanner.nextLine();
    }
}
