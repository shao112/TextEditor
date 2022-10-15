package Observer;

import Main.GUI;
import Memento.Caretaker;
import Memento.Originator;

import javax.swing.*;
import javax.swing.undo.UndoManager;

public class Function_Redo extends Function_Observer{
    private GUI gui;
    private JTextArea textArea;
    private Caretaker caretaker;
    private Originator originator;

    public Function_Redo(GUI gui, Subject subject, Caretaker caretaker, Originator originator) {
        this.subject = subject;
        this.gui = gui;
        this.textArea = this.gui.getTextArea();
        this.caretaker = caretaker;
        this.originator = originator;
    }
    @Override
    public void update() {
        if((caretaker.getSaveFiles() - 1) > caretaker.getCurrentText()){
            caretaker.setCurrentTextAddOne();
            String textBoxString = originator.restoreFromMemento( caretaker.getMemento(caretaker.getCurrentText()) );
            textArea.setText(textBoxString);
        }
    }
}
