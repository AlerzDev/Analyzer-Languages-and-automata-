package analyzer;

import helpers.Message;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by lemuz on 4/12/16.
 */

public class AnalyzerActions {
    private static AnalyzerActions instance;

    public static AnalyzerActions getInstance(){
        if (instance == null)
            instance = new AnalyzerActions();
        return instance;
    }

    public String ejecutar(){
        String result = "";
        String[] archivoPrueba = {"test.txt"};
        AnalizadorSintactico.main(archivoPrueba);
        Message helper = Message.getInstance();
        if(!helper.getResult().equals("")){
            result = "Ejecutado!\n"+helper.getMessage()+helper.getResult()+"\n";
        }
        if(!helper.getError().equals("")){
            result = "Error: "+helper.getError()+"\n";
            System.out.print(helper.getError());
        }
        return result;
    }
}
