package controller;

import base.BaseFrameInterface;
import ui.Register;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lemuz on 3/12/16.
 */
public class RegisterController implements BaseFrameInterface {

    private Register mRegister;
    private JTextField[] fields;
    private JButton      registerBtn;
    private JButton      cancelBtn;

    public RegisterController(Register register){
        this.mRegister = register;
        initView();
    }

    public void initView() {

        fields      = mRegister.getFields();
        registerBtn = mRegister.getRegister();
        cancelBtn   = mRegister.getCancel();
        registerBtn.addActionListener(new ListenerRegisterButton());
        cancelBtn.addActionListener(new ListenerCancelButton());

    }

    public void success(String title, String msg) {

    }

    public void error(String title, String msg) {

    }

    private class ListenerCancelButton implements ActionListener{

        public void actionPerformed(ActionEvent actionEvent) {
            mRegister.dispose();
        }

    }

    private class ListenerRegisterButton implements ActionListener{

        public void actionPerformed(ActionEvent actionEvent) {

        }

    }

}
