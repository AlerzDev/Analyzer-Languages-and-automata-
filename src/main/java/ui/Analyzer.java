package ui;

import base.BaseFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lemuz on 4/12/16.
 */

public class Analyzer extends BaseFrame {
    private JTextField[] fields;
    private JLabel[]     labels;
    private String[]     text;
    private JButton      clean;
    private JButton      check;
    private JTextArea    results;
    protected void initView() {
        this.setLayout(new GridLayout(2,1));
        this.add(panelFields());
        this.add(panelResults());
    }

    private JPanel panelFields(){

        JPanel panel = new JPanel(new GridLayout(8,2));
        text = new  String[]{"Nombre","Direccion","Correo","Celular","Curp","Nacimiento","Carrera"};

        labels = new JLabel[text.length];
        fields = new JTextField[text.length];

        for (int i = 0; i < text.length; i++) {
            labels[i] = new JLabel(text[i]);
            fields[i] = new JTextField(15);
            panel.add(labels[i]);
            panel.add(fields[i]);
        }

        clean = new JButton("Limpiar Campos");
        check = new JButton("Validar campos");
        panel.add(clean);
        panel.add(check);

        return panel;
    }

    private JPanel panelResults(){
        JPanel panel = new JPanel(new BorderLayout());
        results = new JTextArea();
        results.setBackground(Color.BLACK);
        results.setForeground(Color.green);
        panel.add(results);
        return panel;
    }

    protected String titleWindow() {
        return "Analyzer Automatas 2";
    }

    protected int widthWindow() {
        return 1000;
    }

    protected int heightWindow() {
        return 500;
    }

    protected boolean exitOnClose() {
        return true;
    }

    protected boolean resizable() {
        return false;
    }

    protected boolean centerLocation() {
        return true;
    }

    public JTextField[] getFields() {
        return fields;
    }

    public JButton getClean() {
        return clean;
    }

    public JButton getCheck() {
        return check;
    }

    public JTextArea getResults() {
        return results;
    }
}
