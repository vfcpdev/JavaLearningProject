package com.javalearning.cli;

import java.util.Scanner;

public class JavaHistoryCLI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        run(scanner);
        scanner.close();
    }

    public static void run(Scanner scanner) {
        System.out.println("\n=======================================================");
        System.out.println("   MÓDULO 1: HISTORIA Y ARQUITECTURA DE JAVA");
        System.out.println("=======================================================");
        
        System.out.println("\nJava fue creado en 1995 por James Gosling en Sun Microsystems.");
        System.out.println("Nació con una misión revolucionaria llamada WORA:");
        System.out.println("\"Write Once, Run Anywhere\" (Escríbelo una vez, ejecútalo donde sea).");
        
        System.out.print("\n-> Digita tu nombre para interactuar con la Máquina Virtual: ");
        String name = scanner.nextLine();
        
        System.out.println("\nHola " + name + ", para demostrarte el concepto WORA, la");
        System.out.println("Máquina Virtual de Java (JVM) va a escanear tu hardware físico");
        System.out.println("en este mismo instante...\n");
        
        System.out.println("--- ANÁLISIS DEL SISTEMA SUBYACENTE ---");
        System.out.println(">> Sistema Operativo detectado : " + System.getProperty("os.name"));
        System.out.println(">> Arquitectura de Procesador  : " + System.getProperty("os.arch"));
        System.out.println(">> Versión de la Máquina Java  : " + System.getProperty("java.version"));
        System.out.println(">> Carpeta de tu Usuario       : " + System.getProperty("user.home"));
        System.out.println("---------------------------------------");
        
        System.out.println("\n¿Ves lo que ocurrió? A pesar de que este código fue escrito para");
        System.out.println("una máquina neutra, la JVM lo tradujo automáticamente al vuelo");
        System.out.println("para funcionar nativamente en tu " + System.getProperty("os.name") + ".");
        
        System.out.println("\n--- MINI QUIZ ---");
        System.out.print("En el mundo real, ¿Qué comando usarías en esta consola para COMPILAR un archivo Ejemplo.java hacia Bytecode? ");
        String ans1 = scanner.nextLine().trim();
        
        if(ans1.equalsIgnoreCase("javac Ejemplo.java")) {
            System.out.println("¡Correcto! 'javac' es el compilador de Java responsable de crear los .class");
        } else {
            System.out.println("Respuesta incorrecta. El comando exacto es: javac Ejemplo.java");
        }
        
        System.out.println("\n=======================================================");
        System.out.println("Presiona Enter para finalizar y volver al Menú Principal...");
        if(scanner.hasNextLine()) scanner.nextLine();
    }
}
