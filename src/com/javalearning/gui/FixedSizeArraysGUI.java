package com.javalearning.gui;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class FixedSizeArraysGUI {
    // Función privada para el cálculo matemático
    private double calcularDesviacion(int[] arr) {
        double sum = 0;
        for (int v : arr) sum += v;
        double media = sum / arr.length;
        double varSum = 0;
        for (int v : arr) varSum += Math.pow(v - media, 2);
        return Math.sqrt(varSum / arr.length);
    }
    
    public FixedSizeArraysGUI() {
        JFrame frame = new JFrame("Arreglos de Tamaño Fijo, Utilidades y Matrices");
        frame.setSize(600, 580);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JTextArea info = new JTextArea(
            "1. DECLARACIÓN E INICIALIZACIÓN: \n" +
            "   int[] arr = new int[N];  o inicialización directa: {1,2,3}\n" +
            "2. RECORRIDO DE ARREGLOS: Usar ciclo 'for' basado en .length\n" +
            "3. UTILIDADES: Métodos como Arrays.sort() y Arrays.toString()\n" +
            "4. DESVIACIÓN ESTÁNDAR: Media y dispersión sobre el arreglo.\n" +
            "5. MATRICES (2D): Arreglo bidimensional (Filas y Columnas).\n" +
            "6. ARREGLOS MULTIDIMENSIONALES (3D+): Cubos de datos espaciales."
        );
        info.setEditable(false);
        info.setFont(new Font("Monospaced", Font.PLAIN, 13));
        
        JPanel interactPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        
        // Panel 1: Arreglo Unidimensional y Desviación Estandar
        JPanel pnl1D = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnl1D.setBorder(BorderFactory.createTitledBorder("Análisis 1D - Ordenamiento y Desviación Estándar"));
        JTextField txtNumeros = new JTextField("12, 15, 20, 10, 14", 25);
        JButton btnAnalizar = new JButton("Analizar Conjunto ->");
        JLabel lblAnalisis = new JLabel("  Esperando datos...");
        lblAnalisis.setForeground(new Color(0, 102, 204));
        
        btnAnalizar.addActionListener(e -> {
            try {
                String[] parts = txtNumeros.getText().split(",");
                int[] numeros = new int[parts.length];
                for(int i=0; i<parts.length; i++) {
                    numeros[i] = Integer.parseInt(parts[i].trim());
                }
                
                Arrays.sort(numeros); // Utilidad de ordenamiento
                double stdDev = calcularDesviacion(numeros); // Cálculo de desviación
                
                lblAnalisis.setText("<html>Orden: " + Arrays.toString(numeros) + 
                                    "<br/>Desv. Estándar (σ): " + String.format("%.2f", stdDev) + "</html>");
            } catch (Exception ex) {
                lblAnalisis.setText("<html><font color='red'>Error: Ingrese números enteros<br>separados estricamemente por comas.</font></html>");
            }
        });
        
        pnl1D.add(new JLabel("Set Datos: "));
        pnl1D.add(txtNumeros); 
        pnl1D.add(btnAnalizar); 
        pnl1D.add(lblAnalisis);
        
        // Panel 2: Matrices y Arreglos N-Dimensionales
        JPanel pnlMD = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlMD.setBorder(BorderFactory.createTitledBorder("Arreglos de +2 Dimensiones (Matrices y 3D)"));
        JButton btnMulti = new JButton("Crear e Imprimir Matrices Especiales");
        JTextArea txtMulti = new JTextArea(4, 40);
        txtMulti.setEditable(false);
        txtMulti.setBackground(SystemColor.control);
        
        btnMulti.addActionListener(e -> {
            int[][] mat2d = { {1, 2, 3}, {4, 5, 6} };
            int[][][] mat3d = new int[2][2][2];
            mat3d[0][1][1] = 99; // Insertando en índice específico
            
            txtMulti.setText("Matriz 2D Inicializada: " + Arrays.deepToString(mat2d) + "\n" +
                             "Dato Extraído Fila 2 Columna 3 [1][2]: " + mat2d[1][2] + "\n\n" +
                             "Matriz Espacial 3D Creada [2][2][2] \n" +
                             "Dato Extraído Posición [0][1][1]: " + mat3d[0][1][1]);
        });
        pnlMD.add(btnMulti); 
        pnlMD.add(txtMulti);
        
        interactPanel.add(pnl1D);
        interactPanel.add(pnlMD);
        
        panel.add(new JScrollPane(info), BorderLayout.NORTH);
        panel.add(interactPanel, BorderLayout.CENTER);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
