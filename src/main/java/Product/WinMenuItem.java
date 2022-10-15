package Product;

import java.awt.*;

public class WinMenuItem extends MenuItem{
    public WinMenuItem(){
        setColor();
    }

//    public Object clone() {
//        Object clone = null;
//        try {
//            clone = (Product)super.clone();
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }
//        return clone;
//    }
    @Override
    public void setColor() {
        this.setOpaque(true);
        this.setForeground(new Color(0, 0, 0, 255));
        this.setBackground(new Color(231,192,192, 255));
    }
}
