package com.javalearning.cli;

import java.util.Scanner;

public class DataTypesCLI {
    public static void run(Scanner scanner) {
        System.out.println("\n=== LABORATORIO INTERACTIVO CLI: TIPOS DE DATOS (EJECUCIÓN LINEAL) ===");
        System.out.println("En este ejercicio el compilador interpretará las variables paso a paso deteniéndose.");
        System.out.println("-> Presiona [ENTER] cada vez para forzar a la máquina a procesar la siguiente declaración de la clase.\n");
        
        System.out.println(">> LÍNEA EJECUTADA: byte b = 100;");
        byte b = 100;
        System.out.println("   // EXPLICACIÓN: Se ha reservado un espacio de 8 bits en la CPU. Rango: -128 a 127.");
        System.out.print("   -> MEMORIA RAM INSTANCIADA: [b] = " + b);
        if (scanner.hasNextLine()) scanner.nextLine(); 
        
        System.out.println("\n>> LÍNEA EJECUTADA: short s = 30000;");
        short s = 30000;
        System.out.println("   // EXPLICACIÓN: Bloque físico de 16 bits. Escala a -32,768 hasta 32,767.");
        System.out.print("   -> MEMORIA RAM INSTANCIADA: [s] = " + s);
        scanner.nextLine();
        
        System.out.println("\n>> LÍNEA EJECUTADA: int i = 2147483647;");
        int i = 2147483647;
        System.out.println("   // EXPLICACIÓN: Entero estándar de 32 bits. Formato dominante requerido en bucles de sistemas de información. Aquí está en su extremo positivo máximo.");
        System.out.print("   -> MEMORIA RAM INSTANCIADA: [i] = " + i);
        scanner.nextLine();
        
        System.out.println("\n>> LÍNEA EJECUTADA: long l = 9000000000000L;");
        long l = 9000000000000L;
        System.out.println("   // EXPLICACIÓN: Constante decimal colosal de 64 bits. Al final de la línea debe contener una 'L' mayúscula explícitamente.");
        System.out.print("   -> MEMORIA RAM INSTANCIADA: [l] = " + l);
        scanner.nextLine();
        
        System.out.println("\n>> LÍNEA EJECUTADA: float f = 10.5f;");
        float f = 10.5f;
        System.out.println("   // EXPLICACIÓN: Variable de 32 bits de Puntero/Coma flotante (Contiene submúltiplos decimales limitados). Termina en flag 'f'.");
        System.out.print("   -> MEMORIA RAM INSTANCIADA: [f] = " + f);
        scanner.nextLine();
        
        System.out.println("\n>> LÍNEA EJECUTADA: double d = 3.14159265;");
        double d = 3.14159265;
        System.out.println("   // EXPLICACIÓN: Decimal doble precisión de 64 bits sin pérdida masiva decimal. Es el arquetipo predilecto para matemáticas avanzadas/bancarias.");
        System.out.print("   -> MEMORIA RAM INSTANCIADA: [d] = " + d);
        scanner.nextLine();
        
        System.out.println("\n>> LÍNEA EJECUTADA: boolean isServerActive = true;");
        boolean isServerActive = true;
        System.out.println("   // EXPLICACIÓN: Variable arquitectónica más pequeña de 1 bit lógico. Crucial para bucles o puertas If.");
        System.out.print("   -> MEMORIA RAM INSTANCIADA: [isServerActive] = " + isServerActive);
        scanner.nextLine();
        
        System.out.println("\n>> LÍNEA EJECUTADA: char code = '&';");
        char code = '&';
        System.out.println("   // EXPLICACIÓN: Vector Unicode limitadode 16 bits. Únicamente puede almacenar individualmente y de manera estricta UN carácter encerrado bajo comilla simple ' '.");
        System.out.println("   -> MEMORIA RAM INSTANCIADA: [code] = " + code);
        
        System.out.println("\n--- [MODO DE DEPURACIÓN FINALIZADO] ---");
        System.out.println("Presiona Enter para destruir variables físicas en memoria y retornar a la interfaz de Menú Cntral...");
        scanner.nextLine();
    }
}
