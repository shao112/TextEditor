package Iterator;

import Flyweight.Char;
import Flyweight.CharFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/***
 * List is the "ConcreteAggregate" character in Iterator Pattern.
 * Provide a way to access the String list of an aggregate object
   sequentially without exposing its underlying representation.
 ***/
public class List implements ListInterface{
    private int index = 0;
    private CharFactory charFactory = new CharFactory();
    private String[] list = {"　　　 _／　￣￣￣￣ ＼ \n" , "　　／　　　　　　　　   \\ \n" ,"　/　　　　●　　　　　● \\ \n" , "　!　　　　　　 　　 ▼　　l      Please input text...\n","　|_ 　 　　　 　　 人 　     / \n","　　　______________"};
    private ArrayList<String> numList = new ArrayList<String>(Arrays.asList(list));
    private String str = numList.toString().replaceAll(",", "").replaceAll("\\[","").replaceAll("\\]","");
    private ArrayList<Char> CharList = new ArrayList<Char>();

    public List() {
        for(char c: this.str.toCharArray()) {
            CharList.add(charFactory.getChar(c));
        }
    }

    @Override
    public void add(String str){
        for(char c: str.toCharArray()) {
            CharList.add(charFactory.getChar(c));
        }
    }

    /**
     * 取得 Iterator
     */
    public ListIterator getIterator(){
        return new ListIterator();
    }

    /**
     * 透過 getIterator 取得 Iterator ，所以可以宣告 private
     */
    private class ListIterator implements Iterator<Character> {
        @Override
        // 實作hasNext
        public boolean hasNext() {
            if(index >= CharList.size()){
                return false;
            }
            return true;
        }
        @Override
        // 實作next
        public Character next() {
            if(hasNext()){
                return CharList.get(index++).getChar();
            }
            throw new IndexOutOfBoundsException();
        }

    }
}
