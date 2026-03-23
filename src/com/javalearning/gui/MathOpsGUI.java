package com.javalearning.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MathOpsGUI {
    public MathOpsGUI() {
        JFrame frame = new JFrame("Calculadora de Operaciones Matemáticas");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new GridLayout(6, 2, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JLabel lblNum1 = new JLabel("Número 1:");
        JTextField txtNum1 = new JTextField("15");
        
        JLabel lblNum2 = new JLabel("Número 2:");
        JTextField txtNum2 = new JTextField("4");
        
        JButton btnSumar = new JButton("Sumar");
        JButton btnRestar = new JButton("Restar");
        JButton btnMult = new JButton("Multiplicar");
        JButton btnDiv = new JButton("Dividir");
        
        JLabel lblResult = new JLabel("Resultado: ", SwingConstants.CENTER);
        lblResult.setFont(new Font("Arial", Font.BOLD, 14));
        lblResult.setForeground(Color.BLUE);
        
        ActionListener operacion = e -> {
            try {
                double n1 = Double.parseDouble(txtNum1.getText());
                double n2 = Double.parseDouble(txtNum2.getText());
                double res = 0;
                String op = ((JButton) e.getSource()).getText();
                
                switch (op) {
                    case "Sumar": res = n1 + n2; break;
                    case "Restar": res = n1 - n2; break;
                    case "Multiplicar": res = n1 * n2; break;
                    case "Dividir": 
                        if(n2 == 0) {
                            JOptionPane.showMessageDialog(frame, "No se puede dividir por cero", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                        res = n1 / n2; 
                        break;
                }
                lblResult.setText("Resultado: " + res);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Ingrese números válidos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        };
        
        btnSumar.addActionListener(operacion);
        btnRestar.addActionListener(operacion);
        btnMult.addActionListener(operacion);
        btnDiv.addActionListener(operacion);
        
        panel.add(lblNum1); panel.add(txtNum1);
        panel.add(lblNum2); panel.add(txtNum2);
        panel.add(btnSumar); panel.add(btnRestar);
        panel.add(btnMult); panel.add(btnDiv);
        panel.add(new JLabel("")); // Espacio vacío
        panel.add(lblResult);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
