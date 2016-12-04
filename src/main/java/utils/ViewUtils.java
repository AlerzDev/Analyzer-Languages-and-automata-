package utils;

import javax.swing.*;

/**
 * Created by lemuz on 3/12/16.
 */
public class ViewUtils {

    private static ViewUtils instance;

    public static ViewUtils getInstance() {

        if (instance == null)
            instance = new ViewUtils();

        return instance;
    }

    public void showErrorMessage(final String title, final String msg, JFrame frame){

        JOptionPane.showMessageDialog(frame, msg, title, JOptionPane.ERROR_MESSAGE);

    }

    public void showSuccessMessage(final String title, final String msg, JFrame frame){

        JOptionPane.showMessageDialog(frame,msg,title,JOptionPane.INFORMATION_MESSAGE);

    }
}
