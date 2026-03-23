package com.javalearning.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class GraphicalCustomizationGUI {
    // Variable de estado para transición temática
    private boolean isDarkMode = false;
    
    public GraphicalCustomizationGUI() {
        JFrame frame = new JFrame("Dashboard de Expresiones Estéticas (Colores y Letras)");
        frame.setSize(600, 420);
        frame.setLocationRelativeTo(null);
        
        // Panel contenedor con color base explícitamente blanco y con márgenes fijos
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Etiqueta (JLabel) experimentando con Font, peso Bold-Italic, y un ForeColor Azul profundo RGB
        JLabel lblTitulo = new JLabel("Interfaz de Alto Contraste 100% Customizada", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
        lblTitulo.setForeground(new Color(40, 40, 100)); // RGB manual
        
        // Formateo gráfico de un área de Texto con BorderFactory envolvente, un Background gris neutro
        JTextArea txtArea = new JTextArea(
            "   [MODIFICADORES DE GUI APLICADOS]\n\n" +
            " - Configuración Estándar:\n" +
            "      Tipografía superior es Verdana Cursiva (20pt).\n" +
            "      Esta caja es Consolas Normal (14pt) - Fondo #F5F5F5.\n\n" +
            " - Manipulación:\n" +
            "      Se demuestra que el uso de paletas especializadas\n" +
            "      facilita el diseño estandarizado UX/UI en PC.\n\n" +
            " -> Toca el botón 'Modo Oscuro' para alterar los BackGrounds."
        );
        txtArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        txtArea.setBackground(new Color(245, 245, 245));
        txtArea.setForeground(Color.DARK_GRAY);
        txtArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        txtArea.setEditable(false);
        
        // Panel inferior experimentando con Bordes tipo Title (con letras incrustadas en el perímetro)
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        bottomPanel.setBackground(Color.WHITE);
        bottomPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(Color.LIGHT_GRAY), 
            "Acciones de Control Gráfico", TitledBorder.LEFT, TitledBorder.TOP,
            new Font("Arial", Font.BOLD, 12), Color.GRAY
        ));
        
        JButton btnColor = new JButton("Alternar Modo Oscuro");
        btnColor.setFont(new Font("Arial", Font.BOLD, 14));
        btnColor.setBackground(new Color(20, 20, 20));
        btnColor.setForeground(Color.WHITE);
        btnColor.setFocusPainted(false); 
        
        JButton btnAlerta = new JButton("Prueba Dialog Alert");
        btnAlerta.setFont(new Font("Arial", Font.BOLD, 14));
        btnAlerta.setBackground(new Color(200, 50, 50)); // Rojo rubí
        btnAlerta.setForeground(Color.WHITE);
        
        // Lógica programática para alterar colores durante Runtime
        btnColor.addActionListener(e -> {
            if (isDarkMode) {
                // Tema claro (Predeterminado)
                mainPanel.setBackground(Color.WHITE);
                bottomPanel.setBackground(Color.WHITE);
                lblTitulo.setForeground(new Color(40, 40, 100));
                txtArea.setBackground(new Color(245, 245, 245));
                txtArea.setForeground(Color.DARK_GRAY);
            } else {
                // Tema Oscuro Inyectado sobre todos los paneles
                mainPanel.setBackground(new Color(30, 30, 40));
                bottomPanel.setBackground(new Color(30, 30, 40));
                lblTitulo.setForeground(new Color(200, 200, 255));
                txtArea.setBackground(new Color(50, 50, 60));
                txtArea.setForeground(Color.WHITE);
            }
            isDarkMode = !isDarkMode;
        });
        
        btnAlerta.addActionListener(e -> {
            UIManager.put("OptionPane.background", Color.WHITE);
            UIManager.put("Panel.background", Color.WHITE);
            JOptionPane.showMessageDialog(frame, "Observaste el botón rojo usando RGB (200, 50, 50)\ny una tipografía Arial en Blanco puro.", 
                                                 "Alerta Customizada", JOptionPane.PLAIN_MESSAGE);
        });
        
        bottomPanel.add(btnColor);
        bottomPanel.add(btnAlerta);
        
        mainPanel.add(lblTitulo, BorderLayout.NORTH);
        mainPanel.add(txtArea, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
