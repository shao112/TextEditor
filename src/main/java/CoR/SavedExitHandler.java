package CoR;

public class SavedExitHandler extends ExitHandler{
    public SavedExitHandler(ExitHandler next) {
        super(next);
    }
    public void handle(String saveState) {
        if(saveState == "Saved") {
            System.exit(0);
        }
        else{
            toNext(saveState);
        }
    }
}
