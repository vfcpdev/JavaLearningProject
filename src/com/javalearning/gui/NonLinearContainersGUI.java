package com.javalearning.gui;

import javax.swing.*;
import java.awt.*;

public class NonLinearContainersGUI {
    
    public NonLinearContainersGUI() {
        JFrame frame = new JFrame("Simulador Visual: Conjuntos y Diccionarios");
        frame.setSize(750, 450);
        frame.setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        mainPanel.setBackground(new Color(15, 56, 90));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        // Panel Izquierdo: Set (Conjunto)
        JPanel setPanel = new JPanel(new BorderLayout());
        setPanel.setBackground(new Color(245, 250, 255));
        setPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(31, 178, 222), 2), 
            " HashSet: Evita Duplicados "
        ));
        
        JTextArea txtSet = new JTextArea("Lista de Invitados RAM:\n[ Ana, Carlos, Luisa ]\n");
        txtSet.setEditable(false);
        txtSet.setFont(new Font("Consolas", Font.PLAIN, 15));
        
        JPanel setInputPanel = new JPanel(new BorderLayout());
        JTextField tfInvitado = new JTextField("Ana");
        JButton btnAddInvitado = new JButton("Intentar Añadir");
        btnAddInvitado.setBackground(new Color(251, 175, 23));
        btnAddInvitado.setForeground(new Color(15, 56, 90));
        btnAddInvitado.setContentAreaFilled(false);
        btnAddInvitado.setOpaque(true);
        
        btnAddInvitado.addActionListener(e -> {
            String name = tfInvitado.getText().trim();
            if (name.equalsIgnoreCase("Ana") || name.equalsIgnoreCase("Carlos") || name.equalsIgnoreCase("Luisa")) {
                txtSet.append("\n❌ ¡" + name + " ya estaba en el Set! Rechazado automáticamente.");
            } else {
                txtSet.append("\n✅ " + name + " fue añadido con éxito.");
            }
        });
        
        setInputPanel.add(tfInvitado, BorderLayout.CENTER);
        setInputPanel.add(btnAddInvitado, BorderLayout.EAST);
        setPanel.add(new JScrollPane(txtSet), BorderLayout.CENTER);
        setPanel.add(setInputPanel, BorderLayout.SOUTH);
        
        // Panel Derecho: Map (Diccionario)
        JPanel mapPanel = new JPanel(new BorderLayout());
        mapPanel.setBackground(new Color(245, 250, 255));
        mapPanel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(236, 6, 119), 2), 
            " HashMap: Agenda Clave -> Valor "
        ));
        
        JTextArea txtMap = new JTextArea("Directorio cargado:\nVictor => 310-000-111\nMarina => 320-555-888\n\n");
        txtMap.setEditable(false);
        txtMap.setFont(new Font("Consolas", Font.PLAIN, 15));
        
        JPanel mapInputPanel = new JPanel(new BorderLayout());
        JTextField tfClave = new JTextField("Victor");
        JButton btnBuscar = new JButton("Buscar Clave");
        btnBuscar.setBackground(new Color(166, 206, 56));
        btnBuscar.setForeground(new Color(15, 56, 90));
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.setOpaque(true);
        
        btnBuscar.addActionListener(e -> {
            String clave = tfClave.getText().trim();
            if (clave.equalsIgnoreCase("Victor")) {
                txtMap.append("Result O(1): El teléfono es 310-000-111\n");
            } else if (clave.equalsIgnoreCase("Marina")) {
                txtMap.append("Result O(1): El teléfono es 320-555-888\n");
            } else {
                txtMap.append("Result O(1): Clave nula o irreconocible.\n");
            }
        });
        
        mapInputPanel.add(tfClave, BorderLayout.CENTER);
        mapInputPanel.add(btnBuscar, BorderLayout.EAST);
        mapPanel.add(new JScrollPane(txtMap), BorderLayout.CENTER);
        mapPanel.add(mapInputPanel, BorderLayout.SOUTH);
        
        mainPanel.add(setPanel);
        mainPanel.add(mapPanel);
        
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
