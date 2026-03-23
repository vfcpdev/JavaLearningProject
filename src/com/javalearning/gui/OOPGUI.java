package com.javalearning.gui;

import javax.swing.*;
import java.awt.*;

public class OOPGUI {
    // Clases internas para la demostración
    class Empleado {
        String nombre;
        Empleado(String n) { nombre = n; }
        String trabajar() { return nombre + " está trabajando de forma general."; }
    }
    class Ingeniero extends Empleado {
        Ingeniero(String n) { super(n); }
        @Override String trabajar() { return nombre + " está programando en Java."; }
    }

    public OOPGUI() {
        JFrame frame = new JFrame("Programación Orientada a Objetos");
        frame.setSize(550, 450);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JTextArea info = new JTextArea(
            "1. CLASES: Definen atributos y métodos genéricos.\n" +
            "2. OBJETOS: Instancias de clases vivas en memoria.\n" +
            "3. HERENCIA: Creación de clases que absorben lógica\n" +
            "   de clases padres y evitan repetir código.\n" +
            "4. POLIMORFISMO: Comportamiento múltiple de métodos \n" +
            "   con el mismo nombre pero clases distintas.\n\n" +
            "-> Ejemplo interactivo de Herencia y Polimorfismo:"
        );
        info.setEditable(false);
        info.setFont(new Font("Monospaced", Font.PLAIN, 14));
        
        JPanel interactPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        JButton btnEmpleado = new JButton("Crear Empleado (Clase Base)");
        JButton btnIng = new JButton("Crear Ingeniero (Hija / Sobrescrita)");
        JLabel lblResultado = new JLabel(" Acción en Polimorfismo: Esperando...", SwingConstants.CENTER);
        lblResultado.setForeground(Color.blue);
        
        btnEmpleado.addActionListener(e -> {
            Empleado emp = new Empleado("Juan");
            lblResultado.setText(" Acción de Empleado: " + emp.trabajar());
        });
        
        btnIng.addActionListener(e -> {
            Ingeniero ing = new Ingeniero("Ana (Ingeniera)");
            lblResultado.setText(" Acción de Ingeniero: " + ing.trabajar());
        });
        
        interactPanel.add(btnEmpleado);
        interactPanel.add(btnIng);
        interactPanel.add(lblResultado);
        
        panel.add(new JScrollPane(info), BorderLayout.CENTER);
        panel.add(interactPanel, BorderLayout.SOUTH);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
