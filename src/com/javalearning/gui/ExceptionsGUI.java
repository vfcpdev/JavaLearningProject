package com.javalearning.gui;

import javax.swing.*;
import java.awt.*;

public class ExceptionsGUI {
    public ExceptionsGUI() {
        JFrame frame = new JFrame("Manejo de Excepciones (Try-Catch)");
        frame.setSize(550, 430);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JTextArea info = new JTextArea(
            "TRY-CATCH:\n" +
            "El bloque 'try' contiene el código que podría fallar.\n" +
            "El bloque 'catch' recibe la excepción generada impidiendo\n" +
            "que el programa se \"congele\" o caiga abruptamente.\n\n" +
            "FINALLY:\n" +
            "Bloque que siempre se ejecuta al final. Útil para cerrar\n" +
            "recursos (Base de Datos, archivos, etc).\n\n" +
            "-> Intenta ingresar letras en vez de números, o divide\n" +
            "   por cero, prevendremos que el programa colapse:"
        );
        info.setEditable(false);
        info.setFont(new Font("Monospaced", Font.PLAIN, 14));
        
        JPanel pnlInteract = new JPanel(new GridLayout(2, 2, 5, 5));
        JTextField txtNumerador = new JTextField("10");
        JTextField txtDenominador = new JTextField("0");
        JButton btnDividir = new JButton("Realizar División Segura");
        JLabel lblRes = new JLabel("Salida:");
        lblRes.setForeground(Color.RED);
        
        btnDividir.addActionListener(e -> {
            try {
                int num = Integer.parseInt(txtNumerador.getText());
                int den = Integer.parseInt(txtDenominador.getText());
                int division = num / den;
                lblRes.setForeground(new Color(0, 128, 0)); // VERDE
                lblRes.setText("Resultado Exitoso: " + division);
            } catch (ArithmeticException ex) {
                lblRes.setForeground(Color.RED);
                lblRes.setText("¡Catch! ArithmeticException. División por 0.");
            } catch (NumberFormatException ex) {
                lblRes.setForeground(Color.RED);
                lblRes.setText("¡Catch! NumberFormatException. Usa enteros.");
            } finally {
                System.out.println("[Terminal UI]: Se ejecutó finally después del botón.");
            }
        });
        
        pnlInteract.add(new JLabel("Dividendo:"));
        pnlInteract.add(txtNumerador);
        pnlInteract.add(new JLabel("Divisor (intenta con 0 o texto):"));
        pnlInteract.add(txtDenominador);
        
        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(pnlInteract, BorderLayout.NORTH);
        bottom.add(btnDividir, BorderLayout.CENTER);
        bottom.add(lblRes, BorderLayout.SOUTH);
        
        panel.add(new JScrollPane(info), BorderLayout.CENTER);
        panel.add(bottom, BorderLayout.SOUTH);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
