package Product;

import java.awt.*;

public class MacMenuBar extends MenuBar {
    public MacMenuBar() {
        setColor();
    }

    @Override
    void setColor() {
        this.setBackground(new Color(158, 164, 176, 255));
    }
}
