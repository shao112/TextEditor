package Product;

import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class Menu extends JMenu implements Product {
    //匯集Windows的Menu以及Mac的Menu
    abstract public void setShortcut(char c);	//設置Menu快捷鍵 alt+"c"
    abstract public void setSeparator();	//設置Menu裡面的MenuItem的分隔線

    @Override
    public Object clone(){
        Object clone = null;
        try {
            clone = (Menu)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    @Override
    public Object deepClone() {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            // 序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            // 反序列化
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            Object clone = (Menu)ois.readObject();

            return clone;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (Exception e2){
                System.out.println(e2.getMessage());
            }
        }
    }
}
