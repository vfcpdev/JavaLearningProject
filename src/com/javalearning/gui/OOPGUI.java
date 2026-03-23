package com.javalearning.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class OOPGUI {
    
    // Jerarquía de Clases Reales en Java
    static class Empleado {
        protected String nombre;
        public Empleado(String n) { nombre = n; }
        public String trabajar() { return "El Empleado " + nombre + " hace trámites generales de oficina."; }
    }
    
    static class Ingeniero extends Empleado {
        public Ingeniero(String n) { super(n); }
        @Override 
        public String trabajar() { return "El Ingeniero " + nombre + " diseña arquitecturas de Nube y Redes TCP/IP."; }
    }

    public OOPGUI() {
        JFrame frame = new JFrame("Constructor de Objetos en Memoria (POO)");
        frame.setSize(700, 520);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(245, 250, 255));
        
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        mainPanel.setOpaque(false);
        
        // Explicación Superior
        JLabel lblExplicacion = new JLabel("<html><h2 style='color:#0F385A; margin:0;'>Taller Interactivo de POO</h2>"
                                         + "<p style='color:#333; font-size:12px; margin-top:5px;'>"
                                         + "Escribe los nombres y pulsa Instanciar. Al llamar al método <b>.trabajar()</b>, "
                                         + "verás el <b style='color:#EC0677;'>Polimorfismo</b> en acción: mismo método, distinto comportamiento según la clase.</p></html>");
        mainPanel.add(lblExplicacion, BorderLayout.NORTH);
        
        // Controles de Inicialización
        JPanel controls = new JPanel(new GridLayout(2, 2, 10, 15));
        controls.setOpaque(false);
        
        JTextField tfEmpleado = new JTextField("Juan");
        tfEmpleado.setFont(new Font("Consolas", Font.BOLD, 15));
        JButton btnEmp = new JButton("Instanciar Padre: new Empleado()");
        btnEmp.setBackground(new Color(166, 206, 56)); // Green
        btnEmp.setForeground(new Color(15, 56, 90));
        btnEmp.setOpaque(true);
        btnEmp.setContentAreaFilled(false);
        btnEmp.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnEmp.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JTextField tfIngeniero = new JTextField("Ana");
        tfIngeniero.setFont(new Font("Consolas", Font.BOLD, 15));
        JButton btnIng = new JButton("Instanciar Hija: new Ingeniero()");
        btnIng.setBackground(new Color(251, 175, 23)); // Orange
        btnIng.setForeground(new Color(15, 56, 90));
        btnIng.setOpaque(true);
        btnIng.setContentAreaFilled(false);
        btnIng.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnIng.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        JPanel pnl1 = new JPanel(new BorderLayout(5, 0)); pnl1.setOpaque(false);
        pnl1.add(new JLabel(" Nombre Empleado: "), BorderLayout.WEST); pnl1.add(tfEmpleado, BorderLayout.CENTER);
        
        JPanel pnl2 = new JPanel(new BorderLayout(5, 0)); pnl2.setOpaque(false);
        pnl2.add(new JLabel(" Nombre Ingeniero(a): "), BorderLayout.WEST); pnl2.add(tfIngeniero, BorderLayout.CENTER);
        
        controls.add(pnl1); controls.add(btnEmp);
        controls.add(pnl2); controls.add(btnIng);
        
        // Consola Visual
        JTextArea txtOutput = new JTextArea(">>> Máquina Virtual de Java iniciada.\n>>> Esperando crear Objetos en Memoria RAM...\n\n");
        txtOutput.setFont(new Font("Consolas", Font.BOLD, 14));
        txtOutput.setEditable(false);
        txtOutput.setBackground(new Color(15, 56, 90));
        txtOutput.setForeground(Color.WHITE);
        txtOutput.setMargin(new Insets(10, 10, 10, 10));
        
        mainPanel.add(controls, BorderLayout.CENTER);
        mainPanel.add(new JScrollPane(txtOutput), BorderLayout.SOUTH);
        ((JScrollPane)mainPanel.getComponent(2)).setPreferredSize(new Dimension(600, 250));
        
        // Listeners Puros
        btnEmp.addActionListener(e -> {
            String name = tfEmpleado.getText().trim();
            Empleado emp = new Empleado(name.isEmpty() ? "Desconocido" : name);
            txtOutput.append("[CLASE PADRE CREADA]: Empleado emp = new Empleado(\"" + emp.nombre + "\");\n");
            txtOutput.append("-> INVOCANDO emp.trabajar(); // " + emp.trabajar() + "\n\n");
            txtOutput.setCaretPosition(txtOutput.getDocument().getLength());
        });
        
        btnIng.addActionListener(e -> {
            String name = tfIngeniero.getText().trim();
            Ingeniero ing = new Ingeniero(name.isEmpty() ? "Desconocida" : name);
            txtOutput.append("[CLASE HIJA CREADA]: Ingeniero ing = new Ingeniero(\"" + ing.nombre + "\");\n");
            txtOutput.append("-> INVOCANDO ing.trabajar(); // " + ing.trabajar() + "\n\n");
            txtOutput.setCaretPosition(txtOutput.getDocument().getLength());
        });
        
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
