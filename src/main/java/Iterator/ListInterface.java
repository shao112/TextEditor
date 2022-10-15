package Iterator;
/***
 * ListInterface is the "Aggregate" character in Iterator Pattern.
 * Provide a way to add String to the String list without exposing its underlying representation.
 ***/
public interface ListInterface {
    // List 要有增加元素的方法
    public void add(String str);
}
