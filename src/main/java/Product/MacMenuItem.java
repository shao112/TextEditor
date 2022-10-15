package Product;

import java.awt.*;

public class MacMenuItem extends MenuItem {
    public MacMenuItem(){
        setColor();
    }
    @Override
    public void setColor() {
        this.setOpaque(true);
        this.setForeground(new Color(84,80,64, 255));
        this.setBackground(new Color(241,184,179, 255));
    }
}
