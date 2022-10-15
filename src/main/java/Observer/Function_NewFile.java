package Observer;

import Main.GUI;

import javax.swing.*;

/***
 * Function_NewFile is the "ConcreteObserver" character in "Observer Pattern".
 ---------------------------------------------------------

 ***/
public class Function_NewFile extends Function_Observer{
    private GUI gui;
    private JFrame window;
    private JTextArea textArea;
    private String fileName, fileAddress;

    public Function_NewFile(GUI gui, Subject subject) {
        this.subject = subject;
        this.gui = gui;
        this.window = this.gui.getFrame();
        this.textArea = this.gui.getTextArea();
        this.fileName = this.gui.getFileName();
        this.fileAddress = this.gui.getFileAddress();
    }
    @Override
    public void update() {
            textArea.setText("");
            window.setTitle("New");
            fileName = null;
            fileAddress = null;
        }
}
