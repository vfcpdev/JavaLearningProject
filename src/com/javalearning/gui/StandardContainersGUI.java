package com.javalearning.gui;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;

public class StandardContainersGUI {
    // Variables globales para el visualizador en vivo
    private JTextPane codeViewer;
    private JLabel lblExplanation;
    private Highlighter highlighter;
    private Object currentHighlight;

    public StandardContainersGUI() {
        JFrame frame = new JFrame("Intérprete Visual: Ejecución de Estructuras LIFO y FIFO");
        frame.setSize(1050, 680);
        frame.setLocationRelativeTo(null);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(450);
        
        // --- PANEL IZQUIERDO: Laboratorio Interactivo ---
        JPanel leftPanel = new JPanel(new GridLayout(3, 1, 15, 15));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        leftPanel.setBackground(new Color(245, 248, 252));

        // 1. Pila LIFO (Navegador)
        JPanel pnlStack = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pnlStack.setBackground(Color.WHITE);
        pnlStack.setBorder(BorderFactory.createTitledBorder("Pila LIFO - Navegador Web Interactivo"));
        Stack<String> historialBrowser = new Stack<>();
        JButton btnGo = new JButton("🌐 Visitar URL (Push)");
        JButton btnBack = new JButton("🔙 Retornar Atrás (Pop)");
        JLabel lblStack = new JLabel("Historial de Navegación: []");
        lblStack.setForeground(new Color(20, 80, 200));
        
        btnGo.addActionListener(e -> { 
            String url = JOptionPane.showInputDialog(frame, "Introduce la nueva URL Web (Ej: Dirección 10):", "Apilar LIFO", JOptionPane.QUESTION_MESSAGE);
            if (url != null && !url.trim().isEmpty()) {
                historialBrowser.push(url); 
                lblStack.setText("Historial: " + historialBrowser.toString()); 
                highlightCode(0, "historialBrowser.push(url);",
                    "El método .push() inyecta la URL ["+url+"] directamente en el 'Tope' (Cima) de la memoria Pila.\nEs LIFO, por lo que este valor tapará a todos los URL anteriores.");
            }
        });
        
        btnBack.addActionListener(e -> { 
            if(!historialBrowser.isEmpty()) {
                String popped = historialBrowser.pop(); 
                lblStack.setText("Historial: " + historialBrowser.toString()); 
                highlightCode(1, "String urlVieja = historialBrowser.pop();",
                    "El método .pop() extrajo y destruyó sin compasión el tope: ["+popped+"].\nEl historial retrocede automáticamente permitiendo que la URL inferior vuelva a ser visible.");
                JOptionPane.showMessageDialog(frame, "Cerraste la pestaña actual.\nAtrás dejaste: " + popped, "Atrás (Pop)", JOptionPane.WARNING_MESSAGE);
            } else {
                highlightCode(-1, "", "La Pila (Stack) está vacía, Pop() lanzaría una Excepción natural EmptyStackException si no lo validáramos.");
            }
        });
        pnlStack.add(btnGo); pnlStack.add(btnBack); pnlStack.add(lblStack);
        
        // 2. Cola FIFO (Descargas)
        JPanel pnlQueue = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pnlQueue.setBackground(Color.WHITE);
        pnlQueue.setBorder(BorderFactory.createTitledBorder("Cola FIFO - Gestor de Descargas del Navegador"));
        Queue<String> colaDescargas = new LinkedList<>();
        JButton btnOffer = new JButton("📥 Iniciar Descarga (Offer)");
        JButton btnPoll = new JButton("✅ Terminar Descarga (Poll)");
        JLabel lblQueue = new JLabel("Fila Descargas: []");
        lblQueue.setForeground(new Color(20, 150, 50));
        
        btnOffer.addActionListener(e -> { 
            String archivo = "Paquete_" + (colaDescargas.size() + 1) + ".zip";
            colaDescargas.offer(archivo); 
            lblQueue.setText("Fila Descargas: " + colaDescargas.toString()); 
            highlightCode(2, "colaDescargas.offer(archivo);",
                "El método .offer() encola el ["+archivo+"] al FINAL exacto de la fila FIFO.\nEsta estructura emula la vida real, nadie se salta el turno.");
        });
        
        btnPoll.addActionListener(e -> { 
            if(!colaDescargas.isEmpty()) {
                String desc = colaDescargas.poll(); 
                lblQueue.setText("Fila Descargas: " + colaDescargas.toString()); 
                highlightCode(3, "String completado = colaDescargas.poll();",
                    "El método .poll() excomulgó pacíficamente al componente anclado al FRENTE de la fila.\nEn este caso de éxito, el ["+desc+"] finalizó al 100% y dejó la fila.");
            } else {
                highlightCode(-1, "", "La Cola (Queue) está vacía. No operó poll().");
            }
        });
        pnlQueue.add(btnOffer); pnlQueue.add(btnPoll); pnlQueue.add(lblQueue);
        
        // 3. Cola Prioridad PQ (Procesador OS)
        JPanel pnlPQ = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pnlPQ.setBackground(Color.WHITE);
        pnlPQ.setBorder(BorderFactory.createTitledBorder("PriorityQueue - Scheduler Sistema Operativo"));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        JTextField txtNum = new JTextField("1", 4);
        JButton btnAddPQ = new JButton("Lanzar Proceso (PID)");
        JButton btnPollPQ = new JButton("Asignar CPU (Poll)");
        JLabel lblPQ = new JLabel("Tracker: []");
        
        btnAddPQ.addActionListener(e -> { 
            try {
                int urgencia = Integer.parseInt(txtNum.getText());
                pq.offer(urgencia);
                lblPQ.setText("Tracker: " + pq.toString()); 
                highlightCode(4, "pq.offer(urgencia);", "El Offer en una Cola de Prioridad inyectará el número. Si es muy bajo (Ej 1), reorganizará la estructura atómica y mágicamente saltará toda la fila.");
            } catch(Exception ex) {}
        });
        btnPollPQ.addActionListener(e -> { 
            if(!pq.isEmpty()) {
                pq.poll(); lblPQ.setText("Tracker: " + pq.toString()); 
                highlightCode(5, "int pAtendido = pq.poll();", "El Poll del PriorityQueue evaluó internamente todo su árbol binario y en tiempo Log(N) le dio CPU al proceso de menor constancia matemática (El de extrema prioridad) rompiendo la regla FIFO horizontal.");
            }
        });
        pnlPQ.add(new JLabel("Prioridad (Mín es Urgente):")); pnlPQ.add(txtNum); pnlPQ.add(btnAddPQ); pnlPQ.add(btnPollPQ); pnlPQ.add(lblPQ);

        leftPanel.add(pnlStack);
        leftPanel.add(pnlQueue);
        leftPanel.add(pnlPQ);
        
        // --- PANEL DERECHO: Analizador / Interfaz IDE Visual ---
        JPanel rightPanel = new JPanel(new BorderLayout());
        
        // Panel de Explicación superior
        JPanel pnlExplanation = new JPanel(new BorderLayout());
        pnlExplanation.setBackground(new Color(255, 250, 210));
        pnlExplanation.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        lblExplanation = new JLabel("<html><b>📝 Intérprete de Ejecución O(1):</b><br/>Esperando interacción... Haz clic en un botón a tu izquierda para interceptar la línea de código exacta que se detonó tras de cámaras.</html>");
        lblExplanation.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        pnlExplanation.add(lblExplanation, BorderLayout.CENTER);
        
        // Area de código
        codeViewer = new JTextPane();
        codeViewer.setFont(new Font("Consolas", Font.BOLD, 15));
        codeViewer.setEditable(false);
        codeViewer.setBackground(new Color(30, 32, 40));
        codeViewer.setForeground(new Color(230, 230, 240));
        codeViewer.setText(
            "// ----- INSTANCIACIÓN DE ESTRUCTURAS EN MEMORIA ----- //\n\n" +
            "// 1. Instanciación Navegador Pila LIFO\n" +
            "Stack<String> historialBrowser = new Stack<>();\n\n" +
            "// 2. FUNCIÓN GO (Navegar)\n" +
            "historialBrowser.push(url);\n\n" +
            "// 3. FUNCIÓN BACK (Atrás)\n" +
            "String urlVieja = historialBrowser.pop();\n\n" +
            "// --------------------------------------------------- //\n\n" +
            "// 4. Instanciación Descargas Cola FIFO\n" +
            "Queue<String> colaDescargas = new LinkedList<>();\n\n" +
            "// 5. FUNCIÓN INICIAR DESCARGA (Agrega a la cola)\n" +
            "colaDescargas.offer(archivo);\n\n" +
            "// 6. FUNCIÓN COMPLETAR (Quita de la cola)\n" +
            "String completado = colaDescargas.poll();\n\n" +
            "// --------------------------------------------------- //\n\n" +
            "// 7. Instanciación Arbol de Procesador de Sistema PQ\n" +
            "PriorityQueue<Integer> pq = new PriorityQueue<>();\n\n" +
            "// 8. FUNCIÓN INYECTAR PROCESO AL KERNEL\n" +
            "pq.offer(urgencia);\n\n" +
            "// 9. REPARTIR RENDIMIENTO\n" +
            "int pAtendido = pq.poll();\n"
        );
        highlighter = codeViewer.getHighlighter();
        
        rightPanel.add(pnlExplanation, BorderLayout.NORTH);
        rightPanel.add(new JScrollPane(codeViewer), BorderLayout.CENTER);
        
        splitPane.setLeftComponent(leftPanel);
        splitPane.setRightComponent(rightPanel);
        
        frame.add(splitPane);
        frame.setVisible(true);
    }
    
    // Motor para Resaltar Líneas amarillas como un IDE Debugger
    private void highlightCode(int actionIndex, String targetObj, String detailedEx) {
        lblExplanation.setText("<html><b>Ejecución Interceptada:</b><br/>" + detailedEx.replace("\n", "<br/>") + "</html>");
        
        if (currentHighlight != null) {
            highlighter.removeHighlight(currentHighlight);
            currentHighlight = null;
        }
        
        try {
            String fullCode = codeViewer.getText();
            if(!targetObj.isEmpty()) {
                int startPosition = fullCode.indexOf(targetObj);
                if(startPosition >= 0) {
                    Highlighter.HighlightPainter yellowPainter = new javax.swing.text.DefaultHighlighter.DefaultHighlightPainter(new Color(200, 180, 0, 100)); // Amarillo Transparente
                    currentHighlight = highlighter.addHighlight(startPosition, startPosition + targetObj.length(), yellowPainter);
                }
            }
        } catch(Exception ignored) {}
    }
}
