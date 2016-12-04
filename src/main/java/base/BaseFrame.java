package base;

import javax.swing.*;

/**
 * Created by lemuz on 3/12/16.
 */
public abstract class BaseFrame extends JFrame {

    protected BaseFrame(){
        this.setResizable(resizable());
        this.setTitle(titleWindow());
        typeCloseWindow();
        sizeWindow();
        centerWindow();
        initView();
        this.setVisible(true);

    }

    private void typeCloseWindow(){
        if(exitOnClose()) this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        else this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void centerWindow(){
        if(centerLocation()) this.setLocationRelativeTo(null);
    }

    private void sizeWindow(){
        this.setSize(widthWindow(),heightWindow());
    }

    protected abstract void    initView();
    protected abstract String  titleWindow();
    protected abstract int     widthWindow();
    protected abstract int     heightWindow();
    protected abstract boolean exitOnClose();
    protected abstract boolean resizable();
    protected abstract boolean centerLocation();


}
