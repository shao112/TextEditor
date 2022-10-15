package Memento;

public class Memento {
    private String Text;

    public Memento(String textSave) {
        Text = textSave;
    }

    public String getSavedText() {
        return Text;
    }
}
