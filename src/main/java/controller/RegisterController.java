package controller;

import base.BaseFrameInterface;
import crud.Insert;
import model.User;
import ui.Register;
import utils.RegularExpression;
import utils.ViewUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lemuz on 3/12/16.
 */

public class RegisterController implements BaseFrameInterface {

    private Register mRegister;
    private JTextField[] fields;
    private RegularExpression regularExpression;
    private Insert insert;


    public RegisterController(Register register){

        this.mRegister = register;
        regularExpression = new RegularExpression();
        insert = new Insert();
        initView();
    }

    public void initView() {

        fields      = mRegister.getFields();
        JButton registerBtn = mRegister.getRegister();
        JButton cancelBtn = mRegister.getCancel();
        registerBtn.addActionListener(new ListenerRegisterButton());
        cancelBtn.addActionListener(new ListenerCancelButton());

    }

    public void success(String title, String msg) {
        ViewUtils.getInstance().showSuccessMessage(title,msg,mRegister);
    }

    public void error(String title, String msg) {
        ViewUtils.getInstance().showErrorMessage(title,msg,mRegister);
    }

    private class ListenerCancelButton implements ActionListener{

        public void actionPerformed(ActionEvent actionEvent) {
            mRegister.dispose();
        }

    }

    private class ListenerRegisterButton implements ActionListener{

        public void actionPerformed(ActionEvent actionEvent) {

            if (validationFields()){

                User u = new User();
                u.setUsername(fields[0].getText());
                u.setPassword(fields[0].getText());
                u.setFullName(fields[0].getText());
                u.setTel(fields[0].getText());
                u.setEmail(fields[0].getText());
                u.setAddress(fields[0].getText());
                insert.insertUser(u);
                success("Exito","Registro hecho satisfactoriamente");
                mRegister.dispose();
            }

        }

        private boolean validationFields(){

            String text[] = new String[]{"Error en el nombre usuario", "Error en el campo de contraseña",
                    "Error en el campo de nombre completo", "Error en el campo de telefono",
                    "Error en el campo de correo electronico","Error en el campo de dirección"};
            boolean success = true;

            for (int i = 0; i < text.length; i++) {
                switch (i){
                    case 0: if(fields[i].getText().equals("")){ success("Error",text[i]); success = false;}
                        break;
                    case 1: if(fields[i].getText().equals("")){ success("Error",text[i]); success = false;}
                        break;
                    case 2: if (!regularExpression.expression_FullName(fields[i].getText())){ success("Error",text[i]); success = false;}
                        break;
                    case 3: if (!regularExpression.expression_phone(fields[i].getText())){ success("Error",text[i]); success = false;}
                        break;
                    case 4: if (!regularExpression.expression_email(fields[i].getText())){ success("Error",text[i]); success = false;}
                        break;
                    case 5: if (!regularExpression.expression_address(fields[i].getText())){ success("Error",text[i]); success = false;}
                    break;
                }
                if(!success){
                    break;
                }
            }

            return success;
        }

    }

}
