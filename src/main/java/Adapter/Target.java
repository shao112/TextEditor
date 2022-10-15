package Adapter;

import javax.swing.*;
import java.io.IOException;

public interface Target {
    public void request(JTextArea textArea, String fileName, String fileAddress) throws IOException;
}
