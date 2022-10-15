package Observer;

import Main.GUI;
import Memento.Caretaker;
import Memento.Originator;

import javax.swing.*;

public class Function_SaveText extends Function_Observer{
    private GUI gui;
    private JTextArea textArea;
    private Caretaker caretaker;
    private Originator originator;

    public Function_SaveText(GUI gui, Subject subject, Caretaker caretaker, Originator originator) {
        this.subject = subject;
        this.gui = gui;
        this.textArea = this.gui.getTextArea();
        this.caretaker = caretaker;
        this.originator = originator;
    }

    @Override
    public void update() {
        String textInTextArea = textArea.getText();

        originator.set(textInTextArea);
        caretaker.addMemento( originator.storeInMemento() );
        caretaker.setSaveFilesAddOne();
        caretaker.setCurrentTextAddOne();

        System.out.println("Save Files");
    }
}
