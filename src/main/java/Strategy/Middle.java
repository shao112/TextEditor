package Strategy;

import javax.swing.*;
import java.awt.*;

/***
 * Middle is the ConcreteStrategy character in "Strategy Pattern".
 ---------------------------------------------------------
 Set center alignment.
 ***/
public class Middle implements AlignStrategy{
    @Override
    public void executeAlign(JTextArea textArea) {
        textArea.setText("\t      " + textArea.getText());
        textArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    }
}
