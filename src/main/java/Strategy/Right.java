package Strategy;

import javax.swing.*;

/***
 * Right is the ConcreteStrategy character in "Strategy Pattern".
 ---------------------------------------------------------
 Set right alignment.
 ***/
public class Right implements AlignStrategy{
    @Override
    public void executeAlign(JTextArea textArea) {
        textArea.setText("\t      " + textArea.getText());
//        textArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    }
}
