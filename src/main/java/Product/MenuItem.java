package Product;

import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class MenuItem extends JMenuItem implements Product {
    //匯集Windows的MenuItem以及Mac的MenuItem
    abstract public void setColor();


//    public Object clone() throws CloneNotSupportedException {
//        return null;
//    }
    @Override
    public Object clone() {
        Object clone = null;
        try {
            clone = (MenuItem)super.clone();

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
            Object clone = (MenuItem)ois.readObject();

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
