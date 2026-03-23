package com.javalearning.gui;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class JavaHistoryGUI {

    public JavaHistoryGUI() {
        JFrame frame = new JFrame("Módulo: Fundamentos de Java Interactivos (Historia, Sintaxis y Gestión)");
        frame.setSize(1000, 750);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.WHITE);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(420);
        splitPane.setBorder(null);
        
        // --- TEXTOS ---
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        leftPanel.setBackground(new Color(245, 250, 255));
        
        JTextPane txtInfo = new JTextPane();
        txtInfo.setContentType("text/html");
        txtInfo.setEditable(false);
        txtInfo.setBackground(new Color(245, 250, 255));
        txtInfo.setText(
            "<html><body style='font-family:Segoe UI, sans-serif; margin:5px; color:#222; font-size:13px;'>" +
            "<h2 style='color:#0F4A96; border-bottom:1px solid #ccc; padding-bottom:5px;'>1. Historia de Java</h2>" +
            "Iniciado en 1991 y liberado formalmente en 1995 por <b>James Gosling</b> en la matriz <i>Sun Microsystems</i> (ahora adquirido orgánicamente por Oracle). <br/><br/>Su nombre original iba a ser <i>'Oak'</i> (Roble estacionado fuera de las oficinas). Nació desafiando la norma de crear lenguajes exclusivos de un ecosistema." +
            
            "<br/><br/><h2 style='color:#0F4A96; border-bottom:1px solid #ccc; padding-bottom:5px;'>2. Sintaxis y Paradigmas</h2>" +
            "Heredero directo de la poderosa sintaxis en 'C'.<br/>" +
            "<b>▶ Fuertemente Tipado:</b> El compilador anida variables y te exige predecir matemáticamente sus comportamientos desde la primera línea.<br/>" +
            "<b>▶ OOP Puro Puro:</b> Abstrae mecánicas físicas dentro de paradigmas P.O.O. No existen métodos ni variables orbitando solas; todo yace encadenado y delimitado adentro de componentes denominados <code>class</code>." +
            
            "<br/><br/><h2 style='color:#0F4A96; border-bottom:1px solid #ccc; padding-bottom:5px;'>3. Arquitectura (Write Once, Run Anywhere)</h2>" +
            "A diferencia del código primitivo (e.g. Ensamblador) compilado a un hardware procesador muy específico (i.e Intel x86), un entorno Java <b>jamás se compila de cara al procesador</b>. Se convierte radicalmente en un dialecto crudo abstracto: el famoso <b>Bytecode (.class)</b>.<br/>" +
            "Al entrar en ejecución, una Máquina Mágica (<b>JVM</b> - Java Virtual Machine) hospedada en Windows nativo traduce el Bytecode de la noche a la mañana." +
            
            "<br/><br/><h2 style='color:#0F4A96; border-bottom:1px solid #ccc; padding-bottom:5px;'>4. Gestores Estructurales de Compilación</h2>" +
            "Unir docenas manuales de librerías en Java es un calvario. El entorno corporativo automatiza la adición y limpieza de repositorios con Gestores que inyectan el flujo CI/CD:<br/><br/>" +
            "<b>▶ Apache Maven:</b> Pionero estándar en la industria. Recoge diccionarios basados en XML (<code>pom.xml</code>) trayendo mágicamente librerías de internet local al CPU.<br/><br/>" +
            "<b>▶ Gradle:</b> El esqueleto contemporáneo que compila concurrentemente el ecosistema Android base. Implementa micro-scripts modulares (<code>build.gradle</code>)." +
            "</body></html>"
        );
        leftPanel.add(new JScrollPane(txtInfo), BorderLayout.CENTER);
        
        // --- DIAGRAMA VECTORIAL SOLICITADO ---
        JPanel rightPanel = new JPanel(new BorderLayout(5, 5));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JLabel lblTarget = new JLabel("Cargando Diagrama de Arquitectura On The Fly...", SwingConstants.CENTER);
        lblTarget.setFont(new Font("Segoe UI", Font.ITALIC, 14));
        
        try {
            String imgPath = "C:\\Users\\vfcp1\\.gemini\\antigravity\\brain\\fd7b96b9-b5db-465a-8191-1a840829b03b\\java_architecture_diagram_1774232438972.png";
            File vectorImg = new File(imgPath);
            if(vectorImg.exists()) {
                ImageIcon original = new ImageIcon(imgPath);
                Image scaler = original.getImage().getScaledInstance(550, 550, Image.SCALE_SMOOTH);
                lblTarget.setIcon(new ImageIcon(scaler));
                lblTarget.setText("");
            } else {
                lblTarget.setText("Imagen Arquitectónica Ausente en el Directorio: " + imgPath);
            }
        } catch(Exception ignored) {}
        
        JLabel lblBottomTarget = new JLabel("<html><center><i>La filosofía universal JVM:<br/>Código Fuente .java ➔ Compilador Javac ➔ Bytecode Neutral ➔ Reproducción Nativa OS</i></center></html>", SwingConstants.CENTER);
        lblBottomTarget.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblBottomTarget.setForeground(Color.GRAY);
        
        rightPanel.add(lblTarget, BorderLayout.CENTER);
        rightPanel.add(lblBottomTarget, BorderLayout.SOUTH);
        
        splitPane.setLeftComponent(leftPanel);
        splitPane.setRightComponent(rightPanel);
        
        frame.add(splitPane);
        frame.setVisible(true);
    }
}
