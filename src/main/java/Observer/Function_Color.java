package Observer;

import Main.GUI;

import javax.swing.*;
import java.awt.*;

public class Function_Color extends Function_Observer{
    private GUI gui;
    private JFrame window;
    private JTextArea textArea;

    public Function_Color(GUI gui, Subject subject) {
        this.subject = subject;
        this.gui = gui;
        this.window = this.gui.getFrame();
        this.textArea = this.gui.getTextArea();
    }

    @Override
    public void update() {
        command = subject.getCommand();
            switch(command) {
                case "Color1":
                    //Default
                    window.getContentPane().setBackground(Color.white);
                    textArea.setBackground(Color.white); //­I´ºÃC¦â
                    textArea.setForeground(Color.black); //¦rªºÃC¦â
                    break;
                case "Color2":
                    //Black
                    window.getContentPane().setBackground(Color.black);
                    textArea.setBackground(Color.black);
                    textArea.setForeground(Color.white);
                    break;
                case "Color3":
                    //
                    window.getContentPane().setBackground(new Color(247, 235, 222));
                    textArea.setBackground(new Color(247, 235, 222));
                    textArea.setForeground(new Color(148, 94, 36));
                    break;
            }

    }
}
