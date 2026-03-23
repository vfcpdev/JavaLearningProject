package com.javalearning.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DataStructuresGUI {
    private ArrayList<String> lista;
    private DefaultListModel<String> listModel;
    
    public DataStructuresGUI() {
        lista = new ArrayList<>();
        listModel = new DefaultListModel<>();
        
        JFrame frame = new JFrame("Estructuras de Datos (ArrayList en Swing)");
        frame.setSize(650, 400);
        frame.setLocationRelativeTo(null);
        
        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        
        JTextField txtElement = new JTextField(15);
        JButton btnAdd = new JButton("Agregar");
        JButton btnRemove = new JButton("Eliminar Sel.");
        
        topPanel.add(new JLabel("Nuevo Elemento:"));
        topPanel.add(txtElement);
        topPanel.add(btnAdd);
        topPanel.add(btnRemove);
        
        JList<String> jList = new JList<>(listModel);
        jList.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(jList);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        
        btnAdd.addActionListener(e -> {
            String val = txtElement.getText().trim();
            if (!val.isEmpty()) {
                lista.add(val);
                listModel.addElement("Índice " + (lista.size() - 1) + ": " + val);
                txtElement.setText("");
            }
        });
        
        btnRemove.addActionListener(e -> {
            int selectedIndex = jList.getSelectedIndex();
            if (selectedIndex != -1) {
                lista.remove(selectedIndex);
                // Re-dibujar toda la lista para actualizar índices visuales
                listModel.clear();
                for (int i = 0; i < lista.size(); i++) {
                    listModel.addElement("Índice " + i + ": " + lista.get(i));
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Selecciona un elemento para eliminar", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });
        
        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        
        // Agregar ejemplos iniciales
        String[] ejemplos = {"Concepto de Java", "Estructuras Dinámicas", "Aprender Swing"};
        for (String ej : ejemplos) {
            lista.add(ej);
            listModel.addElement("Índice " + (lista.size() - 1) + ": " + ej);
        }
        
        frame.setVisible(true);
    }
}
