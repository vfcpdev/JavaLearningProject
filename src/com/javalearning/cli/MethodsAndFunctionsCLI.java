package com.javalearning.cli;

import java.util.Scanner;

public class MethodsAndFunctionsCLI {
    
    // 1. Funciones (Método simple sin retorno y sin parámetros)
    private static void imprimirMensajeBienvenida() {
        System.out.println("  -> Ejecutando Función: ¡Hola! Bienvenido al módulo de Métodos.");
    }
    
    // 2. Argumentos y Parámetros (Método con retorno)
    private static int calcularAreaRectangulo(int base, int altura) {
        return base * altura;
    }
    
    // 3. Métodos y cadenas (Método trabajando con Strings)
    private static String enmascararCorreo(String correo) {
        if (correo.contains("@")) {
            String[] partes = correo.split("@");
            if (partes[0].length() > 2) {
                return partes[0].substring(0, 2) + "****@" + partes[1];
            }
        }
        return correo;
    }
    
    // 4. Recursión (Un método que se llama a sí mismo)
    private static int calcularFactorial(int n) {
        if (n <= 1) { // Caso base
            return 1;
        }
        return n * calcularFactorial(n - 1); // Llamada recursiva
    }

    public static void main(String[] args) {
        java.util.Scanner s = new java.util.Scanner(System.in);
        run(s);
    }

    public static void run(Scanner scanner) {
        System.out.println("\n--- Funciones y Métodos ---");
        
        System.out.println("\n1. FUNCIONES BÁSICAS");
        System.out.println("Una función o método es un bloque de código diseñado para realizar una tarea particular.");
        imprimirMensajeBienvenida();
        
        System.out.println("\n2. ARGUMENTOS Y PARÁMETROS");
        System.out.println("Los parámetros son variables en la declaración del método, los argumentos son los datos reales que se envían.");
        int b = 5;
        int a = 10;
        System.out.println("  -> Calculando área con argumentos base=" + b + " y altura=" + a + ": " + calcularAreaRectangulo(b, a));
        
        System.out.println("\n3. MÉTODOS Y CADENAS");
        System.out.println("Podemos encapsular lógica útil para procesar texto (Strings).");
        String miCorreo = "desarrollador@empresa.com";
        System.out.println("  -> Correo original: " + miCorreo);
        System.out.println("  -> Correo tras ejecutar el método 'enmascararCorreo': " + enmascararCorreo(miCorreo));
        
        System.out.println("\n4. RECURSIÓN");
        System.out.println("La recursión ocurre cuando un método se llama a sí mismo para resolver un subproblema.");
        int num = 5;
        System.out.println("  -> Calculando factorial recursivo de " + num + " (5 * 4 * 3 * 2 * 1): " + calcularFactorial(num));
        
        System.out.println("\nPresiona Enter para volver al Menú Principal...");
        scanner.nextLine();
        scanner.nextLine();
    }
}
