package Observer;

import Adapter.PdfAdaptee;
import Adapter.Adapter;
import Adapter.Target;
//import Adapter.TxtAdaptee;
import Main.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Function_OpenFile extends Function_Observer{
    private String fileName, fileAddress;
    private GUI gui;
    private JFrame window;
    private JTextArea textArea;
    private Target target;
    private String extension;
    private PdfAdaptee pdfAdaptee = new PdfAdaptee();

    public Function_OpenFile(GUI gui, Subject subject) {
        this.subject = subject;

        this.gui = gui;
        this.window = this.gui.getFrame();
        this.textArea = this.gui.getTextArea();
        this.fileName = this.gui.getFileName();
        this.fileAddress = this.gui.getFileAddress();
        target = new Adapter(pdfAdaptee);
    }

    @Override
    public void update() throws IOException {
            FileDialog fd = new FileDialog(window,"Open",FileDialog.LOAD);
            fd.setVisible(true);

            if(fd.getFile() != null) {
                fileName = fd.getFile();
                fileAddress = fd.getDirectory();
                extension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
                System.out.println(fileName + " " + " " + fileAddress + " " + extension);
                if(extension.equalsIgnoreCase("txt")){
                    try {
                        window.setTitle(fileName);
                        BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
                        textArea.setText("");

                        String line = null;
                        while((line = br.readLine()) != null) {
                            textArea.append(line + "\n");
                        }
                        br.close();
                        JOptionPane.showMessageDialog(null,"Open successfully!","Open", JOptionPane.INFORMATION_MESSAGE);
                    }catch(Exception e){
                        System.out.println("File Not Opened!");
                    }

                }
                else if(extension.equalsIgnoreCase("pdf")) {
                    window.setTitle(fileName);
                    target.request(textArea,fileName,fileAddress);
                    JOptionPane.showMessageDialog(null,"Open successfully!","Open", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null,extension + " is not support, the acceptable file extension are \"txt\" and \"pdf\"!","Open", JOptionPane.ERROR_MESSAGE);
                }
            }
    }
}
