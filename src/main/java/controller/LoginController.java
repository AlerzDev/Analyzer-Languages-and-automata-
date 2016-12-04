package controller;

import base.BaseFrameInterface;
import manager.NavigationManager;
import ui.Login;
import utils.ViewUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lemuz on 3/12/16.
 */



public class LoginController implements BaseFrameInterface {

    private Login      mLogin;
    private JTextField user;
    private JPasswordField password;
    private JButton    login;
    private JButton    register;

    LoginController(Login l) {

        this.mLogin = l;
        initView();

    }

    public void initView() {

        user = mLogin.getUserField();
        password = mLogin.getPasswordField();
        login    = mLogin.getLoginBtn();
        register = mLogin.getRegisterBtn();

        login.addActionListener(new ListenerLoginButton());
        register.addActionListener(new ListenerRegisterButton());

    }

    public void success(String title, String msg) {
        ViewUtils.getInstance().showSuccessMessage(title,msg,mLogin);
    }

    public void error(String title, String msg) {
        ViewUtils.getInstance().showErrorMessage(title,msg,mLogin);
    }

    private class ListenerLoginButton implements ActionListener{

        public void actionPerformed(ActionEvent actionEvent) {
            success("Exito","Ingreso Exitoso");
        }
    }

    class ListenerRegisterButton implements  ActionListener{

        public void actionPerformed(ActionEvent actionEvent) {
            NavigationManager.getInstance().loadRegisterFrame();
        }
    }
}
