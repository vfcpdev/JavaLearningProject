package com.javalearning.gui;

import javax.swing.*;
import java.awt.*;

public class MainGUI {
    public static void launchGUI() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Proyecto de Aprendizaje de Java");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(550, 800); // Centrar en pantalla
            frame.setLocationRelativeTo(null);
            
            // Panel Principal
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(12, 1, 10, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            
            JLabel lblTitle = new JLabel("Menú Principal de Aprendizaje", SwingConstants.CENTER);
            lblTitle.setFont(new Font("Arial", Font.BOLD, 20));
            
            JButton btnDataTypes = new JButton("1. Tipos de Datos");
            btnDataTypes.setFont(new Font("Arial", Font.PLAIN, 16));
            
            JButton btnMathOps = new JButton("2. Operaciones Matemáticas");
            btnMathOps.setFont(new Font("Arial", Font.PLAIN, 16));
            
            JButton btnDataStructs = new JButton("3. Estructuras de Datos");
            btnDataStructs.setFont(new Font("Arial", Font.PLAIN, 16));
            
            JButton btnAlgoritmia = new JButton("4. Estructuras Algorítmicas");
            btnAlgoritmia.setFont(new Font("Arial", Font.PLAIN, 16));
            
            JButton btnFunciones = new JButton("5. Funciones y Métodos");
            btnFunciones.setFont(new Font("Arial", Font.PLAIN, 16));
            
            JButton btnPOO = new JButton("6. Prog. Orientada a Objetos"); 
            btnPOO.setFont(new Font("Arial", Font.PLAIN, 16));
            
            JButton btnExceptions = new JButton("7. Manejo de Excepciones");
            btnExceptions.setFont(new Font("Arial", Font.PLAIN, 16));
            
            JButton btnFixedArrays = new JButton("8. Arreglos y Matrices de Tam. Fijo");
            btnFixedArrays.setFont(new Font("Arial", Font.PLAIN, 16));

            JButton btnContainers = new JButton("9. Contenedores Estándar");
            btnContainers.setFont(new Font("Arial", Font.PLAIN, 16));

            JButton btnGuiDesign = new JButton("10. Personalización de Diseño Gráfico");
            btnGuiDesign.setFont(new Font("Arial", Font.PLAIN, 16));

            JButton btnNonLinear = new JButton("11. Contenedores No Lineales");
            btnNonLinear.setFont(new Font("Arial", Font.PLAIN, 16));

            btnDataTypes.addActionListener(e -> new DataTypesGUI());
            btnMathOps.addActionListener(e -> new MathOpsGUI());
            btnDataStructs.addActionListener(e -> new DataStructuresGUI());
            btnAlgoritmia.addActionListener(e -> new AlgorithmicStructuresGUI());
            btnFunciones.addActionListener(e -> new MethodsAndFunctionsGUI());
            btnPOO.addActionListener(e -> new OOPGUI());
            btnExceptions.addActionListener(e -> new ExceptionsGUI());
            btnFixedArrays.addActionListener(e -> new FixedSizeArraysGUI());
            btnContainers.addActionListener(e -> new StandardContainersGUI());
            btnGuiDesign.addActionListener(e -> new GraphicalCustomizationGUI());
            btnNonLinear.addActionListener(e -> new NonLinearContainersGUI());
            
            panel.add(lblTitle);
            panel.add(btnDataTypes);
            panel.add(btnMathOps);
            panel.add(btnDataStructs);
            panel.add(btnAlgoritmia);
            panel.add(btnFunciones);
            panel.add(btnPOO);
            panel.add(btnExceptions);
            panel.add(btnFixedArrays);
            panel.add(btnContainers);
            panel.add(btnGuiDesign);
            panel.add(btnNonLinear);
            
            frame.add(panel);
            frame.setVisible(true);
        });
    }
}
