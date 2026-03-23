package com.javalearning.gui;

import javax.swing.*;
import java.awt.*;

public class AboutGUI {
    
    public AboutGUI() {
        JFrame frame = new JFrame("Créditos y Material Educativo");
        frame.setSize(480, 240);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.WHITE);
        
        JLabel lblTitle = new JLabel("Créditos y Diseño Estructural", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblTitle.setForeground(new Color(40, 60, 100));
        
        JLabel lblName = new JLabel("Ing. Mg. Víctor Castro", SwingConstants.CENTER);
        lblName.setFont(new Font("Segoe UI", Font.BOLD, 16));
        
        JLabel lblEmail = new JLabel("📧 Contacto: vfcastro@poligran.edu.co", SwingConstants.CENTER);
        lblEmail.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        lblEmail.setForeground(new Color(0, 100, 255));
        
        JLabel lblBody = new JLabel("Material Académico para Programación Avanzada en Arquitectura Automática Java", SwingConstants.CENTER);
        lblBody.setFont(new Font("Segoe UI", Font.PLAIN, 11));
        
        panel.add(lblTitle);
        panel.add(lblName);
        panel.add(lblEmail);
        panel.add(lblBody);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
