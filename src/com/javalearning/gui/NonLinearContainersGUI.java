package com.javalearning.gui;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

public class NonLinearContainersGUI {
    public NonLinearContainersGUI() {
        JFrame frame = new JFrame("Estructuras No Lineales (Contexto Networking Densa)");
        frame.setSize(680, 500);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JTextArea info = new JTextArea(
            "   [ESTRUCTURA DE DATOS MATEMÁTICOS DE BAJO NIVEL]\n\n" +
            "1. Conjuntos (Sets): Filtran y rechazan repetidos de forma nativa\n" +
            "   debido a validaciones de Hashing, ideal para colecciones únicas (Ej. Blacklists).\n" +
            "2. Mapas (Maps - Diccionarios): Relacionan una y solo una LLAVE [Key]\n" +
            "   con un RESULTADO [Value], permitiendo búsquedas fulminantes sin buclar todo\n" +
            "   Ejemplo Real: Rúters asociando URLs hacia servidores físicos."
        );
        info.setEditable(false);
        info.setFont(new Font("Monospaced", Font.PLAIN, 13));
        
        JPanel pnlInteract = new JPanel(new GridLayout(2, 1, 10, 10));
        
        // --- SET LOGIC ---
        JPanel pnlSet = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlSet.setBorder(BorderFactory.createTitledBorder("Conjunto Matemático Set (Blacklist Red Firewall)"));
        Set<String> blockedIps = new HashSet<>();
        JTextField txtIp = new JTextField("192.168.1.10", 12);
        JButton btnAddSet = new JButton("Bloquear Única (Add)");
        JLabel lblSet = new JLabel("Lista Hashing Array: []");
        lblSet.setForeground(new Color(200, 40, 40));
        btnAddSet.addActionListener(e -> { 
            String ip = txtIp.getText().trim();
            if(!ip.isEmpty()){
                boolean hasBeenAdded = blockedIps.add(ip);
                if(hasBeenAdded) {
                    lblSet.setText("Lista Hashing Array: " + blockedIps.toString());
                } else {
                    JOptionPane.showMessageDialog(frame, "¡Violación de Set! La IP ya estaba registrada.\nEl contenedor evadió registrarla dos veces (Hash idéntico).", "Firewall Inteligente", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        pnlSet.add(new JLabel("IP a Bloquear:")); pnlSet.add(txtIp); pnlSet.add(btnAddSet); pnlSet.add(lblSet);
        
        // --- MAP LOGIC ---
        JPanel pnlMap = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlMap.setBorder(BorderFactory.createTitledBorder("HashMap de Tabla Asociativa (Servidor DNS - [Dominio -> IP])"));
        Map<String, String> dns = new HashMap<>();
        JTextField txtDomain = new JTextField("extranet.com", 12);
        JTextField txtIPValue = new JTextField("10.5.5.5", 10);
        JButton btnAddMap = new JButton("Guardar Dominio (Put)");
        JButton btnGetMap = new JButton("Consultar DNS Local (Get)");
        JLabel lblMap = new JLabel("Arbol DNS: {}");
        lblMap.setForeground(new Color(20, 100, 180));
        btnAddMap.addActionListener(e -> { 
            if(!txtDomain.getText().isEmpty() && !txtIPValue.getText().isEmpty()){
                dns.put(txtDomain.getText().trim(), txtIPValue.getText().trim());
                lblMap.setText("Árbol DNS: " + dns.toString()); 
            }
        });
        btnGetMap.addActionListener(e -> { 
            String query = JOptionPane.showInputDialog(frame, "Escriba un Dominio Web exacto alojado, Ej: extranet.com:");
            if(query != null && !query.isEmpty()){
                if(dns.containsKey(query)){
                    JOptionPane.showMessageDialog(frame, "DNS Encontrado.\nLlave: '" + query + "' -> Puntero/IP de Valor: " + dns.get(query), "Resultado en RAM", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "NXDOMAIN (Dominio No Encontrado en tabla de Enrutamiento).", "Error JVM", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        pnlMap.add(new JLabel("A (Dominio):")); pnlMap.add(txtDomain);
        pnlMap.add(new JLabel("Pointer (IP):")); pnlMap.add(txtIPValue);
        pnlMap.add(btnAddMap); pnlMap.add(btnGetMap); pnlMap.add(lblMap);
        
        pnlInteract.add(pnlSet);
        pnlInteract.add(pnlMap);
        
        panel.add(new JScrollPane(info), BorderLayout.NORTH);
        panel.add(pnlInteract, BorderLayout.CENTER);
        
        frame.add(panel);
        frame.setVisible(true);
    }
}
