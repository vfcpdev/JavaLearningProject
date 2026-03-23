package com.javalearning.cli;

import java.util.Scanner;

public class GraphicalCustomizationCLI {
    public static void main(String[] args) {
        java.util.Scanner s = new java.util.Scanner(System.in);
        run(s);
    }

    public static void run(Scanner scanner) {
        System.out.println("\n--- Personalización de Componentes Gráficos (GUI Elementos) ---");
        System.out.println("\nEn la terminal (CLI) las opciones gráficas o manipulación física está restringida.");
        System.out.println("Sin embargo, en Swing (Librería Gráfica UX/UI nativa de Java) podemos intervenir:");
        System.out.println(" - Color de Fondo de Cajas o Paneles (.setBackground) pasanco esquemas RGB.");
        System.out.println(" - Tonos y brillos en Fuentes de Texto (.setForeground) para el marcado interactivo.");
        System.out.println(" - Familias tipográficas exactas (.setFont(new Font(...))) ej: Arial o Verdana.");
        System.out.println(" - Estructuraciones y Paddings con 'BorderFactory' en ventanas de alto impacto.");
        
        System.out.println("\nPor favor, usa la \"Opción 11\" desde el menú principal de esta Consola");
        System.out.println("y luego entra en la \"Opción 10\" para visualizar los estilos construídos.");
        System.out.println("\nPresiona Enter para volver...");
        scanner.nextLine();
        scanner.nextLine();
    }
}
