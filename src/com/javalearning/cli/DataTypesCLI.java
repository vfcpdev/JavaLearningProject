package com.javalearning.cli;

import java.util.Scanner;

public class DataTypesCLI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        run(scanner);
        scanner.close();
    }

    public static void run(Scanner scanner) {
        System.out.println("\n=======================================================");
        System.out.println("   MÓDULO 1: TIPOS DE DATOS BASE (PERFIL DE USUARIO)");
        System.out.println("=======================================================");
        System.out.println("Java es 'fuertemente tipado'. Utiliza 'moldes' específicos para guardar datos en RAM.");
        System.out.println("En lugar de ver 8 tipos complejos, centraremos tu aprendizaje en los 4 tipos base.");
        System.out.println("Vamos a simular la creación de un Perfil Universitario paso a paso.\n");
        
        System.out.print("-> Presiona [ENTER] para declarar el PRIMER dato: Texto (String)");
        if (scanner.hasNextLine()) scanner.nextLine(); 
        
        System.out.println("\n>> CÓDIGO INYECTADO: String nombre = \"Víctor Castro\";");
        String nombre = "Víctor Castro";
        System.out.println("   // EXPLICACIÓN: 'String' permite encadenar decenas de letras formando Textos e Identidades.");
        System.out.println("   -> MEMORIA RAM: [nombre] almacena: " + nombre);
        System.out.print("-> (Enter para continuar)"); scanner.nextLine();
        
        System.out.println("\n>> CÓDIGO INYECTADO: int edad = 30;");
        int edad = 30;
        System.out.println("   // EXPLICACIÓN: 'int' reserva memoria exclusivamente para números Enteros sin decimales.");
        System.out.println("   -> MEMORIA RAM: [edad] almacena: " + edad);
        System.out.print("-> (Enter para continuar)"); scanner.nextLine();
        
        System.out.println("\n>> CÓDIGO INYECTADO: double estatura = 1.78;");
        double estatura = 1.78;
        System.out.println("   // EXPLICACIÓN: 'double' nos da el doble de memoria para calcular factores Decimales exactos.");
        System.out.println("   -> MEMORIA RAM: [estatura] almacena: " + estatura + " mts");
        System.out.print("-> (Enter para continuar)"); scanner.nextLine();
        
        System.out.println("\n>> CÓDIGO INYECTADO: boolean esProfesor = true;");
        boolean esProfesor = true;
        System.out.println("   // EXPLICACIÓN: 'boolean' es la unidad computacional más pequeña. Solo permite 'true' o 'false' (1 o 0).");
        System.out.println("   -> MEMORIA RAM: [esProfesor] almacena: " + esProfesor);
        System.out.print("-> (Enter para finalizar)"); scanner.nextLine();

        System.out.println("\n=======================================================");
        System.out.println("  ✓ PERFIL LOGRADO USANDO SOLAMENTE 4 TIPOS DE DATOS!");
        System.out.println("=======================================================");
    }
}
