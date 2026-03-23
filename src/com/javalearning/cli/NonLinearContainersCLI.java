package com.javalearning.cli;

import java.util.Scanner;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class NonLinearContainersCLI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        run(scanner);
        scanner.close();
    }

    public static void run(Scanner scanner) {
        System.out.println("\n=======================================================");
        System.out.println("   COLECCIONES AVANZADAS: SETS Y MAPS (MÁS FÁCIL)");
        System.out.println("=======================================================");
        
        System.out.println("\n[1] ESTRUCTURA SET (Conjuntos sin Duplicados)");
        System.out.println("Los sets son ideales para guardar elementos que NO pueden repetirse.");
        System.out.println("Ejemplo: Invitados a una fiesta.");
        
        Set<String> invitados = new HashSet<>();
        invitados.add("Carlos");
        invitados.add("Ana");
        invitados.add("Luisa");
        
        System.out.println("Invitados actuales: " + invitados);
        System.out.print("-> Intenta registrar a 'Ana' de Nuevo para ver qué ocurre: ");
        String nuevoInvitado = scanner.nextLine();
        
        invitados.add(nuevoInvitado);
        System.out.println("Lista final en memoria RAM: " + invitados + " (¡Nota cómo Ana NO se repitió!)");
        
        System.out.println("\n[2] ESTRUCTURA MAP (Clave -> Valor)");
        System.out.println("Los Maps funcionan como un poderoso diccionario o agenda telefónica.");
        
        Map<String, String> agenda = new HashMap<>();
        agenda.put("Victor", "310-000-1111");
        agenda.put("Maria", "320-555-9999");
        
        System.out.println("Agenda actual: " + agenda);
        System.out.print("-> Busca el teléfono de 'Victor' escribiendo su nombre exacto: ");
        String buscar = scanner.nextLine();
        
        String telefono = agenda.get(buscar);
        if(telefono != null) {
            System.out.println("El teléfono de Víctor es: " + telefono);
        } else {
            System.out.println("No se encontró a esa persona en la agenda.");
        }
        
        System.out.println("\n=======================================================");
        System.out.println("Presiona Enter para terminar el laboratorio...");
        if(scanner.hasNextLine()) scanner.nextLine();
    }
}
