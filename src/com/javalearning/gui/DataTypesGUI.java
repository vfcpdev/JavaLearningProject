package com.javalearning.gui;

import javax.swing.*;
import java.awt.*;

public class DataTypesGUI {
    public DataTypesGUI() {
        JFrame frame = new JFrame("Tipos de Datos en Java");
        frame.setSize(450, 350);
        frame.setLocationRelativeTo(null);
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textArea.setMargin(new Insets(15, 15, 15, 15));
        
        String info = "Tipos Primitivos en Java:\n"
                + "- byte (8 bits)\n"
                + "- short (16 bits)\n"
                + "- int (32 bits, valores enteros comunes)\n"
                + "- long (64 bits)\n"
                + "- float (32 bits, decimal)\n"
                + "- double (64 bits, decimal doble precisión)\n"
                + "- boolean (true / false)\n"
                + "- char ('A', representa un carácter)\n\n"
                + "Tipos de Referencia u Objetos:\n"
                + "- String (\"Hola\", secuencia de caracteres)\n"
                + "- Clases creadas por el usuario\n"
                + "- Arreglos y Colecciones";
                
        textArea.setText(info);
        
        frame.add(new JScrollPane(textArea));
        frame.setVisible(true);
    }
}
