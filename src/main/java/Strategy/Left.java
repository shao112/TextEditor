package Strategy;

import javax.swing.*;
import java.awt.*;

/***
 * Left is the ConcreteStrategy character in "Strategy Pattern".
 ---------------------------------------------------------
 Set left alignment.
 ***/
public class Left implements AlignStrategy{
    @Override
    public void executeAlign(JTextArea textArea) {
//        menuBar.add(Box.createHorizontalGlue());
        textArea.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }
}
