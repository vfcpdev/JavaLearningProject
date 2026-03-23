package com.javalearning.gui;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;

public class StandardContainersGUI {
    public StandardContainersGUI() {
        JFrame frame = new JFrame("Contenedores Estándar (Contexto de Infraestructura OS)");
        frame.setSize(680, 620);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JTextArea info = new JTextArea(
            "   [ARQUITECTURA DE CONTENEDORES - CASOS PRÁCTICOS]\n\n" +
            "1. Listas (ArrayList): Nodos dinámicos en un cluster de balanceo.\n" +
            "2. Pilas (Stack - LIFO): Simulación del Navegador Web (Botón Atrás) usando\n" +
            "   el apilamiento secuencial interactivo de Modales.\n" +
            "3. Colas (Queue - FIFO): Gestor de Descargas del Navegador Web.\n" +
            "4. Colas de Prioridad (PriorityQueue): Scheduler del sistema base OS."
        );
        info.setEditable(false);
        info.setFont(new Font("Monospaced", Font.PLAIN, 13));
        
        JPanel pnlInteract = new JPanel(new GridLayout(3, 1, 10, 10));
        
        // --- PILA LIFO (Historial del Navegador con Modales) ---
        JPanel pnlStack = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlStack.setBorder(BorderFactory.createTitledBorder("2. Pila LIFO (Modales) - Navegador Web: Botón Atrás/Adelante"));
        Stack<String> historialBrowser = new Stack<>();
        JButton btnGo = new JButton("🌐 Visitar URL (Push)");
        JButton btnBack = new JButton("🔙 Página Anterior (Pop)");
        JLabel lblStack = new JLabel("Historial de Navegación: []");
        lblStack.setForeground(Color.BLUE);
        
        btnGo.addActionListener(e -> { 
            // Inyección de Pila exigida interactuando con Ventana Modal
            String url = JOptionPane.showInputDialog(pnlStack, "Escribe la Dirección Web a navegar\n(Sugerencia: Dirección 1, Dirección 2...):", "Navegador Web - Navegar URL", JOptionPane.QUESTION_MESSAGE);
            if (url != null && !url.trim().isEmpty()) {
                historialBrowser.push(url); 
                lblStack.setText("Historial Pila(LIFO): " + historialBrowser.toString()); 
                JOptionPane.showMessageDialog(pnlStack, "Se cargó la pestaña web: " + url + "\nY se ha apilado sobre todos los demás elementos en Memoria RAM.", "Push Exitoso LIFO", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        btnBack.addActionListener(e -> { 
            if(!historialBrowser.isEmpty()) {
                String popped = historialBrowser.pop(); 
                lblStack.setText("Historial Pila(LIFO): " + historialBrowser.toString()); 
                String current = historialBrowser.isEmpty() ? "Página de Inicio Vacía" : historialBrowser.peek();
                JOptionPane.showMessageDialog(pnlStack, "Hiciste clic en retroceder.\n1. Cerrando y retirando: '" + popped + "'.\n2. Actualmente de espaldas estás viendo la solapa inmediata: " + current, "Pop Ejecutado (Reversión Atrás)", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(pnlStack, "Error 404: Historial limpio o vacío. No puedes ir más Atrás.", "Error LIFO", JOptionPane.ERROR_MESSAGE);
            }
        });
        pnlStack.add(btnGo); pnlStack.add(btnBack); pnlStack.add(lblStack);
        
        // --- COLA FIFO (Descargas del Navegador Web) ---
        JPanel pnlQueue = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlQueue.setBorder(BorderFactory.createTitledBorder("3. Cola FIFO - Simulador: Gestor de Descargas de Navegador Web"));
        Queue<String> managerDescargas = new LinkedList<>();
        JButton btnOffer = new JButton("📥 Iniciar Descarga (Offer)");
        JButton btnPoll = new JButton("✅ Completar Primero (Poll)");
        JLabel lblQueue = new JLabel("Cola de Descargas: []");
        lblQueue.setForeground(new Color(0, 128, 0));
        
        btnOffer.addActionListener(e -> { 
            String archivo = "Archivo_Descargado_Part_" + (managerDescargas.size() + 1) + ".rar";
            managerDescargas.offer(archivo); 
            lblQueue.setText("Cola Descargas FIFO: " + managerDescargas.toString()); 
        });
        
        btnPoll.addActionListener(e -> { 
            if(!managerDescargas.isEmpty()) {
                String desc = managerDescargas.poll(); 
                lblQueue.setText("Cola Descargas FIFO: " + managerDescargas.toString()); 
                JOptionPane.showMessageDialog(pnlQueue, "Atendiendo al primero que llegó en la fila de descargas...\n¡Se completó el 100% de: " + desc + "!", "Descarga FIFO finalizada", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(pnlQueue, "No hay archivos encolados esperando finalización.", "Información", JOptionPane.WARNING_MESSAGE);
            }
        });
        pnlQueue.add(btnOffer); pnlQueue.add(btnPoll); pnlQueue.add(lblQueue);
        
        // --- COLA PRIORIDAD ---
        JPanel pnlPQ = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlPQ.setBorder(BorderFactory.createTitledBorder("4. PriorityQueue (Scheduler - El proceso Menor es más urgente)"));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        JTextField txtNum = new JTextField("1", 5);
        JButton btnAddPQ = new JButton("Lanzar PID (Offer)");
        JButton btnPollPQ = new JButton("Dar CPU Mínimo (Poll)");
        JLabel lblPQ = new JLabel("Scheduler: []");
        lblPQ.setForeground(Color.RED);
        btnAddPQ.addActionListener(e -> { 
            try {
                pq.offer(Integer.parseInt(txtNum.getText()));
                lblPQ.setText("Scheduler: " + pq.toString()); 
            } catch(Exception ex) {}
        });
        btnPollPQ.addActionListener(e -> { 
            if(!pq.isEmpty()) pq.poll(); 
            lblPQ.setText("Scheduler: " + pq.toString()); 
        });
        pnlPQ.add(new JLabel("Prioridad (Int):")); pnlPQ.add(txtNum); pnlPQ.add(btnAddPQ); pnlPQ.add(btnPollPQ); pnlPQ.add(lblPQ);
        
        pnlInteract.add(pnlStack);
        pnlInteract.add(pnlQueue);
        pnlInteract.add(pnlPQ);
        
        panel.add(new JScrollPane(info), BorderLayout.NORTH);
        panel.add(pnlInteract, BorderLayout.CENTER);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
