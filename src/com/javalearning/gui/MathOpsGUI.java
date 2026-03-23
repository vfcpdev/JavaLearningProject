package com.javalearning.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.Year;

public class MathOpsGUI {
    
    public MathOpsGUI() {
        JFrame frame = new JFrame("Calculadora Sencilla de Edad Biológica (Matemáticas Básicas)");
        frame.setSize(500, 350);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(15, 56, 90)); // Pantone Dark Blue
        
        JPanel panel = new JPanel(new GridLayout(4, 1, 15, 15));
        panel.setBackground(new Color(15, 56, 90));
        panel.setBorder(new EmptyBorder(30, 30, 30, 30));
        
        JLabel lblTitle = new JLabel("Ingrese su Año de Nacimiento (Ej. 1995):", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblTitle.setForeground(new Color(31, 178, 222)); // Pantone Light Blue
        
        JTextField txtYear = new JTextField();
        txtYear.setHorizontalAlignment(JTextField.CENTER);
        txtYear.setFont(new Font("Consolas", Font.BOLD, 22));
        txtYear.setBackground(new Color(35, 45, 60));
        txtYear.setForeground(new Color(166, 206, 56)); // Green Pantone Hacker
        txtYear.setCaretColor(Color.WHITE);
        txtYear.setBorder(BorderFactory.createLineBorder(new Color(31, 178, 222), 2));
        
        JButton btnCalcular = new JButton("Realizar Operación Aritmética");
        btnCalcular.setBackground(new Color(251, 175, 23)); // Pantone Orange
        btnCalcular.setForeground(new Color(15, 56, 90));
        btnCalcular.setFont(new Font("Segoe UI", Font.BOLD, 15));
        btnCalcular.setFocusPainted(false);
        btnCalcular.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JLabel lblResult = new JLabel("Esperando datos matemáticos...", SwingConstants.CENTER);
        lblResult.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblResult.setForeground(new Color(236, 6, 119)); // Pantone Magenta Pink
        
        // Listeners
        btnCalcular.addActionListener(e -> {
            try {
                int birthYear = Integer.parseInt(txtYear.getText().trim());
                int currentYear = Year.now().getValue();
                
                int age = currentYear - birthYear;
                
                if (age < 0 || age > 130) {
                    lblResult.setText("❌ Edad irracional: " + age + " años!");
                    lblResult.setForeground(Color.RED);
                } else {
                    lblResult.setText("✅ ¡Tu edad es " + age + " años!");
                    lblResult.setForeground(new Color(166, 206, 56)); // Green Pantone
                }
            } catch (NumberFormatException ex) {
                lblResult.setText("❌ Por favor digite números válidos entero.");
                lblResult.setForeground(Color.RED);
            }
        });
        
        panel.add(lblTitle);
        panel.add(txtYear);
        panel.add(btnCalcular);
        panel.add(lblResult);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
