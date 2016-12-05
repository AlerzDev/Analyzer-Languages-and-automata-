package controller;

import analyzer.AnalyzerActions;
import base.BaseFrameInterface;
import ui.Analyzer;
import utils.ViewUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by lemuz on 4/12/16.
 */

public class AnalizerController implements BaseFrameInterface{

    private Analyzer analyzer;
    private JTextField[] fields;
    private JButton      clean;
    private JButton      check;
    private JTextArea    results;

    public AnalizerController(Analyzer analyzer){
        this.analyzer = analyzer;
        initView();
    }

    public void initView() {
        fields = analyzer.getFields();
        clean = analyzer.getClean();
        check = analyzer.getCheck();
        results = analyzer.getResults();
        clean.addActionListener(new ListenerClenaButton());
        check.addActionListener(new ListenerCheckButton());
    }

    public void success(String title, String msg) {
        ViewUtils.getInstance().showSuccessMessage(title,msg,analyzer);
    }

    public void error(String title, String msg) {
        ViewUtils.getInstance().showErrorMessage(title,msg,analyzer);
    }

    private class ListenerClenaButton implements ActionListener{

        public void actionPerformed(ActionEvent actionEvent) {
            for (JTextField field : fields) {
                field.setText("");
            }
        }
    }

    private class ListenerCheckButton implements ActionListener{

        public void actionPerformed(ActionEvent actionEvent) {
            try {
                PrintWriter writer = new PrintWriter("test.txt", "UTF-8");
                int x = 0;
                for (JTextField field : fields) {
                    if (!field.getText().equals("")) {
                        writer.println(field.getText() + ";");
                    } else {
                        x++;
                    }
                }
                writer.close();
                if (x == 7) {
                    error("Error", "No se a ingresado ninguna operación");
                } else {
                   String textResult = AnalyzerActions.getInstance().ejecutar();
                   results.setText(textResult);
                }
            }catch (Exception e){
                results.setText(e.getMessage());
            }

        }
    }

}
