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
            System.out.println("1. Tipos de Datos (Explicación CLI)");
            System.out.println("2. Operaciones Matemáticas (Ejemplos CLI)");
            System.out.println("3. Estructuras de Datos (Muestras CLI)");
            System.out.println("4. Estructuras Algorítmicas (Casos Reales CLI)");
            System.out.println("5. Funciones y Métodos (Ejemplos CLI)");
            System.out.println("6. Prog. Orientada a Objetos (Ejemplos CLI)");
            System.out.println("7. Manejo de Excepciones (Ejemplos CLI)");
            System.out.println("8. Arreglos de Tamaño Fijo y Matrices (Ejemplos CLI)");
            System.out.println("9. Contenedores Estándar de Datos (Ejemplos CLI)");
            System.out.println("10. Personalización Gráfica Swing (Ejemplos CLI)");
            System.out.println("11. Lanzar Interfaz Gráfica (Swing GUI)");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        DataTypesCLI.run(scanner);
                        break;
                    case 2:
                        MathOpsCLI.run(scanner);
                        break;
                    case 3:
                        DataStructuresCLI.run(scanner);
                        break;
                    case 4:
                        AlgorithmicStructuresCLI.run(scanner);
                        break;
                    case 5:
                        MethodsAndFunctionsCLI.run(scanner);
                        break;
                    case 6:
                        OOPCLI.run(scanner);
                        break;
                    case 7:
                        ExceptionsCLI.run(scanner);
                        break;
                    case 8:
                        FixedSizeArraysCLI.run(scanner);
                        break;
                    case 9:
                        StandardContainersCLI.run(scanner);
                        break;
                    case 10:
                        GraphicalCustomizationCLI.run(scanner);
                        break;
                    case 11:
                        System.out.println("\nLanzando la Interfaz Gráfica...");
                        MainGUI.launchGUI();
                        // No rompemos el programa por si se cierra la GUI y quieren usar CLI de nuevo
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
