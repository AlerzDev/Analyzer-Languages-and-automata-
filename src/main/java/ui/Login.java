package ui;

import base.BaseFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lemuz on 3/12/16.
 */
public class Login extends BaseFrame {

    private JLabel         title;
    private JLabel         user;
    private JLabel         password;
    private JTextField     userField;
    private JPasswordField passwordField;
    private JButton        loginBtn;
    private JButton        registerBtn;



    protected void initView() {
        panelPrincipal();
        this.add(panelPrincipal());
    }

    private JPanel panelPrincipal(){

        JPanel panel  = new JPanel(new FlowLayout());

        title         = new JLabel("Login Analyzer");
        user          = new JLabel("Nombre de usuario");
        userField     = new JTextField(20);
        password      = new JLabel("Contraseña");
        passwordField = new JPasswordField(20);
        loginBtn      = new JButton("Ingresar");
        registerBtn   = new JButton("Registrar");

        panel.add(title);
        panel.add(user);
        panel.add(userField);
        panel.add(password);
        panel.add(passwordField);
        panel.add(loginBtn);
        panel.add(registerBtn);

        return panel;

    }

    protected String titleWindow() {
        return "Login";
    }

    protected int widthWindow() {
        return 250;
    }

    protected int heightWindow() {
        return 250;
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

    public JTextField getUserField() {
        return userField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JButton getLoginBtn() {
        return loginBtn;
    }

    public JButton getRegisterBtn() {
        return registerBtn;
    }
}
