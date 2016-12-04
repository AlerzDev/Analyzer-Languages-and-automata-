package controller;

import base.BaseFrameInterface;
import ui.Analyzer;

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
        String path = "/home/lemuz/IdeaProjects/Analizador(Automatas2)/src/main/java/controller/Lexer.flex";
        generarLexer(path);
        initView();
    }

    private static void generarLexer(String path){
        File file=new File(path);
        jflex.Main.generate(file);
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

    }

    public void error(String title, String msg) {

    }

    private class ListenerClenaButton implements ActionListener{

        public void actionPerformed(ActionEvent actionEvent) {

        }
    }

    private class ListenerCheckButton implements ActionListener{

        public void actionPerformed(ActionEvent actionEvent) {
            try {
                probarLexerFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void probarLexerFile() throws IOException {
        File fichero = new File("fichero.txt");
        PrintWriter writer;
        try {
            writer = new PrintWriter(fichero);
            writer.print(fields[0].getText());
            writer.print(fields[1].getText());
            writer.close();
        } catch (FileNotFoundException n) {
            Logger.getLogger(AnalizerController.class.getName()).log(Level.SEVERE, null, n);
        }
        Reader reader = new BufferedReader(new FileReader("fichero.txt"));
        Lexemas lexer = new Lexemas(reader);
        String resultado = "";
        while (true) {
            Token token = lexer.yylex();

            if (token == null) {
                resultado = resultado + "EOF";
                results.setText(resultado);
                return;
            }
            switch (token) {
                case Error:
                    resultado = resultado + ("Error, simbolo no reconocido\n");
                    break;
                case Nombre:
                    resultado = resultado + "TOKEN: " + token + " " + lexer.lexema + "\n";
                    break;
                case Direccion:
                    resultado = resultado + "TOKEN: " + token + " " + lexer.lexema + "\n";
                    break;
                case Correo:
                case Celular:
                case Curp:
                case Nacimiento:
                case Carrera:
                default:
                    resultado = resultado + "TOKEN: " + token + "\n";
            }
        }
    }
}
