package Observer;

import Main.GUI;
import Product.MenuItem;

import javax.swing.*;

public class Function_FontWrap extends Function_Observer{
    private GUI gui;
    private JFrame window;
    private JTextArea textArea;
    private MenuItem iWrap;

    public Function_FontWrap(GUI gui, Subject subject) {
        this.subject = subject;

        this.gui = gui;
        this.window = this.gui.getFrame();
        this.textArea = this.gui.getTextArea();
        this.iWrap = this.gui.getiWrap();
    }

    @Override
    public void update() {
        if(iWrap.getText() == "Word Wrap: Off"){
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            iWrap.setText("Word Wrap: On");
        }
        else{
            textArea.setLineWrap(false);
            textArea.setWrapStyleWord(false);
            iWrap.setText("Word Wrap: Off");
        }
    }
}
