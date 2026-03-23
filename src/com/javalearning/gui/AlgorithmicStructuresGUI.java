package com.javalearning.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AlgorithmicStructuresGUI {
    public AlgorithmicStructuresGUI() {
        JFrame frame = new JFrame("Simulador: Estructuras Algorítmicas (Asignación, IF y FOR)");
        frame.setSize(650, 520);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(245, 250, 255));
        
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setOpaque(false);
        
        // Explicación Superior
        JLabel lblExplicacion = new JLabel("<html><h2 style='color:#0F385A; margin:0;'>Ingeniería Algorítmica en Vivo</h2>"
                                         + "<p style='color:#333; font-size:12px; margin-top:5px;'>"
                                         + "Escribe un número redondo para <b>Asignar</b> la variable límite.<br>"
                                         + "El ciclo <b>FOR</b> repetirá la operación dibujando bloques visuales.</p></html>");
        mainPanel.add(lblExplicacion, BorderLayout.NORTH);
        
        // Área Central
        JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
        centerPanel.setOpaque(false);
        
        // Panel de entrada (Asignación)
        JPanel topInputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topInputPanel.setOpaque(false);
        topInputPanel.add(new JLabel("Asignación Dinámica: int limite = "));
        JTextField txtLimite = new JTextField("7", 5);
        txtLimite.setFont(new Font("Consolas", Font.BOLD, 16));
        topInputPanel.add(txtLimite);
        topInputPanel.add(new JLabel(" ;"));
        
        JButton btnEjecutar = new JButton("▶ Ejecutar Algoritmo Completo");
        btnEjecutar.setBackground(new Color(31, 178, 222)); // Light Blue
        btnEjecutar.setForeground(new Color(15, 56, 90)); // Dark Blue Text
        btnEjecutar.setContentAreaFilled(false);
        btnEjecutar.setOpaque(true);
        btnEjecutar.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnEjecutar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        topInputPanel.add(btnEjecutar);
        
        centerPanel.add(topInputPanel, BorderLayout.NORTH);
        
        // Panel de Resultados (FOR y IF)
        JTextArea txtOutput = new JTextArea();
        txtOutput.setFont(new Font("Consolas", Font.BOLD, 14));
        txtOutput.setEditable(false);
        txtOutput.setBackground(new Color(15, 56, 90)); // Dark Blue
        txtOutput.setForeground(new Color(166, 206, 56)); // Green Hack
        txtOutput.setMargin(new Insets(10, 10, 10, 10));
        centerPanel.add(new JScrollPane(txtOutput), BorderLayout.CENTER);
        
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        frame.add(mainPanel);
        
        // Lógica de Ejecución Animada (Muestra del bucle FOR en tiempo de ejecución)
        btnEjecutar.addActionListener(e -> {
            btnEjecutar.setEnabled(false);
            txtOutput.setText(">>> Iniciando Análisis Lógico...\n\n");
            
            try {
                final int limite = Integer.parseInt(txtLimite.getText().trim());
                txtOutput.append("[1. ASIGNACIÓN COMPLETA]: Variable 'limite' vale " + limite + "\n\n");
                
                txtOutput.append("[2. EVALUANDO CONDICIÓN IF]:\n");
                if (limite >= 10) {
                    txtOutput.append("-> El sistema detectó que " + limite + " es >= 10.\n");
                } else {
                    txtOutput.append("-> El sistema detectó que " + limite + " es estadísticamente menor a 10.\n");
                }
                
                txtOutput.append("\n[3. ARRANCAMOS BUCLE FOR (Repetición Automática)]:\n");
                
                // Usamos un Hilo para no congelar la UI y que se animado (didáctico)
                new Thread(() -> {
                    for (int i = 1; i <= limite; i++) {
                        final int step = i;
                        SwingUtilities.invokeLater(() -> {
                            txtOutput.append("   (for) Vuelta N° " + step + " ejecutada correctamente.\n");
                            txtOutput.setCaretPosition(txtOutput.getDocument().getLength());
                        });
                        try { Thread.sleep(400); } catch(Exception ex) {} // Pausa
                        
                        // Si supera 25 repeticiones para no colgar eternamente en la gracia
                        if(i >= 25) {
                            SwingUtilities.invokeLater(() -> txtOutput.append("   ... [Bucle truncado por exceso didáctico] ...\n"));
                            break;
                        }
                    }
                    SwingUtilities.invokeLater(() -> {
                        txtOutput.append("\n-> FIN DEL BUCLE FOR: La condición limite se superó.\n");
                        btnEjecutar.setEnabled(true);
                    });
                }).start();
                
            } catch (Exception ex) {
                txtOutput.append("\n[ERROR FATAL DE ASIGNACIÓN]: ¡Agregaste letras en lugar de números enteros (int)!\nJava exige Tipado Fuerte estricto.");
                btnEjecutar.setEnabled(true);
            }
        });
        
        frame.setVisible(true);
    }
}
