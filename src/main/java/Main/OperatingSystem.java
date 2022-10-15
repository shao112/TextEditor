package Main;

import FactoryAndTemplate.EnvironmentFactory;

import javax.swing.*;

public interface OperatingSystem {
    JFrame createOS(); //for Bridge
    EnvironmentFactory getFactory(GUI gui); //for Abstract factory + Factory Method + Template method
}
