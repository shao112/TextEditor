package Adapter;

import javax.swing.*;
import java.io.IOException;

public class Adapter implements Target{
    private PdfAdaptee pdfAdaptee;
    public Adapter(PdfAdaptee pdfAdaptee){
        this.pdfAdaptee = pdfAdaptee;
    }
    @Override
    public void request(JTextArea textArea, String fileName, String fileAddress) throws IOException {
        pdfAdaptee.loadFile(textArea,fileName,fileAddress);
    }
}
