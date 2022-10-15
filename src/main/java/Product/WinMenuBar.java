package Product;

import java.awt.*;

public class WinMenuBar extends MenuBar{
    public WinMenuBar() {
        setColor();
    }

    @Override
    void setColor() {
        this.setBackground(new Color(208, 161, 225));
    }
}
