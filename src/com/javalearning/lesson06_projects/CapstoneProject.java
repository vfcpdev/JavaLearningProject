package com.javalearning.lesson06_projects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Proyecto integrador: Gestor de Tareas Interactiva.
 * Integra Control de Flujo, POO, y Colecciones.
 */
public class CapstoneProject {

    // Clase interna que representa la tarea (POO)
    static class Task {
        private String description;
        private boolean isCompleted;

        public Task(String description) {
            this.description = description;
            this.isCompleted = false;
        }

        public void completeTask() {
            this.isCompleted = true;
        }

        public boolean isCompleted() {
            return isCompleted;
        }

        @Override
        public String toString() {
            return (isCompleted ? "[X] " : "[ ] ") + description;
        }
    }

    /**
     * Método principal del proyecto
     * @param scanner El scanner de la consola para leer datos
     */
    public void runProject(Scanner scanner) {
        System.out.println("\n=== Lección 6: Proyecto Integrador (Gestor de Tareas) ===");
        System.out.println("¡Bienvenido al Gestor de Tareas interactivo en consola!");
        
        List<Task> taskHistory = new ArrayList<>();
        boolean continueApp = true;

        while (continueApp) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Agregar una tarea");
            System.out.println("2. Marcar tarea como completada");
            System.out.println("3. Ver todas las tareas");
            System.out.println("4. Ver tareas pendientes (Uso de Streams)");
            System.out.println("0. Salir del mini-proyecto");
            System.out.print("Elige una opción: ");

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
                    System.out.print("📝 Escribe la descripción de la tarea: ");
                    String desc = scanner.nextLine();
                    if (!desc.trim().isEmpty()) {
                        taskHistory.add(new Task(desc));
                        System.out.println("✅ Tarea agregada con éxito.");
                    } else {
                        System.out.println("⚠️ La descripción no puede estar vacía.");
                    }
                    break;
                case 2:
                    if (taskHistory.isEmpty()) {
                        System.out.println("No hay tareas registradas aún.");
                        break;
                    }
                    System.out.println("Lista de tareas:");
                    for (int i = 0; i < taskHistory.size(); i++) {
                        System.out.println((i + 1) + ". " + taskHistory.get(i).toString());
                    }
                    System.out.print("Ingresa el número de la tarea a marcar: ");
                    try {
                        int index = Integer.parseInt(scanner.nextLine()) - 1;
                        if (index >= 0 && index < taskHistory.size()) {
                            taskHistory.get(index).completeTask();
                            System.out.println("🎉 Tarea marcada como completada.");
                        } else {
                            System.out.println("⚠️ Número de tarea incorrecto.");
                        }
                    } catch(Exception e) {
                        System.out.println("⚠️ Entrada inválida.");
                    }
                    break;
                case 3:
                    if (taskHistory.isEmpty()) {
                        System.out.println("📭 Historial de tareas vacío.");
                    } else {
                        System.out.println("===============================");
                        taskHistory.forEach(System.out::println);
                        System.out.println("===============================");
                    }
                    break;
                case 4:
                    System.out.println("=== Tareas Pendientes (Filtradas via Streams) ===");
                    long pendingCount = taskHistory.stream()
                            .filter(t -> !t.isCompleted())
                            .peek(System.out::println) // Imprime las tareas
                            .count();                  // Cuenta las pendientes
                    if (pendingCount == 0) {
                        System.out.println("¡Todas tus tareas están completas!");
                    }
                    break;
                case 0:
                    continueApp = false;
                    System.out.println("Saliendo del Gestor de Tareas interactivo...");
                    break;
                default:
                    System.out.println("⚠️ Opción no reconocida.");
                    break;
            }
        }
    }
}
