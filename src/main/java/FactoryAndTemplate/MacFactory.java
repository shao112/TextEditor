package FactoryAndTemplate;

import Main.GUI;
import Product.*;

import javax.swing.*;


public class MacFactory extends EnvironmentFactory{
    private JFrame frame;
    public MacFactory(GUI gui) {
        super(gui);
        this.frame = gui.getFrame();
        MacMenuItem macMenuItem = new MacMenuItem();
        prototype.addPrototype("MacMenuItem", macMenuItem);
        MacMenuBar macMenuBar = new MacMenuBar();
        prototype.addPrototype("MacMenuBar", macMenuBar);
        MacMenu macMenu = new MacMenu();
        prototype.addPrototype("MacMenu", macMenu);
    }

    @Override
    public void changeIcon() {
        frame.setIconImage(new ImageIcon(getClass().getResource("mac.png")).getImage());
    }

    @Override
    public MenuBar createMenuBar() throws CloneNotSupportedException {
        return (MenuBar) prototype.getPrototype("MacMenuBar");
    }

    @Override
    public Menu createMenu() throws CloneNotSupportedException {
        return (Menu) prototype.getPrototype("MacMenu");
    }

    @Override
    public MenuItem createMenuItem() throws CloneNotSupportedException {
        return (MenuItem) prototype.getPrototype("MacMenuItem");
    }
}
