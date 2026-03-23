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
        System.out.println("   MÓDULO 2: TIPOS DE DATOS (CONSTRUCTOR DE PERFIL REAL)");
        System.out.println("=======================================================");
        System.out.println("Java es 'fuertemente tipado'. Necesita cajas (variables) exactas para la memoria RAM.");
        System.out.println("Vamos a utilizar la consola para capturar TUS datos reales y guardarlos en la RAM.");
        
        // --- 1. STRING ---
        System.out.print("\n[Variable String -> Textos] Ingresa tu Nombre completo: ");
        String nombreUsuario = scanner.nextLine();
        System.out.println(" -> Éxito. RAM reservó espacio de texto para el valor: " + nombreUsuario);
        
        // --- 2. INT ---
        System.out.print("\n[Variable int -> Números Enteros sin decimales] Ingresa tu Edad: ");
        int edadUsuario = 0;
        try {
            edadUsuario = Integer.parseInt(scanner.nextLine());
            System.out.println(" -> Éxito. RAM guardó el número abstracto " + edadUsuario);
        } catch(Exception e) {
            System.out.println(" -> ¡ERROR! Escribiste letras en vez de números. Java es estricto y bloquea formatos inválidos.");
            edadUsuario = 18; // Edad por defecto
        }
        
        // --- 3. DOUBLE ---
        System.out.print("\n[Variable double -> Números Precisos] Ingresa tu Estatura en metros (Ej: 1.70): ");
        double estaturaUsuario = 0.0;
        try {
            estaturaUsuario = Double.parseDouble(scanner.nextLine());
            System.out.println(" -> Éxito. RAM guardó la métrica decimal: " + estaturaUsuario + " mts");
        } catch (Exception e) {
            System.out.println(" -> ¡ERROR DE DECLARACIÓN! Java no permitió guardar ese dato sucio en un Double.");
            estaturaUsuario = 1.65;
        }
        
        // --- 4. BOOLEAN ---
        System.out.print("\n[Variable boolean -> Sistema Binario Si/No] ¿Eres Estudiante de la Universidad Poli? (true/false): ");
        String strBool = scanner.nextLine();
        boolean esEstudiante = strBool.equalsIgnoreCase("true") || strBool.equalsIgnoreCase("si") || strBool.equalsIgnoreCase("sí");
        System.out.println(" -> Éxito. RAM colapsó la lógica en el bit básico: " + esEstudiante);

        // --- CONSOLIDACION ---
        System.out.println("\n=======================================================");
        System.out.println("  ✓ PERFIL COMPUTACIONAL ACUMULADO VÍA CONSOLA");
        System.out.println("=======================================================");
        System.out.println("Nombre Identitario (String) : " + nombreUsuario);
        System.out.println("Años Vividos Físicos (int)  : " + edadUsuario);
        System.out.println("Magnitud Biométrica (double): " + estaturaUsuario);
        System.out.println("Certificado de Estudio Poli (boolean): " + esEstudiante);
        
        System.out.println("\nPresiona Enter para finalizar y volver...");
        if(scanner.hasNextLine()) scanner.nextLine();
    }
}
