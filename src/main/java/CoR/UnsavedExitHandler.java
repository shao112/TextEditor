package CoR;

import javax.swing.*;

public class UnsavedExitHandler extends ExitHandler{
    public UnsavedExitHandler(ExitHandler next) {
        super(next);
    }
    public void handle(String saveState) {
        if(saveState == "Unsaved") {
            int answer = JOptionPane.showConfirmDialog(null,"You haven't saved! Do you want to exit?","Exit",JOptionPane.YES_NO_OPTION);
            System.out.println(answer);
            if(answer == JOptionPane.YES_OPTION){
                System.exit(0);
            }
        }
        else{
            toNext(saveState);
        }
    }
}
