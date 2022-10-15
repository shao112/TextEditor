package Observer;

import CoR.ExitHandler;
import CoR.SavedExitHandler;
import CoR.UnsavedExitHandler;
import Main.GUI;

/***
 * Function_Exit is the "ConcreteObserver" character in "Observer Pattern".
 * Function_Exit also be the "Client" character in "Chain of Responsibility".
 ***/
public class Function_Exit extends Function_Observer{
    private GUI gui;
    private String saveState;

    public Function_Exit(GUI gui, Subject subject) {
        this.subject = subject;
        this.gui = gui;
        this.saveState = gui.getSaveState();
    }
    @Override
    public void update() {
            ExitHandler handler = new UnsavedExitHandler(
                                    new SavedExitHandler(null));
            handler.handle(saveState);
    }
}
