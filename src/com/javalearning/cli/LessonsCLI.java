package com.javalearning.cli;

import java.util.Scanner;

import com.javalearning.lesson01_basics.BasicsExample;
import com.javalearning.lesson02_controlflow.ControlFlowExample;
import com.javalearning.lesson03_oop.OOPExample;
import com.javalearning.lesson04_collections.CollectionsExample;
import com.javalearning.lesson05_advanced.AdvancedExample;
import com.javalearning.lesson06_projects.CapstoneProject;

public class LessonsCLI {

    public static void run(Scanner scanner) {
        boolean back = false;
        
        while (!back) {
            System.out.println("\n=============================================");
            System.out.println("   MÓDULO DE LECCIONES PRÁCTICAS (CURSO)");
            System.out.println("=============================================");
            System.out.println("1. Lección 1 - Basics (Variables, Tipos, Operadores)");
            System.out.println("2. Lección 2 - Control Flow (Condicionales y Ciclos)");
            System.out.println("3. Lección 3 - Programación Orientada a Objetos");
            System.out.println("4. Lección 4 - Collections (Listas, Sets, Mapas)");
            System.out.println("5. Lección 5 - Temas Avanzados (Streams, Excepciones)");
            System.out.println("6. Lección 6 - Proyecto Gestor de Tareas Interactivo");
            System.out.println("0. Volver al menú principal");
            System.out.print("Selecciona una opción: ");

            String input = scanner.nextLine();
            int choice = -1;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Intenta con un número.");
                continue;
            }

            switch (choice) {
                case 1:
                    new BasicsExample().runExamples();
                    break;
                case 2:
                    new ControlFlowExample().runExamples();
                    break;
                case 3:
                    new OOPExample().runExamples();
                    break;
                case 4:
                    new CollectionsExample().runExamples();
                    break;
                case 5:
                    new AdvancedExample().runExamples();
                    break;
                case 6:
                    new CapstoneProject().runProject(scanner);
                    break;
                case 0:
                    back = true;
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
            
            if (!back && choice >= 1 && choice <= 5) {
                System.out.println("Presiona Enter para continuar...");
                scanner.nextLine();
            }
        }
    }
}
