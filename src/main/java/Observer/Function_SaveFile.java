package Observer;


import Main.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;

public class Function_SaveFile extends Function_Observer {
    private String fileName, fileAddress;
    private GUI gui;
    private JFrame window;
    private JTextArea textArea;

    public Function_SaveFile(GUI gui, Subject subject){
        this.subject = subject;

        this.gui = gui;
        this.window = gui.getFrame();
        this.textArea = gui.getTextArea();
        this.fileName = gui.getFileName();
        this.fileAddress = gui.getFileAddress();
    }

    @Override
    public void update() {
            //如果還沒存過 -> saveAsFile() 存過的話．．．．
            if(fileName == null) {
//                saveState = "Saved"; 要加上去
                try{
                    FileDialog fd = new FileDialog(window, "Save", FileDialog.SAVE);
                    fd.setVisible(true);
                    fileName = fd.getFile();
                    gui.setFileName(fileName);
                    fileAddress = fd.getDirectory();
                    gui.setFileAddress(fileAddress);
                    window.setTitle(fileName);
                    FileWriter fw = new FileWriter(fileAddress + fileName);
                    fw.write(textArea.getText());
                    gui.setSaveState("Saved");
                    fw.close();

                }catch(Exception e) {
                    System.out.println("SOMETHING WRONG!");
                }
            }
            else {
                try {
                    FileWriter fw = new FileWriter(fileAddress + fileName);
                    fw.write(textArea.getText());
                    window.setTitle(fileName);
//                    saveState = "Saved"; 要加上去
                    fw.close();

                }catch(Exception a) {
                    System.out.println("SOMETHING WRONG!");
                }
            }
    }
}
