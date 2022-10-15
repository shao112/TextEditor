package Adapter;

import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import javax.swing.*;
import java.io.IOException;

public class PdfAdaptee{
    public void loadFile(JTextArea textArea, String fileName, String fileAddress) throws IOException {
        try
        {
            //Create a PdfReader instance.
            PdfReader pdf = new PdfReader(fileAddress + fileName);

            //Get the number of pages in pdf.
            int nbrPages = pdf.getNumberOfPages();

            //Iterate the pdf through the pages.
            for(int i=1; i <= nbrPages; i++)
            {
                //Extract the content of the page using PdfTextExtractor.
                String content = PdfTextExtractor.getTextFromPage(pdf, i);
                textArea.append(content + "\n");
                //Display the content of the page on the console.
                System.out.println("Content of the page : " + content);
            }
            //Close the PdfReader.
            pdf.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    }
