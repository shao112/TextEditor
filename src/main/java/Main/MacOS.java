package Main;

import FactoryAndTemplate.EnvironmentFactory;
import FactoryAndTemplate.MacFactory;

import javax.swing.*;

public class MacOS implements OperatingSystem{
    @Override
    public JFrame createOS() {
        //設定JFrame的風格
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException ex) {
            throw new RuntimeException("Test Failed. MotifLookAndFeel not set "
                    + "for frame");
        }

        return new JFrame();
    }
    @Override
    public EnvironmentFactory getFactory(GUI gui) {
        return new MacFactory(gui);
    }
}
