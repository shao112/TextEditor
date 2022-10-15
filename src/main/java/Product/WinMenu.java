package Product;

import java.awt.*;

public class WinMenu extends Menu{
    public WinMenu(){
        this.setOpaque(true);  //設透明度
        this.setBackground(new Color(206,118,228));
        this.setForeground(new Color(246, 246, 246, 255));
        //設定被選取的Menu以及沒被選取的Menu顏色
        this.addChangeListener(e -> {
            if (e.getSource() instanceof Menu) {
                Menu item = (Menu) e.getSource();
                if (item.isSelected() || item.isArmed()) {
                    item.setBackground(new Color(162,99,178, 255));
                    item.setForeground(Color.WHITE);
                } else {
                    item.setBackground(new Color(206,118,228));
                    item.setForeground(new Color(246, 246, 246, 255));
                }
            }
        });
    }
    @Override
    public void setShortcut(char c) {
        this.setMnemonic(c);
    }

    @Override
    public void setSeparator() {
        this.addSeparator();
    }

}
