package com.javalearning.cli;

import java.util.Scanner;

public class OOPCLI {

    // 1. CLASE PADRE (MOLDE BASE)
    static class Empleado {
        protected String nombre; // Protected para que los hijos lo hereden directo
        
        public Empleado(String nombre) {
            this.nombre = nombre;
        }
        
        public void trabajar() {
            System.out.println("   [MÉTODO PADRE]: El empleado " + nombre + " está haciendo papeleo general.");
        }
    }

    // 2. CLASE HIJA (HERENCIA y POLIMORFISMO)
    static class Ingeniero extends Empleado {
        private String lenguaje;
        
        // Constructor usando SUPER para delegarle el nombre al Padre
        public Ingeniero(String nombre, String lenguaje) {
            super(nombre);
            this.lenguaje = lenguaje;
        }
        
        // Polimorfismo: Sobrescribir (mutar) el comportamiento original
        @Override
        public void trabajar() {
            System.out.println("   [MÉTODO HIJO - SOBRESCRITO]: El ingeniero " + nombre + " está arquitectando bases de datos usando " + lenguaje + ".");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        run(scanner);
        scanner.close();
    }

    public static void run(Scanner scanner) {
        System.out.println("\n=======================================================");
        System.out.println("   MÓDULO 7: PROG. ORIENTADA A OBJETOS (INTERACTIVO)");
        System.out.println("=======================================================");
        
        System.out.println("\n[ CREACIÓN DE CLASE PADRE ]");
        System.out.print(">>> Inventa un nombre para contratar a un Empleado raso: ");
        String nom1 = scanner.nextLine();
        
        Empleado emp = new Empleado(nom1);
        System.out.println("-> CÓDIGO INYECTADO: Empleado emp = new Empleado(\"" + nom1 + "\");");
        System.out.println("-> Ejecutando emp.trabajar()...");
        emp.trabajar();
        
        System.out.println("\n[ HERENCIA Y POLIMORFISMO (CLASE HIJA) ]");
        System.out.print(">>> Inventa un nombre para contratar a un Ingeniero de Software: ");
        String nom2 = scanner.nextLine();
        System.out.print(">>> ¿En qué lenguaje de programación se especializa?: ");
        String lang = scanner.nextLine();
        
        Ingeniero ing = new Ingeniero(nom2, lang);
        System.out.println("-> CÓDIGO INYECTADO: Ingeniero ing = new Ingeniero(\"" + nom2 + "\", \"" + lang + "\");");
        System.out.println("-> Ejecutando ing.trabajar() ... Fíjate que el comando es el mismo que el Padre, ¡pero el objeto es otro!");
        ing.trabajar();

        System.out.println("\n=======================================================");
        System.out.println("Presiona Enter para finalizar y volver al Menú Principal...");
        if(scanner.hasNextLine()) scanner.nextLine();
    }
}
