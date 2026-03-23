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
        System.out.println("   FUNDAMENTOS DE JAVA: HISTORIA, SINTAXIS Y GESTORES");
        System.out.println("=======================================================");
        
        System.out.println("\n[1] UN POCO DE HISTORIA");
        System.out.println("Java fue creado por James Gosling en Sun Microsystems (1995).");
        System.out.println("Originalmente se llamó 'Oak' (Roble). Su meta principal era crear");
        System.out.println("un lenguaje de programación de uso general concurrente y muy portable.");
        System.out.print("\nPresiona Enter para avanzar por los fundamentos..."); scanner.nextLine();
        
        System.out.println("\n[2] ARQUITECTURA UNIVERSAL (WORA)");
        System.out.println("En lugar de compilar a código máquina nativo (como lo hace el ensamblador), Java");
        System.out.println("compila a una estructura media llamada 'Bytecode' (.class). Este código es leído");
        System.out.println("en tiempo de ejecución por la Máquina Virtual de Java (JVM) local de cada OS.");
        System.out.println("- JDK (Java Development Kit): Herramientas completas para programadores.");
        System.out.println("- JRE (Java Runtime Environment): Entorno aislado que incluye la JVM para reproducir.");
        System.out.print("\nPresiona Enter para continuar..."); scanner.nextLine();
        
        System.out.println("\n[3] SINTAXIS DEL LENGUAJE");
        System.out.println("Java es drásticamente fuertemente tipado. Toda variable u objeto exige tipo definido.");
        System.out.println("Usa la sintaxis de la familia originada del lenguaje C (llaves {}, punto y coma ;).");
        System.out.println("Paradigma estricto: Orientado a Objetos (POO). ¡Todo está encapsulado en clases!");
        System.out.print("\nPresiona Enter para continuar..."); scanner.nextLine();
        
        System.out.println("\n[4] GESTORES MASIVOS DE PROYECTOS Y LIBRERÍAS");
        System.out.println("- Apache Maven: Emplea archivos (pom.xml) totalmente basados en árbol XML");
        System.out.println("  para autodescargar las dependencias requeridas y gobernar fases del build.");
        System.out.println("- Gradle: Gestor moderno e incremental. Aplica diccionarios build.gradle listados");
        System.out.println("  para compilar en paralelo rindiendo mucho más rápido que Maven antiguo.");
        
        System.out.println("\nPresiona Enter para regresar al Menú Central del Motor...");
        if(scanner.hasNextLine()) scanner.nextLine();
    }
}
