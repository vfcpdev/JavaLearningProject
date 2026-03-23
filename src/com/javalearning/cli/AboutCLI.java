package com.javalearning.cli;

import java.util.Scanner;

public class AboutCLI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        run(scanner);
        scanner.close();
    }

    public static void run(Scanner scanner) {
        System.out.println("\n=======================================================");
        System.out.println("             ACERCA DEL MATERIAL EDUCATIVO");
        System.out.println("=======================================================");
        System.out.println("  Diseñador Funcional / Autor Arquitectónico:");
        System.out.println("   ▶ Ing. Mg. Víctor Castro");
        System.out.println("   ▶ Correo Institucional: vfcastro@poligran.edu.co");
        System.out.println("=======================================================");
        System.out.println("  Objetivo Principal: Enseñar y evidenciar experimentalmente");
        System.out.println("  cómo funcionan los engranes, las estructuras de Memoria");
        System.out.println("  RAM y la Máquina Virtual de Java a estudiantes en tiempo real.");
        System.out.println("=======================================================");
        System.out.println("\nPresiona Enter para abandonar los Créditos...");
        if (scanner.hasNextLine()) scanner.nextLine();
    }
}
