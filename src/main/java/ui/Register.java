package ui;

import base.BaseFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lemuz on 3/12/16.
 */
public class Register extends BaseFrame {

    private JLabel[]      labels;
    private JTextField[]  fields;
    private JButton       register;
    private JButton       cancel;

    protected void initView() {
        this.add(panelPrincipal());
    }

    private JPanel panelPrincipal(){

        JPanel panel = new JPanel( new GridLayout(7,2,2,25));

        String text[] = new String[]{"Nombre Usuario", "Contraseña",
                                     "Nombre Completo", "Telefono",
                                     "Correo electronico","Dirección"};

        labels = new JLabel[text.length];
        fields = new JTextField[text.length];

        for (int i = 0; i<text.length;i++){
            labels[i] = new JLabel(text[i]);
            fields[i] = new JTextField(10);
            panel.add(labels[i]);
            panel.add(fields[i]);
        }

        register = new JButton("Aceptar");
        cancel   = new JButton("Cancelar");
        panel.add(cancel);
        panel.add(register);

        return panel;
    }

    protected String titleWindow() {
        return "Registro";
    }

    protected int widthWindow() {
        return 300;
    }

    protected int heightWindow() {
        return 400;
    }

    protected boolean exitOnClose() {
        return false;
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

    public JButton getRegister() {
        return register;
    }

    public JButton getCancel() {
        return cancel;
    }
}
