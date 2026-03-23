package com.javalearning.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class MainGUI {

    private static final String SRC_CLI_PATH = "src/com/javalearning/cli/";
    private static final String SRC_GUI_PATH = "src/com/javalearning/gui/";

    public static void launchGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Plataforma de Aprendizaje Java (IDE View)");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1100, 750);
            frame.setLocationRelativeTo(null);

            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
            splitPane.setDividerLocation(300);
            splitPane.setContinuousLayout(true);

            // PANEL IZQUIERDO: Menú de Módulos (JList)
            JPanel leftPanel = new JPanel(new BorderLayout());
            leftPanel.setBackground(new Color(245, 247, 250));
            JLabel titleList = new JLabel("📚 Módulos de Aprendizaje", SwingConstants.LEFT);
            titleList.setFont(new Font("Segoe UI", Font.BOLD, 16));
            titleList.setBorder(new EmptyBorder(15, 10, 15, 10));
            leftPanel.add(titleList, BorderLayout.NORTH);

            String[] titles = {
                "1. Tipos de Datos y Memoria", "2. Operadores Matemáticos",
                "3. Interfaz de Datos (Base)", "4. Estructuras Algorítmicas",
                "5. Funciones y Métodos", "6. Prog. Orientada a Objetos",
                "7. Manejo de Excepciones", "8. Arreglos y Matrices Fijas",
                "9. Contenedores Estándar (LIFO/FIFO)", "10. Personalización de UI/UX",
                "11. Contenedores No Lineales (Sets/Maps)", "12. Modern Java (Records/Streams)"
            };

            String[] cliClasses = {
                "DataTypesCLI", "MathOpsCLI", "DataStructuresCLI", "AlgorithmicStructuresCLI",
                "MethodsAndFunctionsCLI", "OOPCLI", "ExceptionsCLI", "FixedSizeArraysCLI",
                "StandardContainersCLI", "GraphicalCustomizationCLI", "NonLinearContainersCLI", "ModernJavaCLI"
            };

            String[] guiClasses = {
                "DataTypesGUI", "MathOpsGUI", "DataStructuresGUI", "AlgorithmicStructuresGUI",
                "MethodsAndFunctionsGUI", "OOPGUI", "ExceptionsGUI", "FixedSizeArraysGUI",
                "StandardContainersGUI", "GraphicalCustomizationGUI", "NonLinearContainersGUI", "ModernJavaGUI"
            };
            
            String[] explanations = {
                "<b>1. Tipos de Datos:</b> Explica la memoria RAM y el uso de primitivos como int, double, boolean. Demostrando las capacidades físicas y los límites de máquina.",
                "<b>2. Matemáticas:</b> Operadores aritméticos que emulan calculadoras, jerarquía de operaciones, módulo y pre-incrementos.",
                "<b>3. Int. de Datos:</b> Estructuras base, envolturas de arreglos estándar y el uso iterativo de cadenas/strings.",
                "<b>4. Algoritmia:</b> Toma de decisiones condicionales (If/Else, Switch) y bucles para iteración cíclica (For, While, Do-While) analizando el flujo de control.",
                "<b>5. Métodos:</b> Reusabilidad del código al encapsular lógicas recurrentes. Paso de parámetros, valor de retorno (return) y recursividad emulando saltos en la Pila.",
                "<b>6. P.O.O:</b> Moldeado de entidades de la vida real mediante Clases y Objetos. Explora Herencia, Polimorfismo y Encapsulación con atributos privados.",
                "<b>7. Excepciones:</b> Modelos Try-Catch-Finally para interceptar fallos fatales de tiempo de ejecución sin permitir que el servidor colapse abruptamente (Ej: División por Cero).",
                "<b>8. Arreglos Fijos:</b> Memoria estática, matrices bidimensionales (como tableros u hojas de cálculo) y recorridos por índices de complejidad O(1).",
                "<b>9. Contenedores (LIFO/FIFO):</b> Pilas (Stack) y Colas (Queue) interactuando con ejemplos reales como Historiales de terminal o impresión local.",
                "<b>10. Diseño UI/UX:</b> Edición de componentes Swing inyectando estética: Colores planos y Layouts que desafían el estándar metálico.",
                "<b>11. Sets y Maps:</b> Contenedores no iterativos escudados por Códigos Hash. Rechazan sistemáticamente llaves duplicadas garantizando unicidad estructural.",
                "<b>12. Modern Java:</b> Adopciones de JDK 16+: Pattern Matching sintáctico (Casteo virtual), Clases inmutables Record y Filtrado algorítmico Pipeline mediante Streams Api."
            };

            JList<String> moduleList = new JList<>(titles);
            moduleList.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            moduleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            
            // Margen para el JList
            moduleList.setBorder(new EmptyBorder(5, 5, 5, 5));
            leftPanel.add(new JScrollPane(moduleList), BorderLayout.CENTER);

            // PANEL DERECHO: Visualizador y Tabs
            JPanel rightPanel = new JPanel(new BorderLayout());
            
            JLabel lblContentTitle = new JLabel("👈 Selecciona un módulo en el panel izquierdo...", SwingConstants.CENTER);
            lblContentTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
            lblContentTitle.setBorder(new EmptyBorder(15, 10, 15, 10));
            lblContentTitle.setForeground(new Color(25, 50, 85));
            rightPanel.add(lblContentTitle, BorderLayout.NORTH);

            // Sistema de Pestañas
            JTabbedPane tabbedPane = new JTabbedPane();
            tabbedPane.setFont(new Font("Segoe UI", Font.PLAIN, 15));

            JEditorPane txtExplanation = new JEditorPane("text/html", "");
            txtExplanation.setEditable(false);
            txtExplanation.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
            txtExplanation.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            
            // Área para compilar visualmente el texto del código CLI
            JTextArea txtCliCode = new JTextArea("Esperando selección...\n[El código fuente se cargará directamente del sistema de archivos locales]");
            txtCliCode.setFont(new Font("Consolas", Font.PLAIN, 14));
            txtCliCode.setEditable(false);
            txtCliCode.setBackground(new Color(35, 38, 45));
            txtCliCode.setForeground(new Color(230, 235, 240));
            txtCliCode.setTabSize(4);

            // Área para el código GUI
            JTextArea txtGuiCode = new JTextArea("Esperando selección...\n[El código fuente se cargará directamente del sistema de archivos locales]");
            txtGuiCode.setFont(new Font("Consolas", Font.PLAIN, 14));
            txtGuiCode.setEditable(false);
            txtGuiCode.setBackground(new Color(35, 38, 45));
            txtGuiCode.setForeground(new Color(230, 235, 240));
            txtGuiCode.setTabSize(4);

            tabbedPane.addTab("📖 Explicación Teórica", new JScrollPane(txtExplanation));
            tabbedPane.addTab("🖥️ Código Fuente (Modo Consola)", new JScrollPane(txtCliCode));
            tabbedPane.addTab("🎨 Código Fuente (Interfaces Gráficas)", new JScrollPane(txtGuiCode));

            rightPanel.add(tabbedPane, BorderLayout.CENTER);

            // Panel Sur: El lanzador
            JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            bottomPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
            
            JButton btnLaunch = new JButton("▶️ Ejecutar Laboratorio Visual de este Módulo");
            btnLaunch.setFont(new Font("Segoe UI", Font.BOLD, 15));
            btnLaunch.setBackground(new Color(30, 130, 230));
            btnLaunch.setForeground(Color.WHITE);
            btnLaunch.setFocusPainted(false);
            btnLaunch.setEnabled(false);
            btnLaunch.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            bottomPanel.add(btnLaunch);
            rightPanel.add(bottomPanel, BorderLayout.SOUTH);

            // Listeners Lógicos: Si haces click en la lista...
            moduleList.addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    int idx = moduleList.getSelectedIndex();
                    if (idx >= 0) {
                        lblContentTitle.setText("Modulo: " + titles[idx]);
                        
                        // Formatear Explicación HTML para la Pestaña 1
                        String html = "<div style='padding:15px; font-family:Segoe UI; line-height: 1.6;'>" +
                                      "<h2 style='color:#193255; padding-bottom:5px; border-bottom:1px solid #ccc;'>" + titles[idx] + "</h2>" +
                                      "<p style='color:#333; font-size:15px; margin-top:15px;'>" + explanations[idx] + "</p>" +
                                      "<div style='margin-top:25px; padding:15px; background-color:#eff3f8; border-radius:5px;'>" +
                                      "<h3 style='margin-top:0;'>Archivos Java Correspondientes:</h3>" +
                                      "<ul style='margin-bottom:0;'><li><b>" + cliClasses[idx] + ".java</b> (Clínico puro)</li>" +
                                      "<li><b>" + guiClasses[idx] + ".java</b> (Orientado a Ventanas Swing)</li></ul>" +
                                      "</div></div>";
                        txtExplanation.setText(html);
                        
                        // Leer código local físico (Simulando un IDE embebido) y plasmarlo en Pestañas 2 y 3
                        txtCliCode.setText(readClassFile(SRC_CLI_PATH + cliClasses[idx] + ".java"));
                        txtGuiCode.setText(readClassFile(SRC_GUI_PATH + guiClasses[idx] + ".java"));
                        
                        // Permitir la simulación real oprimiendo el botón
                        btnLaunch.setEnabled(true);
                    }
                }
            });

            // Si oprimen el botón Launch inferior
            btnLaunch.addActionListener(e -> {
                int idx = moduleList.getSelectedIndex();
                if(idx >= 0){
                    launchSpecificGUI(idx);
                }
            });

            // Ensamblar la división
            splitPane.setLeftComponent(leftPanel);
            splitPane.setRightComponent(rightPanel);

            frame.add(splitPane);
            frame.setVisible(true);
        });
    }

    private static String readClassFile(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException ex) {
            return "// ERROR SISTÉMICO: No se pudo cargar el archivo original en la ruta: \n// " + path + 
                   "\n\n// Esto suele suceder si el proyecto está siendo ejecutado fuera de la ruta base (d:\\CFP\\JavaLearningProject)\n" +
                   "// Revise que el Working Directory apunte a la raíz principal del repositorio.";
        }
    }

    private static void launchSpecificGUI(int idx) {
        switch (idx) {
            case 0: new DataTypesGUI(); break;
            case 1: new MathOpsGUI(); break;
            case 2: new DataStructuresGUI(); break;
            case 3: new AlgorithmicStructuresGUI(); break;
            case 4: new MethodsAndFunctionsGUI(); break;
            case 5: new OOPGUI(); break;
            case 6: new ExceptionsGUI(); break;
            case 7: new FixedSizeArraysGUI(); break;
            case 8: new StandardContainersGUI(); break;
            case 9: new GraphicalCustomizationGUI(); break;
            case 10: new NonLinearContainersGUI(); break;
            case 11: new ModernJavaGUI(); break;
        }
    }
}
