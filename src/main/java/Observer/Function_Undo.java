package Observer;

import Main.GUI;
import Memento.Caretaker;
import Memento.Originator;

import javax.swing.*;

public class Function_Undo extends Function_Observer{
    private GUI gui;
    private JTextArea textArea;
    private Caretaker caretaker;
    private Originator originator;

    public Function_Undo(GUI gui, Subject subject, Caretaker caretaker, Originator originator) {
        this.subject = subject;
        this.gui = gui;
        this.textArea = this.gui.getTextArea();
        this.caretaker = caretaker;
        this.originator = originator;
    }

    @Override
    public void update() {
        System.out.println(caretaker.getCurrentText());
        if(caretaker.getCurrentText() >= 1){
            caretaker.setCurrentTextMinusOne();
            String textBoxString = originator.restoreFromMemento( caretaker.getMemento(caretaker.getCurrentText()));
            textArea.setText(textBoxString);
        }
    }
}
