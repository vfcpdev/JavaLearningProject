package com.javalearning;

import java.util.Scanner;
import com.javalearning.cli.DataTypesCLI;
import com.javalearning.cli.MathOpsCLI;
import com.javalearning.cli.DataStructuresCLI;
import com.javalearning.cli.AlgorithmicStructuresCLI;
import com.javalearning.cli.MethodsAndFunctionsCLI;
import com.javalearning.cli.OOPCLI;
import com.javalearning.cli.ExceptionsCLI;
import com.javalearning.cli.FixedSizeArraysCLI;
import com.javalearning.cli.StandardContainersCLI;
import com.javalearning.cli.GraphicalCustomizationCLI;
import com.javalearning.cli.NonLinearContainersCLI;
import com.javalearning.cli.ModernJavaCLI;
import com.javalearning.cli.AboutCLI;
import com.javalearning.cli.JavaHistoryCLI;
import com.javalearning.cli.LessonsCLI;
import com.javalearning.gui.MainGUI;

public class Main {
    public static void main(String[] args) {
        // Verificar si se solicitó iniciar en modo GUI directamente por argumento
        if (args.length > 0 && args[0].equalsIgnoreCase("--gui")) {
            System.out.println("Iniciando modo GUI...");
            MainGUI.launchGUI();
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("\n=========================================");
            System.out.println("  Proyecto de Aprendizaje de Java (CLI)");
            System.out.println("=========================================");
            System.out.println("1. Fundamentos: Historia, Arquitectura y Gestores");
            System.out.println("2. Tipos de Datos (Explicación CLI)");
            System.out.println("3. Operaciones Matemáticas (Ejemplos CLI)");
            System.out.println("4. Estructuras de Datos (Muestras CLI)");
            System.out.println("5. Estructuras Algorítmicas (Casos Reales CLI)");
            System.out.println("6. Funciones y Métodos (Ejemplos CLI)");
            System.out.println("7. Prog. Orientada a Objetos (Ejemplos CLI)");
            System.out.println("8. Manejo de Excepciones (Ejemplos CLI)");
            System.out.println("9. Arreglos de Tamaño Fijo y Matrices (Ejemplos CLI)");
            System.out.println("10. Contenedores Estándar de Datos (LIFO/FIFO)");
            System.out.println("11. Personalización Gráfica Swing (Ejemplos CLI)");
            System.out.println("12. Contenedores Estándar No Lineales (Sets y Mapas)");
            System.out.println("13. Características Modernas de Java (Records, Pattern Matching, Streams)");
            System.out.println("14. Acerca del Diseñador (Ing. Mg. Víctor Castro)");
            System.out.println("15. Lanzar Interfaz Gráfica (Swing GUI)");
            System.out.println("16. Lecciones Prácticas / Curso Interactivo");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if(scanner.hasNextLine()) scanner.nextLine(); // Consume newline residue
                switch (choice) {
                    case 1:
                        JavaHistoryCLI.run(scanner);
                        break;
                    case 2:
                        DataTypesCLI.run(scanner);
                        break;
                    case 3:
                        MathOpsCLI.run(scanner);
                        break;
                    case 4:
                        DataStructuresCLI.run(scanner);
                        break;
                    case 5:
                        AlgorithmicStructuresCLI.run(scanner);
                        break;
                    case 6:
                        MethodsAndFunctionsCLI.run(scanner);
                        break;
                    case 7:
                        OOPCLI.run(scanner);
                        break;
                    case 8:
                        ExceptionsCLI.run(scanner);
                        break;
                    case 9:
                        FixedSizeArraysCLI.run(scanner);
                        break;
                    case 10:
                        StandardContainersCLI.run(scanner);
                        break;
                    case 11:
                        GraphicalCustomizationCLI.run(scanner);
                        break;
                    case 12:
                        NonLinearContainersCLI.run(scanner);
                        break;
                    case 13:
                        ModernJavaCLI.run(scanner);
                        break;
                    case 14:
                        AboutCLI.run(scanner);
                        break;
                    case 15:
                        System.out.println("\nLanzando la Interfaz Gráfica...");
                        MainGUI.launchGUI();
                        break;
                    case 16:
                        LessonsCLI.run(scanner);
                        break;
                    case 0:
                        System.out.println("\nSaliendo de la aplicación. ¡Sigue aprendiendo!");
                        break;
                    default:
                        System.out.println("\nOpción inválida. Intenta de nuevo.");
                }
            } else {
                System.out.println("\nPor favor, ingresa un número válido representativo del menú.");
                scanner.next(); // Limpiar el buffer de entrada inválida
            }
        } while (choice != 0);
        
        scanner.close();
        System.exit(0);
    }
}
