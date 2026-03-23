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
        System.out.println("   FUNDAMENTOS DE JAVA: HISTORIA Y SINTAXIS DIDÁCTICA");
        System.out.println("=======================================================");
        
        System.out.println("\n[1] UN POCO DE HISTORIA");
        System.out.println("Java nació en 1995 por James Gosling en Sun Microsystems.");
        System.out.println("Su nombre original fue 'Oak', pero se transformó en el famoso Java.");
        System.out.println("¿Sabías que Java fue diseñado originalmente para electrodomésticos interactivos?");
        System.out.print("\n>>> Escribe 'SI' o 'NO' para confirmar que me lees: ");
        scanner.nextLine();
        
        System.out.println("\n[2] ARQUITECTURA UNIVERSAL (WORA)");
        System.out.println("Java no compila en OS Nativo, lo hace en código virtual neutro: Bytecode.");
        System.out.println("Dicho bytecode solo es legible por la Máquina Virtual de Java (JVM).");
        
        System.out.println("\n[3] PRÁCTICA SINTÁCTICA (SIMULACIÓN INTERACTIVA)");
        System.out.println("Vamos a declarar tu primera variable. Java es fuertemente tipado.");
        System.out.println("Paso 1: Para crear un número entero que valga 50, típicamente escribimos:");
        System.out.println("int edad = 50;");
        System.out.print("\n>>> Por favor, escribe exactamente esa instrucción en consola: ");
        String ans1 = scanner.nextLine();
        
        if(ans1.replaceAll("\\s","").contains("intedad=50;")) {
            System.out.println("¡Excelente! Has declarado correctamente una variable tipada.");
        } else {
            System.out.println("Tu sintaxis varió un poco, pero lo importante es entender el tipado fuerte.");
        }
        
        System.out.println("\nPaso 2: Ahora imprimámosla. En Java decimos:");
        System.out.println("System.out.println(edad);");
        System.out.print("\n>>> Intenta tipear este comando para ver la magia: ");
        scanner.nextLine();
        
        System.out.println("\n[RESULTADO DEL COMPILADOR]");
        System.out.println("> 50");
        System.out.println("¡Muy bien hecho!");

        System.out.println("\n[4] GESTORES DE PROYECTOS");
        System.out.println("En la vida real, compilar a mano es pesado. La industria usa gestores corporativos.");
        System.out.println("> Maven: Usa archivos XML (pom.xml) para gestionar dependencias de internet.");
        System.out.println("> Gradle: Usa scripts ágiles y súper rápidos (muy usado en Android Studio).");
        
        System.out.println("\n=======================================================");
        System.out.println("Presiona Enter para regresar al Menú Central del Motor...");
        if(scanner.hasNextLine()) scanner.nextLine();
    }
}
