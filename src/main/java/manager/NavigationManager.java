package manager;

import controller.RegisterController;
import ui.Register;

/**
 * Created by lemuz on 3/12/16.
 */
public class NavigationManager {

    private static NavigationManager instance;

    public static NavigationManager getInstance() {
        if (instance == null) {
            instance = new NavigationManager();
        }
        return instance;
    }

    public void loadRegisterFrame(){
        Register r = new Register();
        RegisterController rc = new RegisterController(r);
    }
}
