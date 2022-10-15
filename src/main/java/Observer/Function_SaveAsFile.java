package Observer;

import Main.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;

public class Function_SaveAsFile extends Function_Observer{
    String fileName, fileAddress;
    private GUI gui;
    private JFrame window;
    private JTextArea textArea;

    public Function_SaveAsFile(GUI gui, Subject subject) {
        this.subject = subject;

        this.gui = gui;
        this.window = this.gui.getFrame();
        this.textArea = this.gui.getTextArea();
        this.fileName = gui.getFileName();
        this.fileAddress = gui.getFileAddress();
    }

    @Override
    public void update() {
            FileDialog fd = new FileDialog(window, "Save", FileDialog.SAVE);
            fd.setVisible(true);

            if(fd.getFile() != null) {
                fileName = fd.getFile();
                gui.setFileName(fileName);
                fileAddress = fd.getDirectory();
                gui.setFileAddress(fileAddress);
                window.setTitle(fileName);
            }
            try{
                FileWriter fw = new FileWriter(fileAddress + fileName);
                fw.write(textArea.getText());
                gui.setSaveState("Saved");
                fw.close();

            }catch(Exception e) {
                System.out.println("SOMETHING WRONG!");
            }
//        }

    }
}
