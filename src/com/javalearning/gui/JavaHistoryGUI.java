package com.javalearning.gui;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JavaHistoryGUI {
    
    // Variables de la Terminal Emulada
    private int step = 0;
    private JTextArea consoleArea;
    private JTextField inputField;
    private JButton submitBtn;

    public JavaHistoryGUI() {
        JFrame frame = new JFrame("Emulador Didáctico: Arquitectura, Sintaxis e Historia");
        frame.setSize(1050, 750);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(15, 56, 90));
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(420);
        splitPane.setBorder(null);
        
        // --- TEXTOS ---
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        leftPanel.setBackground(new Color(245, 250, 255));
        
        JTextPane txtInfo = new JTextPane();
        txtInfo.setContentType("text/html");
        txtInfo.setEditable(false);
        txtInfo.setBackground(new Color(245, 250, 255));
        txtInfo.setText(
            "<html><body style='font-family:Segoe UI, sans-serif; margin:5px; color:#222; font-size:13px;'>" +
            "<h2 style='color:#0F4A96; border-bottom:1px solid #ccc; padding-bottom:5px;'>1. Historia de Java</h2>" +
            "Iniciado en 1991 y liberado en 1995 por <b>James Gosling</b> (Sun Microsystems). <br/>Su nombre original iba a ser <i>'Oak'</i> (Roble). Nació desafiando la norma de crear lenguajes exclusivos de un sistema, buscando ejecutar en cualquier dispositivo." +
            
            "<br/><br/><h2 style='color:#0F4A96; border-bottom:1px solid #ccc; padding-bottom:5px;'>2. Paradigmas Interactivos</h2>" +
            "▶ <b>Fuertemente Tipado:</b> Exige declarar lógicamente las variables (Ej. <code>int x = 5;</code>).<br/>" +
            "▶ <b>OOP Puro:</b> Todo yace adentro de componentes <code>class</code>." +
            
            "<br/><br/><h2 style='color:#0F4A96; border-bottom:1px solid #ccc; padding-bottom:5px;'>3. Write Once, Run Anywhere</h2>" +
            "Java se compila hacia código intermedio neutro (<b>Bytecode .class</b>). Luego, la Máquina Virtual de Java (<b>JVM</b>) lo traduce agresivamente al OS Local (Mac/Win/Linux)." +
            
            "<br/><br/><h2 style='color:#0F4A96; border-bottom:1px solid #ccc; padding-bottom:5px;'>4. Gestores Estructurales</h2>" +
            "<b>▶ Apache Maven:</b> Gestor estándar. Usa diccionarios estrictos XML (<code>pom.xml</code>).<br/>" +
            "<b>▶ Gradle:</b> Gestor moderno, concurrente. Usa scripts DSL (<code>build.gradle</code>)." +
            "</body></html>"
        );
        leftPanel.add(new JScrollPane(txtInfo), BorderLayout.CENTER);
        
        // --- TERMINAL EMULADA INTERACTIVA ---
        JPanel rightPanel = new JPanel(new BorderLayout(5, 5));
        rightPanel.setBackground(new Color(15, 56, 90));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        consoleArea = new JTextArea();
        consoleArea.setBackground(new Color(0, 0, 0));
        consoleArea.setForeground(new Color(166, 206, 56)); // Verde Hacker (Pantone 375 C)
        consoleArea.setFont(new Font("Consolas", Font.BOLD, 14));
        consoleArea.setEditable(false);
        consoleArea.setMargin(new Insets(10, 10, 10, 10));
        consoleArea.setLineWrap(true);
        consoleArea.setWrapStyleWord(true);
        consoleArea.setText("====== CARGANDO TERMINAL EDUCATIVA ======\nIniciando entorno virtual JVM Didáctico...\n\n[SISTEMA]: ¡Bienvenido al material de Fundamentos Java!\nJava nació en 1995 (Sun Microsystems) siendo portabilizado con Bytecode.\n\n[1] Escribe 'CONTINUAR' en la caja inferior para inicializar la práctica sintáctica:\n> ");
        
        JScrollPane scrollConsole = new JScrollPane(consoleArea);
        scrollConsole.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(31, 178, 222), 2), 
            " Terminal Emuladora Java ", 
            TitledBorder.LEFT, TitledBorder.TOP, 
            new Font("Consolas", Font.BOLD, 12), Color.WHITE
        ));

        JPanel inputPanel = new JPanel(new BorderLayout(10, 10));
        inputPanel.setBackground(new Color(15, 56, 90));

        inputField = new JTextField();
        inputField.setFont(new Font("Consolas", Font.PLAIN, 16));
        inputField.setBackground(Color.DARK_GRAY);
        inputField.setForeground(Color.WHITE);
        inputField.setCaretColor(Color.WHITE);

        submitBtn = new JButton("Ingresar Comando ▶");
        submitBtn.setBackground(new Color(251, 175, 23)); // Orange
        submitBtn.setForeground(new Color(15, 56, 90)); // Navy Blue 
        submitBtn.setContentAreaFilled(false);
        submitBtn.setOpaque(true);
        submitBtn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(submitBtn, BorderLayout.EAST);
        
        // Controlador lógico del emulador de consola
        submitBtn.addActionListener((ActionEvent e) -> processInput());
        inputField.addActionListener((ActionEvent e) -> processInput()); // Enter key
        
        rightPanel.add(scrollConsole, BorderLayout.CENTER);
        rightPanel.add(inputPanel, BorderLayout.SOUTH);
        
        splitPane.setLeftComponent(leftPanel);
        splitPane.setRightComponent(rightPanel);
        
        frame.add(splitPane);
        frame.setVisible(true);
    }

    private void processInput() {
        String userInput = inputField.getText().trim();
        if(userInput.isEmpty()) return;
        
        inputField.setText("");
        consoleArea.append(userInput + "\n");
        
        switch (step) {
            case 0:
                step++;
                consoleArea.append("\n[SISTEMA]: Excelente. Entrando a práctica Interactiva de Sintaxis.\n");
                consoleArea.append("Java es un lenguaje Fuertemente Tipado. Siempre se declara el tipo.\n");
                consoleArea.append("Para crear una variable de número entero llamada 'edad' valiendo 50,\n");
                consoleArea.append("el programador debe escribir: int edad = 50;\n");
                consoleArea.append("\n[RETO 1]: Escribe el comando exacto en la consola inferior:\n> ");
                break;
            case 1:
                String val = userInput.replaceAll("\\s","");
                if (val.contains("intedad=50;")) {
                    consoleArea.append("\n[COMPILADOR]: ¡Asignación Exitosa en Memoria RAM!\n");
                } else {
                    consoleArea.append("\n[COMPILADOR WARNING]: Sintaxis ambigua, pero asimilamos el concepto lógico.\n");
                }
                step++;
                consoleArea.append("\n[RETO 2]: Ahora imprimamos en consola la variable.\n");
                consoleArea.append("En Java el método estándar de inyección Out es:\n");
                consoleArea.append("System.out.println(edad);\n");
                consoleArea.append("\n[REQUERIMIENTO]: Tipealo o cópialo abajo para ver la magia de impresión:\n> ");
                break;
            case 2:
                consoleArea.append("\n[NÚCLEO JVM EJECUTANdo: System.out.println]\n");
                consoleArea.append("-----------------------------\n");
                consoleArea.append("      50      \n");
                consoleArea.append("-----------------------------\n");
                step++;
                consoleArea.append("\n[SISTEMA]: Terminaste tu primera instrucción formal compilada.\n");
                consoleArea.append("Como ves, el compilador requiere órdenes muy estrictas. Para escalar proyectos,\n");
                consoleArea.append("los arquitectos de software usan MAVEN (pom.xml) o GRADLE (build.gradle)\n");
                consoleArea.append("para automatizar los procesos.\n");
                consoleArea.append("\n>> Emulación Completada. (Puedes cerrar esta ventana) <<\n");
                submitBtn.setEnabled(false);
                inputField.setEditable(false);
                break;
        }
    }
}
