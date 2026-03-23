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
            "2. Pilas (Stack - LIFO): Sistema historial de comandos terminal bash.\n" +
            "3. Colas (Queue - FIFO): Spooler de impresión de red corporativa.\n" +
            "4. Colas de Prioridad (PriorityQueue): Scheduler del sistema que\n" +
            "   atiende procesos críticos del Kernel antes que procesos simples."
        );
        info.setEditable(false);
        info.setFont(new Font("Monospaced", Font.PLAIN, 13));
        
        JPanel pnlInteract = new JPanel(new GridLayout(3, 1, 10, 10));
        
        // --- PILA LIFO ---
        JPanel pnlStack = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlStack.setBorder(BorderFactory.createTitledBorder("2. Pila LIFO (Historial Terminal Ctrl+Z)"));
        Stack<String> bash = new Stack<>();
        JButton btnPush = new JButton("Ingresar Comando (Push)");
        JButton btnPop = new JButton("Deshacer (Pop)");
        JLabel lblStack = new JLabel("Historial: []");
        lblStack.setForeground(Color.BLUE);
        btnPush.addActionListener(e -> { 
            bash.push("Cmd_" + (bash.size() + 1)); 
            lblStack.setText("Historial: " + bash.toString()); 
        });
        btnPop.addActionListener(e -> { 
            if(!bash.isEmpty()) bash.pop(); 
            lblStack.setText("Historial: " + bash.toString()); 
        });
        pnlStack.add(btnPush); pnlStack.add(btnPop); pnlStack.add(lblStack);
        
        // --- COLA FIFO ---
        JPanel pnlQueue = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlQueue.setBorder(BorderFactory.createTitledBorder("3. Cola FIFO (Spooler Impresión en Red)"));
        Queue<String> cola = new LinkedList<>();
        JButton btnOffer = new JButton("Enviar Documento (Offer)");
        JButton btnPoll = new JButton("Imprimir Top (Poll)");
        JLabel lblQueue = new JLabel("Spooler: []");
        lblQueue.setForeground(new Color(0, 128, 0));
        btnOffer.addActionListener(e -> { 
            cola.offer("PDF_" + (cola.size() + 1)); 
            lblQueue.setText("Spooler: " + cola.toString()); 
        });
        btnPoll.addActionListener(e -> { 
            if(!cola.isEmpty()) cola.poll(); 
            lblQueue.setText("Spooler: " + cola.toString()); 
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
