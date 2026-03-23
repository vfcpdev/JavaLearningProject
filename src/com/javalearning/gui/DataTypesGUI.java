package com.javalearning.gui;

import javax.swing.*;
import java.awt.*;


public class DataTypesGUI {
    
    // Variable para contabilizar los saltos manuales del usuario en el simulador
    private int stepCounter = 0;

    public DataTypesGUI() {
        JFrame frame = new JFrame("Simulador Terminal OS: Ejecución Tipos de Datos JVM");
        frame.setSize(800, 550);
        frame.setLocationRelativeTo(null);
        
        // Estética oscura tipo Hacker Terminal
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground(Color.DARK_GRAY);
        
        // Superficie de lectura log simulando consola Bash de Windows/Linux
        JTextArea console = new JTextArea();
        console.setEditable(false);
        console.setBackground(new Color(10, 15, 20)); // Interfaz de alto-contraste negro puro
        console.setForeground(new Color(0, 255, 120)); // Fósforo verde fluorescente 
        console.setFont(new Font("Consolas", Font.PLAIN, 16));
        console.setMargin(new Insets(10, 10, 10, 10));
        
        String head = "[root@javalearning ~]# Invocando compilador y rastreando la Memoria...\n" +
                      "[root@javalearning ~]# Esperando instrucción interactiva del usuario para construir la clase en RAM.\n" +
                      "========================================================================================\n\n";
        console.setText(head);
        
        JScrollPane scroll = new JScrollPane(console);
        scroll.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.GRAY), 
            " 💻 Intérprete de Ejecución Visual en Consola (Falso cmd) ", 
            0, 0, new Font("Segoe UI", Font.BOLD, 14), Color.WHITE));
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.DARK_GRAY);
        
        // Botón step-by-step
        JButton btnNext = new JButton("Ver Ejemplo (Siguiente Línea)");
        btnNext.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnNext.setFocusPainted(false);
        btnNext.setBackground(new Color(30, 130, 240));
        btnNext.setForeground(Color.WHITE);
        btnNext.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Conjunto de instrucciones secuencial de código
        String[] instructions = {
            ">> LÍNEA EJECUTADA: byte b = 10;\n   // COMPORTAMIENTO: Aparta 8 bits estrictos en CPU. Se descarta automáticamente si subes de 127.\n   -> ESTADO EN RAM: [b] = 10\n\n",
            ">> LÍNEA EJECUTADA: short s = 30000;\n   // COMPORTAMIENTO: Aparta 16 bits en tú CPU previniendo fugas masivas.\n   -> ESTADO EN RAM: [s] = 30000\n\n",
            ">> LÍNEA EJECUTADA: int i = 2147483647;\n   // COMPORTAMIENTO: 32 bits de capacidad entera instanciada sobre su límite extremo positivo.\n   -> ESTADO EN RAM: [i] = 2147483647\n\n",
            ">> LÍNEA EJECUTADA: long l = 900000000L;\n   // COMPORTAMIENTO: 64 bits con sufijo obligatorio lógico 'L'. Resiste volúmenes bancarios colosales.\n   -> ESTADO EN RAM: [l] = 900000000\n\n",
            ">> LÍNEA EJECUTADA: float f = 10.5f;\n   // COMPORTAMIENTO: Flotante de 32 bits para quebrados decimales. Sufijo físico 'f' anclado.\n   -> ESTADO EN RAM: [f] = 10.5\n\n",
            ">> LÍNEA EJECUTADA: double d = 3.1415;\n   // COMPORTAMIENTO: Inyección de 64 bits de inmensa precisión atómica. Usado en matrices analíticas nativas.\n   -> ESTADO EN RAM: [d] = 3.1415\n\n",
            ">> LÍNEA EJECUTADA: boolean isServerUp = true;\n   // COMPORTAMIENTO: Apenas y roza 1 bit estructural lógico (Encendido/Apagado / Verdadero/Falso).\n   -> ESTADO EN RAM: [isServerUp] = true\n\n",
            ">> LÍNEA EJECUTADA: char c = 'X';\n   // COMPORTAMIENTO: Codificador de plano 16 bits para un único carácter ASCII en el teclado.\n   -> ESTADO EN RAM: [c] = X\n\n"
        };
        
        // Disparador del Botón Next Step
        btnNext.addActionListener(e -> {
            if (stepCounter < instructions.length) {
                console.append(instructions[stepCounter]);
                stepCounter++;
                
                // Forzar Auto-Scroll al final
                JScrollBar vertical = scroll.getVerticalScrollBar();
                vertical.setValue(vertical.getMaximum());
                
                if (stepCounter == instructions.length) {
                    btnNext.setText("✅ Fin de Lectura de la Clase: RAM Destruida Exitosamente.");
                    btnNext.setBackground(new Color(60, 160, 80));
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
