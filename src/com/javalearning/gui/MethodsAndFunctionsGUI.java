package com.javalearning.gui;

import javax.swing.*;
import java.awt.*;

public class MethodsAndFunctionsGUI {
    
    // 4. Recursion Method
    private int calcularFactorial(int n) {
        if (n <= 1) return 1;
        return n * calcularFactorial(n - 1);
    }
    
    // 3. Methods and Strings Method
    private String enmascararCorreo(String correo) {
        if (correo.contains("@")) {
            String[] partes = correo.split("@");
            if (partes[0].length() > 2) {
                return partes[0].substring(0, 2) + "****@" + partes[1];
            }
        }
        return correo;
    }

    public MethodsAndFunctionsGUI() {
        JFrame frame = new JFrame("Funciones, Parámetros y Recursión");
        frame.setSize(650, 500);
        frame.setLocationRelativeTo(null);
        
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JTextArea infoArea = new JTextArea();
        infoArea.setEditable(false);
        infoArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        String info = " === CONCEPTOS DE FUNCIONES EN JAVA ===\n\n"
                    + "1. FUNCIONES: \n"
                    + "   Un bloque de código reutilizable. Ejemplo: calcularDatos()\n\n"
                    + "2. ARGUMENTOS Y PARÁMETROS: \n"
                    + "   Datos que se envían y reciben en el método. Ejemplo: logIn(usuario, pass)\n\n"
                    + "3. MÉTODOS Y CADENAS: \n"
                    + "   Encapsulación de lógica para procesamiento de texto.\n\n"
                    + "4. RECURSIÓN: \n"
                    + "   Una función que se invoca a sí misma partiendo de un caso base.\n\n"
                    + "-> Explora la interactividad usando los componentes agrupados abajo:";
        infoArea.setText(info);
        
        JPanel interactPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        
        // Panel Recursión
        JPanel pnlRecursion = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlRecursion.setBorder(BorderFactory.createTitledBorder("4. Demostración Recursión: Factorial"));
        JTextField txtFact = new JTextField("5", 5);
        JButton btnFact = new JButton("Factorial Recursivo ->");
        JLabel lblFactResult = new JLabel(" Resultado: ");
        lblFactResult.setForeground(Color.BLUE);
        
        btnFact.addActionListener(e -> {
            try {
                int n = Integer.parseInt(txtFact.getText());
                if (n > 12) {
                    lblFactResult.setText(" Error: Demasiado grande (overflow)");
                } else {
                    int res = calcularFactorial(Math.abs(n));
                    lblFactResult.setText(" Resultado: " + res);
                }
            } catch (NumberFormatException ex) {
                lblFactResult.setText(" Error: Ingrese entero.");
            }
        });
        
        pnlRecursion.add(new JLabel("Número entero (N):"));
        pnlRecursion.add(txtFact);
        pnlRecursion.add(btnFact);
        pnlRecursion.add(lblFactResult);
        
        // Panel Cadenas
        JPanel pnlString = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlString.setBorder(BorderFactory.createTitledBorder("3. MÉTODOS Y CADENAS: Enmascarar Parámetro (Correo)"));
        JTextField txtEmail = new JTextField("usuario_experto@tecnologia.com", 18);
        JButton btnEmail = new JButton("Procesar Cadena ->");
        JLabel lblEmailResult = new JLabel(" Resultado: ");
        lblEmailResult.setForeground(Color.BLUE);
        
        btnEmail.addActionListener(e -> {
            String correo = txtEmail.getText();
            lblEmailResult.setText(" Resultado: " + enmascararCorreo(correo));
        });
        
        pnlString.add(new JLabel("Argumento (Correo):"));
        pnlString.add(txtEmail);
        pnlString.add(btnEmail);
        pnlString.add(lblEmailResult);
        
        interactPanel.add(pnlRecursion);
        interactPanel.add(pnlString);
        
        mainPanel.add(new JScrollPane(infoArea), BorderLayout.CENTER);
        mainPanel.add(interactPanel, BorderLayout.SOUTH);
        
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
