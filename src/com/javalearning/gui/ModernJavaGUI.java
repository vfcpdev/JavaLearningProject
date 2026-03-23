package com.javalearning.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ModernJavaGUI {

    // Simple Record Model encapsulando getters invisibles
    public record Persona(String nombre, int edad) {}

    public ModernJavaGUI() {
        JFrame frame = new JFrame("Java Moderno Visual: Records & Streams API");
        frame.setSize(800, 480);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBackground(new Color(15, 56, 90)); // Pantone Dark Blue
        panel.setBorder(new EmptyBorder(15, 15, 15, 15));
        
        // Explicación de Records
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(245, 250, 255));
        topPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(31, 178, 222), 2), 
            " 1. Instanciando Datos usando Java Record "
        ));
        
        JTextArea txtRecord = new JTextArea(
            "Creamos una plantilla inmutable de la siguiente manera:\n" +
            "public record Persona(String nombre, int edad) {}\n\n" +
            "A diferencia de las Clases Clásicas... ¡Los Objetos Record ya traen todo configurado internamente!"
        );
        txtRecord.setFont(new Font("Consolas", Font.BOLD, 15));
        txtRecord.setEditable(false);
        txtRecord.setMargin(new Insets(10, 10, 10, 10));
        topPanel.add(txtRecord, BorderLayout.CENTER);
        
        // Lista Base y Stream API
        JPanel bodyPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        bodyPanel.setBackground(new Color(15, 56, 90));
        
        JTextArea txtLista = new JTextArea("Lista Base:\n\n1. Maria (Edad: 25)\n2. Juanito (Edad: 15)\n3. Victor (Edad: 30)\n");
        txtLista.setFont(new Font("Consolas", Font.PLAIN, 15));
        txtLista.setEditable(false);
        
        JTextArea txtResult = new JTextArea("Flujo (Stream) Procesado...\nEsperando Acción Matemático-Lógica.");
        txtResult.setFont(new Font("Consolas", Font.PLAIN, 15));
        txtResult.setBackground(new Color(10, 15, 20)); // Hacker Back
        txtResult.setForeground(new Color(166, 206, 56)); // Green Pantone
        txtResult.setEditable(false);
        
        bodyPanel.add(new JScrollPane(txtLista));
        bodyPanel.add(new JScrollPane(txtResult));
        
        // Controles de Acción (Streams)
        JPanel bottomPanel = new JPanel(new FlowLayout());
        bottomPanel.setBackground(new Color(15, 56, 90));
        
        JButton btnStream = new JButton("Filtrar Mayores de Edad con Stream .filter()");
        btnStream.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnStream.setBackground(new Color(251, 175, 23)); // Orange Pantone
        btnStream.setForeground(new Color(15, 56, 90));
        btnStream.setContentAreaFilled(false);
        btnStream.setOpaque(true);
        btnStream.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        java.util.List<Persona> grupo = java.util.List.of(
            new Persona("Maria", 25),
            new Persona("Juanito", 15),
            new Persona("Victor", 30)
        );
        
        btnStream.addActionListener(e -> {
            txtResult.setText("===== TUBERÍA STREAM INICIADA =====\n\n");
            
            // LÓGICA DE PROGRAMACIÓN MODERNA REAL
            grupo.stream()
                 .filter(persona -> persona.edad() >= 18)
                 .forEach(persona -> {
                     txtResult.append("-> Aprobado: " + persona.nombre() + " (Edad " + persona.edad() + ")\n");
                 });
                 
            txtResult.append("\n===================================\nJuanito fue filtrado instantáneamente.");
            btnStream.setEnabled(false);
        });
        
        bottomPanel.add(btnStream);
        
        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(bodyPanel, BorderLayout.CENTER);
        panel.add(bottomPanel, BorderLayout.SOUTH);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
