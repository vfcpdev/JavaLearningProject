package com.javalearning.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainGUI {

    public static void launchGUI() {
        // Establecer el Aspecto Visual Nativo Moderno (Look & Feel del Sistema Windows/Mac)
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Panel Interactivo Java (Laboratorios UI)");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(850, 580);
            frame.setLocationRelativeTo(null);

            // Fondo Principal con color suave corporativo
            JPanel contentPane = new JPanel(new BorderLayout(20, 20));
            contentPane.setBackground(new Color(242, 246, 252)); 
            contentPane.setBorder(new EmptyBorder(25, 35, 25, 35));

            // Encabezado Moderno (Título y Subtítulo)
            JPanel headerPanel = new JPanel(new BorderLayout(5, 5));
            headerPanel.setOpaque(false);
            JLabel lblTitle = new JLabel("🚀 Compendio Tecnológico de Conceptos Java", SwingConstants.CENTER);
            lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 26));
            lblTitle.setForeground(new Color(25, 50, 85));
            
            JLabel lblSub = new JLabel("Seleccione un laboratorio inferior para interactuar con interfaces en vivo", SwingConstants.CENTER);
            lblSub.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            lblSub.setForeground(new Color(120, 130, 140));
            
            headerPanel.add(lblTitle, BorderLayout.NORTH);
            headerPanel.add(lblSub, BorderLayout.SOUTH);

            // Cuadrícula Dashboard (6 filas x 2 columnas = 12 Módulos perfectos)
            JPanel gridPanel = new JPanel(new GridLayout(6, 2, 15, 15));
            gridPanel.setOpaque(false);

            String[] titles = {
                "1. Tipos de Datos y Memoria", "2. Operadores Matemáticos",
                "3. Interfaz de Datos (Lists/Maps)", "4. Estructuras Algorítmicas",
                "5. Diseño de Métodos Modulares", "6. Prog. Orientada a Objetos",
                "7. Blindaje de Excepciones", "8. Laboratorio Arrays Fijos",
                "9. Arquitectura LIFO/FIFO", "10. Modificadores Swing UI/UX",
                "11. Filtros Hashing (Sets)", "12. Modern Java (dev.java)"
            };

            Runnable[] actions = {
                () -> new DataTypesGUI(), () -> new MathOpsGUI(),
                () -> new DataStructuresGUI(), () -> new AlgorithmicStructuresGUI(),
                () -> new MethodsAndFunctionsGUI(), () -> new OOPGUI(),
                () -> new ExceptionsGUI(), () -> new FixedSizeArraysGUI(),
                () -> new StandardContainersGUI(), () -> new GraphicalCustomizationGUI(),
                () -> new NonLinearContainersGUI(), () -> new ModernJavaGUI()
            };

            // Inyectar dinámica de botones
            for (int i = 0; i < titles.length; i++) {
                gridPanel.add(createModernButton(titles[i], actions[i]));
            }

            contentPane.add(headerPanel, BorderLayout.NORTH);
            contentPane.add(gridPanel, BorderLayout.CENTER);

            frame.setContentPane(contentPane);
            frame.setVisible(true);
        });
    }

    // Función constructora para Botones Planos con transiciones Hover
    private static JButton createModernButton(String text, Runnable action) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setBackground(Color.WHITE);
        btn.setForeground(new Color(40, 60, 90));
        btn.setFocusPainted(false); // Remueve la caja puntejada tradicional
        // btn.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(210, 220, 230)), new EmptyBorder(5, 5, 5, 5)));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Listener de eventos para Animaciones MouseHover CSS-like
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(new Color(230, 238, 255)); // Azul brillante sutil
                btn.setForeground(new Color(10, 80, 190));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                btn.setBackground(Color.WHITE); // Regresa a estado original
                btn.setForeground(new Color(40, 60, 90));
            }
        });

        // Enlazar lógica de despliegue al clic
        btn.addActionListener(e -> action.run());
        return btn;
    }
}
