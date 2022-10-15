package FactoryAndTemplate;

import Main.GUI;
import Product.*;


public class WindowsFactory extends EnvironmentFactory{

    public WindowsFactory(GUI gui) {
        super(gui);
        WinMenuItem winMenuItem = new WinMenuItem();
        prototype.addPrototype("WindowsMenuItem", winMenuItem);
        WinMenuBar winMenuBar = new WinMenuBar();
        prototype.addPrototype("WindowsMenuBar", winMenuBar);
        WinMenu winMenu = new WinMenu();
        prototype.addPrototype("WindowsMenu", winMenu);
    }

    @Override
    public void changeIcon() {
        //Do nothing
    }

    @Override
    public MenuBar createMenuBar() throws CloneNotSupportedException  {
        return (MenuBar) prototype.getPrototype("WindowsMenuBar");
    }

    @Override
    public Menu createMenu() throws CloneNotSupportedException  {
        return (Menu) prototype.getPrototype("WindowsMenu");
    }

    @Override
    public MenuItem createMenuItem() throws CloneNotSupportedException {
        return (MenuItem) prototype.getPrototype("WindowsMenuItem");
    }
}
