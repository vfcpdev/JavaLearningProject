package com.javalearning.gui;

import javax.swing.*;
import java.awt.*;

public class AlgorithmicStructuresGUI {
    public AlgorithmicStructuresGUI() {
        JFrame frame = new JFrame("Estructuras Algorítmicas (Enfoque Ing. Sistemas)");
        frame.setSize(550, 480);
        frame.setLocationRelativeTo(null);
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textArea.setMargin(new Insets(15, 15, 15, 15));
        
        String info = "1. ASIGNACIÓN (Configuración de Red y Despliegue):\n"
                + "  String serverName = \"PROD-DB-01\";\n"
                + "  int maxConnections = 1500;\n"
                + "  boolean isEncrypted = true;\n\n"
                
                + "2. CONDICIÓN (Arquitectura y Balanceo de Carga):\n"
                + "  if (activeConnections > 1200) {\n"
                + "      startNewInstance(); // Despliegue elástico automatizado\n"
                + "  } else if (activeConnections < 200) {\n"
                + "      scaleDown(); // Ahorro de recursos en la nube\n"
                + "  } else {\n"
                + "      maintainState(); // Operación normal\n"
                + "  }\n\n"
                
                + "3. REPETICIÓN (Escaneo de Archivos de Logs en busca de Errores):\n"
                + "  for (String logLine : serverLogFiles) {\n"
                + "      if (logLine.contains(\"FATAL EXCEPTION\")) {\n"
                + "          triggerAlertToSysadmin(logLine);\n"
                + "      }\n"
                + "  }\n\n"
                + "  // Mecanismo de resiliencia (Reintentos de conexión a API externa):\n"
                + "  int retry = 0;\n"
                + "  while (!isConnected && retry < 5) {\n"
                + "      connectToMicroserviceApi();\n"
                + "      retry++;\n"
                + "  }";
                
        textArea.setText(info);
        
        frame.add(new JScrollPane(textArea));
        frame.setVisible(true);
    }
}
