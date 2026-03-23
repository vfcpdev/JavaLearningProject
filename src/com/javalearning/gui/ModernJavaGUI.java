package com.javalearning.gui;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class ModernJavaGUI {
    // Definición global del Record inmutable
    public record ServerNode(String ip, int port, String status) {}
    
    public ModernJavaGUI() {
        JFrame frame = new JFrame("Características de Modern Java (dev.java/learn)");
        frame.setSize(680, 520);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JTextArea info = new JTextArea(
            "   [NUEVOS MÓDULOS DE VANGUARDIA (Inspirados en dev.java/learn)]\n\n" +
            "1. Records (Java 14+): Constructores compactos de transporte de datos\n" +
            "   inmutables que evitan escribir Getters/Setters y funciones toString.\n" +
            "2. Pattern Matching: Evaluación tipada (obj instanceof Record x) protegiendo\n" +
            "   la asignación virtual instantánea.\n" +
            "3. Stream API: Iteradores asíncronos en tubería que filtran e invocan\n" +
            "   expresiones Lambda a enorme velocidad sobre Listas de datos."
        );
        info.setEditable(false);
        info.setFont(new Font("Monospaced", Font.PLAIN, 13));
        
        JPanel interact = new JPanel(new GridLayout(2, 1, 10, 10));
        interact.setBorder(BorderFactory.createTitledBorder("Crea Instancias y somételas a Pattern Matching/Streams"));
        
        JPanel inputs = new JPanel(new FlowLayout());
        JTextField txtIp = new JTextField("extranet.db.app", 15);
        JTextField txtPort = new JTextField("3306", 5);
        JButton btnCrear = new JButton("Instanciar Record");
        JButton btnStream = new JButton("Filtrar (The Stream API)");
        
        inputs.add(new JLabel("Dirección IPv4/Dominio: ")); inputs.add(txtIp);
        inputs.add(new JLabel("Apertura de Puerto: ")); inputs.add(txtPort);
        inputs.add(btnCrear); inputs.add(btnStream);
        
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> list = new JList<>(listModel);
        list.setFont(new Font("Consolas", Font.BOLD, 12));
        listModel.addElement("Servidor Record => IP: 192.168.1.1 | Puerto: 22 [ESTADO: OFFLINE]");
        listModel.addElement("Servidor Record => IP: 10.5.5.5 | Puerto: 443 [ESTADO: ACTIVE]");
        
        btnCrear.addActionListener(e -> {
            try {
                // FEATURE 1: Construcción limpia de Record
                ServerNode node = new ServerNode(txtIp.getText(), Integer.parseInt(txtPort.getText()), "ACTIVE");
                
                // FEATURE 2: Uso de Pattern Matching real inyectado (Soporte JDK 16+)
                Object ob = node;
                if(ob instanceof ServerNode n){
                    listModel.addElement("Servidor Record => IP: " + n.ip() + " | Puerto: " + n.port() + " [ESTADO: " + n.status() + "]");
                }
            } catch(Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: Ingrese un puerto válido.", "Falla", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        btnStream.addActionListener(e -> {
            List<String> clusterMemoria = new ArrayList<>();
            for(int i = 0; i < listModel.size(); i++){
                clusterMemoria.add(listModel.get(i));
            }
            
            listModel.clear();
            listModel.addElement(" --- PROCESAMIENTO STREAM API COMPLETADO (Descartados OFFLINE) ---");
            
            // FEATURE 3: Stream pipelines con Expresiones Lambda para filtrar
            clusterMemoria.stream()
                          .filter(str -> str.contains("ACTIVE"))
                          .forEach(str -> listModel.addElement(" >>> " + str));
        });
        
        interact.add(inputs);
        
        panel.add(new JScrollPane(info), BorderLayout.NORTH);
        panel.add(interact, BorderLayout.CENTER);
        panel.add(new JScrollPane(list), BorderLayout.SOUTH);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
