package Observer;

import Main.GUI;
import builder.Font_Builder_Concrete;
import builder.Font_Builder_Interface;

import javax.swing.*;
import java.awt.*;

public class Function_FontFormat extends Function_Observer{
    //region Description desc="Attribute"
    private Font font;
    private GUI gui;
    private JTextArea textArea;
    private String selectedFont;
    private int fontSize;

    private Font_Builder_Interface builder = new Font_Builder_Concrete();
    //endregion
    public Function_FontFormat(GUI gui, Subject subject) {
        //region Description desc="Constructor"
        this.subject = subject;
        this.gui = gui;
        this.textArea = this.gui.getTextArea();
        //endregion
    }
    @Override
    public void update() {
        //region Description desc="update()"
        command = subject.getCommand();
        if(command == "Arial" || command == "Comic Sans MS" || command == "Times New Roman"){
            selectedFont = command;
            fontSize = textArea.getFont().getSize();
            font = construct(selectedFont,fontSize);
            textArea.setFont(font);
        }
        else if(command == "12" ||command == "16" ||command == "20" ||command == "24" || command == "28"){
            fontSize = Integer.parseInt(command); //±NStringÂà¬°int
            selectedFont = textArea.getFont().getFontName();
            font = construct(selectedFont,fontSize);
            textArea.setFont(font);
        }
        //endregion
    }
    //fluent interface
    public Font construct(String selectedFont, int fontSize) {
        return builder.setFontSize(fontSize)
                .setFont(selectedFont)
                .create();
    }
}
