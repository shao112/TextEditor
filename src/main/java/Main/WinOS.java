package Main;

import FactoryAndTemplate.EnvironmentFactory;
import FactoryAndTemplate.WindowsFactory;

import javax.swing.*;

public class WinOS implements OperatingSystem{
    @Override
    public JFrame createOS() {
        //設定JFrame的風格
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | UnsupportedLookAndFeelException ex) {
            throw new RuntimeException("Test Failed. MetalLookAndFeel not set "
                    + "for frame");
        }

        return new JFrame();
    }
    @Override
    public EnvironmentFactory getFactory(GUI gui) {
        return new WindowsFactory(gui);
    }
}