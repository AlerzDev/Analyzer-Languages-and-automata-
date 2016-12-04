package controller;

import ui.Login;

import java.util.Locale;

/**
 * Created by lemuz on 3/12/16.
 */
public class Main {

    public static void main(String[] args) {
        Login g = new Login();
        LoginController gc = new LoginController(g);
    }

}
