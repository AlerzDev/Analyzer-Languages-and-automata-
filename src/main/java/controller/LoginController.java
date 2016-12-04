package controller;

import base.BaseFrameInterface;
import crud.Find;
import manager.NavigationManager;
import model.User;
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
    private Find       find;

    LoginController(Login l) {

        this.mLogin = l;
        initView();

    }

    public void initView() {

        user = mLogin.getUserField();
        password = mLogin.getPasswordField();
        JButton login = mLogin.getLoginBtn();
        JButton register = mLogin.getRegisterBtn();

        login.addActionListener(new ListenerLoginButton());
        register.addActionListener(new ListenerRegisterButton());

        find = new Find();
    }

    public void success(String title, String msg) {
        ViewUtils.getInstance().showSuccessMessage(title,msg,mLogin);
    }

    public void error(String title, String msg) {
        ViewUtils.getInstance().showErrorMessage(title,msg,mLogin);
    }

    private class ListenerLoginButton implements ActionListener{

        public void actionPerformed(ActionEvent actionEvent) {
            User u = new User();
            u.setUsername(user.getText());
            u.setPassword(password.getText());
            if(find.findUserLogin(u)){
                success("Exito","Ingreso exitoso");
                NavigationManager.getInstance().loadAnalyzerFrame();

            }else {
                error("Error", "Existe u problema en los datos ingresados");
            }
        }
    }

    class ListenerRegisterButton implements  ActionListener{

        public void actionPerformed(ActionEvent actionEvent) {
            NavigationManager.getInstance().loadRegisterFrame();
        }

    }

}
