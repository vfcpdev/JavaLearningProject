package com.javalearning.gui;

import javax.swing.*;
import java.awt.*;

public class DataTypesGUI {
    
    // Contador de pulsaciones del usuario
    private int stepCounter = 0;

    public DataTypesGUI() {
        JFrame frame = new JFrame("Simulador Terminal: Los 4 Tipos de Datos Básicos de Java");
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
        
        // Estética Pantone (Dark Blue -> #0F385A)
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(new Color(15, 56, 90));
        
        // Consola Visual Emulada
        JTextArea console = new JTextArea();
        console.setEditable(false);
        console.setBackground(new Color(10, 15, 20)); // Interfaz de alto-contraste negra
        console.setForeground(new Color(166, 206, 56)); // Fósforo Hacker Pantone Green
        console.setFont(new Font("Consolas", Font.PLAIN, 16));
        console.setMargin(new Insets(10, 10, 10, 10));
        
        String head = "=========================================================================\n" +
                      "   [SISTEMA JVM] Creando Perfil Académico en Memoria RAM Dinámica...\n" +
                      "=========================================================================\n\n" +
                      "Esperando instrucción del programador vía el Botón Inferior para avanzar.\n\n";
        console.setText(head);
        
        JScrollPane scroll = new JScrollPane(console);
        scroll.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(31, 178, 222), 2), 
            " 💻 Intérprete de Ejecución Paso a Paso ", 
            0, 0, new Font("Segoe UI", Font.BOLD, 14), Color.WHITE));
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(15, 56, 90)); // Pantone Dark Blue
        
        JButton btnNext = new JButton("Ver Ejemplo (Siguiente Línea)");
        btnNext.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnNext.setFocusPainted(false);
        btnNext.setBackground(new Color(251, 175, 23)); // Pantone Orange
        btnNext.setForeground(new Color(15, 56, 90)); // Dark Blue Text
        btnNext.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Explicaciones muy sencillas (Solo 4 tipos base)
        String[] instructions = {
            ">> LÍNEA EJECUTADA: String nombre = \"Víctor Castro\";\n   // COMPORTAMIENTO: Inyecta Cadena de Texto. Fundamental para dar identidad.\n   -> ESTADO EN RAM: [nombre] = Víctor Castro\n\n",
            ">> LÍNEA EJECUTADA: int edad = 30;\n   // COMPORTAMIENTO: Los Enteros (int) seusan para matemáticas exactas sin decimales. \n   -> ESTADO EN RAM: [edad] = 30\n\n",
            ">> LÍNEA EJECUTADA: double estatura = 1.78;\n   // COMPORTAMIENTO: Si se requiere precisión para fraccionarios (monedas, métricas), usa double.\n   -> ESTADO EN RAM: [estatura] = 1.78 mts\n\n",
            ">> LÍNEA EJECUTADA: boolean esProfesor = true;\n   // COMPORTAMIENTO: La unidad lógica más fundamental. 1 o 0. Verdadero o Falso.\n   -> ESTADO EN RAM: [esProfesor] = true\n\n"
        };
        
        btnNext.addActionListener(e -> {
            if (stepCounter < instructions.length) {
                console.append(instructions[stepCounter]);
                stepCounter++;
                
                JScrollBar vertical = scroll.getVerticalScrollBar();
                vertical.setValue(vertical.getMaximum());
                
                if (stepCounter == instructions.length) {
                    btnNext.setText("✅ Perfil de Datos Creado Exitosamente.");
                    btnNext.setBackground(new Color(166, 206, 56)); // Green Pantone
                    btnNext.setForeground(new Color(15, 56, 90));
                    btnNext.setEnabled(false);
                }
            }
        });
        
        bottomPanel.add(btnNext);
        panel.add(scroll, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
