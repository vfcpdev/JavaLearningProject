package com.javalearning.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;

public class MainGUI {
    
    // Variables estáticas para el rastreo del Proceso Secundario JVM
    private static Process currentCliProcess;
    private static BufferedWriter processWriter;

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

            // --- NUEVO: HEADER INSTITUCIONAL ---
            JPanel topHeader = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 15));
            topHeader.setBackground(Color.WHITE);
            topHeader.setBorder(BorderFactory.createMatteBorder(0, 0, 5, 0, new Color(31, 178, 222))); // Borde inferior Cyan
            
            try {
                // Cargar logo y escalar altura inteligentemente
                ImageIcon logoIcon = new ImageIcon("docs/Logo_poli.jpg");
                Image img = logoIcon.getImage();
                if (img != null && logoIcon.getIconWidth() > 0) {
                    double aspect = (double) logoIcon.getIconWidth() / logoIcon.getIconHeight();
                    Image scaledImg = img.getScaledInstance((int)(60 * aspect), 60, Image.SCALE_SMOOTH);
                    topHeader.add(new JLabel(new ImageIcon(scaledImg)));
                }
            } catch (Exception e) {}
            
            JLabel lblCourseTitle = new JLabel("CURSO: Conceptos Fundamentales de Programación");
            lblCourseTitle.setFont(new Font("Segoe UI", Font.BOLD, 25));
            lblCourseTitle.setForeground(new Color(15, 56, 90)); // Navy Blue Pantone
            topHeader.add(lblCourseTitle);
            
            frame.setLayout(new BorderLayout());
            frame.add(topHeader, BorderLayout.NORTH);

            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
            splitPane.setDividerLocation(300);
            splitPane.setContinuousLayout(true);

            // PANEL IZQUIERDO: Menú de Módulos (JList)
            JPanel leftPanel = new JPanel(new BorderLayout());
            leftPanel.setBackground(new Color(15, 56, 90)); // Pantone 2955 C (Dark Blue)
            JLabel titleList = new JLabel("📚 Módulos de Aprendizaje", SwingConstants.LEFT);
            titleList.setFont(new Font("Segoe UI", Font.BOLD, 16));
            titleList.setForeground(new Color(31, 178, 222)); // Pantone 312 C (Light Blue)
            titleList.setBorder(new EmptyBorder(15, 10, 15, 10));
            leftPanel.add(titleList, BorderLayout.NORTH);

            String[] titles = {
                "1. Java Fundamentos (Historia/Arquitectura)", "2. Tipos de Datos y Memoria", "3. Operadores Matemáticos",
                "4. Interfaz de Datos (Base)", "5. Estructuras Algorítmicas",
                "6. Funciones y Métodos", "7. Prog. Orientada a Objetos",
                "8. Manejo de Excepciones", "9. Arreglos y Matrices Fijas",
                "10. Contenedores Estándar (LIFO/FIFO)", "11. Personalización de UI/UX",
                "12. Contenedores No Lineales (Sets/Maps)", "13. Modern Java (Records/Streams)",
                "14. Acerca del Diseñador (Autoría)"
            };

            String[] cliClasses = {
                "JavaHistoryCLI", "DataTypesCLI", "MathOpsCLI", "DataStructuresCLI", "AlgorithmicStructuresCLI",
                "MethodsAndFunctionsCLI", "OOPCLI", "ExceptionsCLI", "FixedSizeArraysCLI",
                "StandardContainersCLI", "GraphicalCustomizationCLI", "NonLinearContainersCLI", "ModernJavaCLI",
                "AboutCLI"
            };

            String[] guiClasses = {
                "JavaHistoryGUI", "DataTypesGUI", "MathOpsGUI", "DataStructuresGUI", "AlgorithmicStructuresGUI",
                "MethodsAndFunctionsGUI", "OOPGUI", "ExceptionsGUI", "FixedSizeArraysGUI",
                "StandardContainersGUI", "GraphicalCustomizationGUI", "NonLinearContainersGUI", "ModernJavaGUI",
                "AboutGUI"
            };
            
            String[] explanations = {
                "<b>1. Fundamentos e Historia:</b> Detalles del nacimiento de Java, la magia arquitectónica (JVM, JRE, JDK), el Bytecode neutro que permite <i>WORA</i>, dependencias en Maven/Gradle y su sintaxis básica.",
                "<b>2. Tipos de Datos:</b> Explica la memoria RAM y el uso de primitivos como int, double, boolean. Demostrando las capacidades físicas y los límites de máquina.",
                "<b>3. Matemáticas:</b> Operadores aritméticos que emulan calculadoras, jerarquía de operaciones, módulo y pre-incrementos.",
                "<b>4. Int. de Datos:</b> Estructuras base, envolturas de arreglos estándar y el uso iterativo de cadenas/strings.",
                "<b>5. Algoritmia:</b> Toma de decisiones condicionales (If/Else, Switch) y bucles para iteración cíclica (For, While, Do-While) analizando el flujo de control.",
                "<b>6. Métodos:</b> Reusabilidad del código al encapsular lógicas recurrentes. Paso de parámetros, valor de retorno (return) y recursividad emulando saltos en la Pila.",
                "<b>7. P.O.O (Caso Práctico: Empleado e Ingeniero):</b><br/>" +
                "&nbsp;• <b>Clase Base:</b> <code>Empleado</code>. Establece el método base <code>trabajar()</code> que hace tareas genéricas.<br/>" +
                "&nbsp;• <b>Herencia y Polimorfismo:</b> Una clase <code>Ingeniero extends Empleado</code>, obtiene su nombre pero implementa <code>@Override</code> para sobre-escribir su trabajo, arrojando ahora: <i>'está programando en Java'</i>.",
                "<b>8. Excepciones:</b> Modelos Try-Catch-Finally para interceptar fallos fatales de tiempo de ejecución sin permitir que el servidor colapse abruptamente (Ej: División por Cero).",
                "<b>9. Arreglos Fijos:</b> Memoria estática, matrices bidimensionales (como tableros u hojas de cálculo) y recorridos por índices de complejidad O(1).",
                "<b>10. Contenedores (LIFO/FIFO):</b> Pilas (Stack) y Colas (Queue) interactuando con ejemplos reales como Historiales de terminal o impresión local.",
                "<b>11. Diseño UI/UX:</b> Edición de componentes Swing inyectando estética: Colores planos y Layouts que desafían el estándar metálico.",
                "<b>12. Sets y Maps:</b> Contenedores no iterativos escudados por Códigos Hash. Rechazan sistemáticamente llaves duplicadas garantizando unicidad estructural.",
                "<b>13. Modern Java:</b> Adopciones de JDK 16+: Pattern Matching sintáctico (Casteo virtual), Clases inmutables Record y Filtrado algorítmico Pipeline mediante Streams Api.",
                "<b>14. Información Institucional:</b><br/>Arquitectura de Aprendizaje desarrollada y fundamentada por el <b>Ing. Mg. Víctor Castro</b>. <br/>Para inquietudes profesionales, escribe al correo acreditado: <i>vfcastro@poligran.edu.co</i>."
            };

            JList<String> moduleList = new JList<>(titles);
            moduleList.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            moduleList.setBackground(new Color(15, 56, 90)); // Dark Blue
            moduleList.setForeground(Color.WHITE);
            moduleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            moduleList.setSelectionBackground(new Color(236, 6, 119)); // Magenta Pantone 226 C
            moduleList.setSelectionForeground(Color.WHITE);
            
            // Margen para el JList
            moduleList.setBorder(new EmptyBorder(5, 5, 5, 5));
            leftPanel.add(new JScrollPane(moduleList), BorderLayout.CENTER);

            // PANEL DERECHO: Visualizador y Tabs
            JPanel rightPanel = new JPanel(new BorderLayout());
            rightPanel.setBackground(Color.WHITE);
            
            JLabel lblContentTitle = new JLabel("👈 Selecciona un módulo en el panel izquierdo...", SwingConstants.CENTER);
            lblContentTitle.setFont(new Font("Segoe UI", Font.BOLD, 20));
            lblContentTitle.setBorder(new EmptyBorder(15, 10, 15, 10));
            lblContentTitle.setForeground(new Color(15, 56, 90)); // Dark Blue Text
            rightPanel.add(lblContentTitle, BorderLayout.NORTH);

            // Sistema de Pestañas
            JTabbedPane tabbedPane = new JTabbedPane();
            tabbedPane.setFont(new Font("Segoe UI", Font.PLAIN, 15));

            JEditorPane txtExplanation = new JEditorPane("text/html", "");
            txtExplanation.setEditable(false);
            txtExplanation.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, true);
            txtExplanation.setFont(new Font("Segoe UI", Font.PLAIN, 15));
            
            // Área para compilar visualmente el texto del código CLI
            JTextArea txtCliCode = new JTextArea("Esperando selección...\n[El código fuente se cargará directamente del sistema de archivos]");
            txtCliCode.setFont(new Font("Consolas", Font.PLAIN, 14));
            txtCliCode.setEditable(false);
            txtCliCode.setBackground(new Color(15, 56, 90)); // Pantone Dark Blue
            txtCliCode.setForeground(new Color(166, 206, 56)); // Green Hack
            txtCliCode.setCaretColor(Color.WHITE);
            txtCliCode.setTabSize(4);
            
            // --- NUEVO: EMULADOR INTERACTIVO CLI ---
            JPanel emulatorPanel = new JPanel(new BorderLayout());
            emulatorPanel.setBackground(Color.BLACK);
            
            JTextArea txtConsoleOutput = new JTextArea("🖥️ Terminal Emulada Inactiva.\nSelecciona un Laboratorio y oprime [Ejecutar Consola CLI] debajo.");
            txtConsoleOutput.setFont(new Font("Consolas", Font.BOLD, 14));
            txtConsoleOutput.setBackground(Color.BLACK);
            txtConsoleOutput.setForeground(new Color(31, 178, 222)); // Light Blue
            txtConsoleOutput.setEditable(false);
            txtConsoleOutput.setLineWrap(true);
            
            JScrollPane scrollConsole = new JScrollPane(txtConsoleOutput);
            scrollConsole.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(31,178,222)), " Output JVM Interactivo ", 0, 0, new Font("Segoe UI", Font.BOLD, 12), Color.WHITE));
            
            JPanel inputBox = new JPanel(new BorderLayout());
            JTextField txtConsoleInput = new JTextField();
            txtConsoleInput.setFont(new Font("Consolas", Font.BOLD, 16));
            txtConsoleInput.setBackground(Color.DARK_GRAY);
            txtConsoleInput.setForeground(Color.WHITE);
            txtConsoleInput.setCaretColor(Color.WHITE);
            
            JButton btnSendInput = new JButton("Enviar Input (Enter) ↵");
            btnSendInput.setBackground(new Color(166, 206, 56)); // Green Hack
            btnSendInput.setForeground(new Color(15, 56, 90)); // Dark blue text
            btnSendInput.setFont(new Font("Segoe UI", Font.BOLD, 12));
            btnSendInput.setContentAreaFilled(false);
            btnSendInput.setOpaque(true);
            
            inputBox.add(txtConsoleInput, BorderLayout.CENTER);
            inputBox.add(btnSendInput, BorderLayout.EAST);
            
            emulatorPanel.add(scrollConsole, BorderLayout.CENTER);
            emulatorPanel.add(inputBox, BorderLayout.SOUTH);
            
            java.awt.event.ActionListener sendAction = ev -> {
                try {
                    if (processWriter != null) {
                        String inputData = txtConsoleInput.getText();
                        txtConsoleOutput.append(inputData + "\n");
                        processWriter.write(inputData + "\n");
                        processWriter.flush();
                        txtConsoleInput.setText("");
                    }
                } catch(Exception ex) {}
            };
            btnSendInput.addActionListener(sendAction);
            txtConsoleInput.addActionListener(sendAction);
            
            JSplitPane splitConsoleCode = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
            splitConsoleCode.setDividerLocation(360); // 60% Visual
            splitConsoleCode.setResizeWeight(0.6);    // Proporción 60/40
            splitConsoleCode.setTopComponent(new JScrollPane(txtCliCode));
            splitConsoleCode.setBottomComponent(emulatorPanel);

            // Área para el código GUI
            JTextArea txtGuiCode = new JTextArea("Esperando selección...\n[El código fuente se cargará directamente del sistema de archivos]");
            txtGuiCode.setFont(new Font("Consolas", Font.PLAIN, 14));
            txtGuiCode.setEditable(false);
            txtGuiCode.setBackground(new Color(15, 56, 90)); // Dark Blue
            txtGuiCode.setForeground(new Color(166, 206, 56)); // Green Hack
            txtGuiCode.setCaretColor(Color.WHITE);
            txtGuiCode.setTabSize(4);

            tabbedPane.addTab("📖 Explicación Teórica", new JScrollPane(txtExplanation));
            tabbedPane.addTab("🖥️ Código Fuente (Modo Consola)", splitConsoleCode);
            tabbedPane.addTab("🎨 Código Fuente (Interfaces Gráficas)", new JScrollPane(txtGuiCode));

            rightPanel.add(tabbedPane, BorderLayout.CENTER);

            // Panel Sur: El lanzador
            JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            bottomPanel.setBackground(Color.WHITE);
            bottomPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
            
            JButton btnLaunchCLI = new JButton("▶ Ejecutar Consola CLI Nativamente");
            btnLaunchCLI.setFont(new Font("Segoe UI", Font.BOLD, 15));
            btnLaunchCLI.setBackground(new Color(31, 178, 222)); // Light Blue
            btnLaunchCLI.setForeground(new Color(15, 56, 90)); // Dark Blue Text
            btnLaunchCLI.setContentAreaFilled(false);
            btnLaunchCLI.setOpaque(true);
            btnLaunchCLI.setFocusPainted(false);
            btnLaunchCLI.setEnabled(false);
            btnLaunchCLI.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            JButton btnLaunch = new JButton("Ver Ejemplo Visual (Swing) 🚀");
            btnLaunch.setFont(new Font("Segoe UI", Font.BOLD, 15));
            btnLaunch.setBackground(new Color(251, 175, 23)); // Orange Pantone 137 C
            btnLaunch.setForeground(new Color(15, 56, 90)); // Dark Blue Text
            btnLaunch.setContentAreaFilled(false);
            btnLaunch.setOpaque(true);
            btnLaunch.setFocusPainted(false);
            btnLaunch.setEnabled(false);
            btnLaunch.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            bottomPanel.add(btnLaunchCLI);
            bottomPanel.add(btnLaunch);
            rightPanel.add(bottomPanel, BorderLayout.SOUTH);

            // Listeners Lógicos: Si haces click en la lista...
            moduleList.addListSelectionListener(e -> {
                if (!e.getValueIsAdjusting()) {
                    int idx = moduleList.getSelectedIndex();
                    if (idx >= 0) {
                        lblContentTitle.setText("Modulo: " + titles[idx]);
                        
                        // Formatear Explicación HTML para la Pestaña 1 aplicando Pantone CSS Inyectado
                        String html = "<div style='padding:15px; font-family:Segoe UI; line-height: 1.6;'>" +
                                      "<h2 style='color:#0F385A; padding-bottom:5px; border-bottom:2px solid #1FB2DE;'>" + titles[idx] + "</h2>" +
                                      "<p style='color:#333; font-size:15px; margin-top:15px;'>" + explanations[idx] + "</p>" +
                                      "<div style='margin-top:25px; padding:15px; background-color:#eff3f8; border-left: 5px solid #EC0677; border-radius:5px;'>" +
                                      "<h3 style='margin-top:0; color:#0F385A;'>Correlación de Archivos Root:</h3>" +
                                      "<ul style='margin-bottom:0; color:#0F385A;'><li>Entorno CLI: <b><code>" + cliClasses[idx] + ".java</code></b></li>" +
                                      "<li>App Gráfica: <b style='color:#EC0677;'><code>" + guiClasses[idx] + ".java</code></b></li></ul>" +
                                      "</div></div>";
                        txtExplanation.setText(html);
                        
                        // Leer código local físico (Simulando un IDE embebido) y plasmarlo en Pestañas 2 y 3
                        txtCliCode.setText(readClassFile(SRC_CLI_PATH + cliClasses[idx] + ".java"));
                        txtGuiCode.setText(readClassFile(SRC_GUI_PATH + guiClasses[idx] + ".java"));
                        
                        // Permitir la simulación real oprimiendo el botón
                        btnLaunch.setEnabled(true);
                        btnLaunchCLI.setEnabled(true);
                    }
                }
            });

            // Si oprimen el botón CLI Emulado
            btnLaunchCLI.addActionListener(e -> {
                int idx = moduleList.getSelectedIndex();
                if(idx >= 0){
                    tabbedPane.setSelectedIndex(1);
                    runInteractiveCLI(idx, txtConsoleOutput, txtConsoleInput, cliClasses, txtCliCode);
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
            case 0: new JavaHistoryGUI(); break;
            case 1: new DataTypesGUI(); break;
            case 2: new MathOpsGUI(); break;
            case 3: new DataStructuresGUI(); break;
            case 4: new AlgorithmicStructuresGUI(); break;
            case 5: new MethodsAndFunctionsGUI(); break;
            case 6: new OOPGUI(); break;
            case 7: new ExceptionsGUI(); break;
            case 8: new FixedSizeArraysGUI(); break;
            case 9: new StandardContainersGUI(); break;
            case 10: new GraphicalCustomizationGUI(); break;
            case 11: new NonLinearContainersGUI(); break;
            case 12: new ModernJavaGUI(); break;
            case 13: new AboutGUI(); break;
        }
    }
    
    // Método que empotra un proceso Java Subyacente y lo amarra al JTextArea y JTextField
    private static void runInteractiveCLI(int idx, JTextArea terminalOut, JTextField terminalIn, String[] cliClasses, JTextArea srcCodeView) {
        if (currentCliProcess != null && currentCliProcess.isAlive()) {
            currentCliProcess.destroyForcibly();
        }
        terminalOut.setText(">>> Iniciando " + cliClasses[idx] + ".class en Sandbox de Sistema Operativo...\n\n");
        terminalIn.setText("");
        terminalIn.requestFocus();
        
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", "bin", "com.javalearning.cli." + cliClasses[idx]);
            pb.redirectErrorStream(true);
            currentCliProcess = pb.start();
            processWriter = new BufferedWriter(new OutputStreamWriter(currentCliProcess.getOutputStream()));
            
            // Hilo demonio para leer Bytes (y no congelar UI general)
            Thread readThread = new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(currentCliProcess.getInputStream(), "UTF-8"))) {
                    StringBuilder currentLineSb = new StringBuilder();
                    int c;
                    while ((c = reader.read()) != -1) {
                        final char character = (char) c;
                        
                        // Buffer para el Highlighter
                        if (character == '\n') {
                            final String sentence = currentLineSb.toString().trim();
                            currentLineSb.setLength(0);
                            if (!sentence.isEmpty()) {
                                SwingUtilities.invokeLater(() -> highlightCodeMatch(srcCodeView, sentence));
                            }
                        } else {
                            currentLineSb.append(character);
                            // Proyectar highlights para Prompts bloqueantes (Ej: "Ingresa tu Edad: ")
                            if (currentLineSb.toString().endsWith(": ") || currentLineSb.toString().endsWith("? ")) {
                                 final String prompt = currentLineSb.toString().trim();
                                 SwingUtilities.invokeLater(() -> highlightCodeMatch(srcCodeView, prompt));
                            }
                        }
                        
                        SwingUtilities.invokeLater(() -> {
                            terminalOut.append(String.valueOf(character));
                            terminalOut.setCaretPosition(terminalOut.getDocument().getLength());
                        });
                    }
                } catch (Exception ex) {}
            });
            readThread.setDaemon(true);
            readThread.start();
            
        } catch (Exception e) {
            terminalOut.append("\n[ERROR CRÍTICO AL INICIAR]: No se pudo hallar la clase binaria o JAVA no está instalado. Verifica el path: " + e.getMessage());
        }
    }
    
    // Algoritmo predictivo de trazabilidad entre Output Console y Lìneas Físicas de Código
    private static void highlightCodeMatch(JTextArea txtCode, String printedLine) {
        if (printedLine.length() < 4) return;
        String searchStr = printedLine.replace("\n", "").replace("\r", "");
        
        String srcText = txtCode.getText();
        int index = -1;
        
        // Disminución progresiva del prefijo (Asegura encajar strings dinámicos)
        for (int len = Math.min(25, searchStr.length()); len >= 8; len--) {
            String prefix = searchStr.substring(0, len);
            index = srcText.indexOf(prefix);
            if (index != -1) break;
        }
        
        if (index != -1) {
            try {
                int lineOfOffset = txtCode.getLineOfOffset(index);
                int startPos = txtCode.getLineStartOffset(lineOfOffset);
                int endPos = txtCode.getLineEndOffset(lineOfOffset);
                
                txtCode.getHighlighter().removeAllHighlights();
                txtCode.getHighlighter().addHighlight(startPos, endPos, new javax.swing.text.DefaultHighlighter.DefaultHighlightPainter(new Color(236, 6, 119, 130))); // Magenta Overlay
                
                Rectangle viewRect = txtCode.modelToView2D(startPos).getBounds();
                if(viewRect != null) {
                    txtCode.scrollRectToVisible(viewRect);
                }
            } catch (Exception e) {}
        }
    }
}
