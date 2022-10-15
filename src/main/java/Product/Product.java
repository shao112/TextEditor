package Product;

public interface Product extends Cloneable{
    public Object clone() throws CloneNotSupportedException;

    public Object deepClone();
}
