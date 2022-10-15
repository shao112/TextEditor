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
    private String[] list = {"�@�@�@ _���@�ááá� �@ \n" , "�@�@���@�@�@�@�@�@�@�@   \\ \n" ,"�@/�@�@�@�@���@�@�@�@�@�� \\ \n" , "�@!�@�@�@�@�@�@ �@�@ ���@�@l      Please input text...\n","�@|_ �@ �@�@�@ �@�@ �H �@     / \n","�@�@�@______________"};
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
     * ���o Iterator
     */
    public ListIterator getIterator(){
        return new ListIterator();
    }

    /**
     * �z�L getIterator ���o Iterator �A�ҥH�i�H�ŧi private
     */
    private class ListIterator implements Iterator<Character> {
        @Override
        // ��@hasNext
        public boolean hasNext() {
            if(index >= CharList.size()){
                return false;
            }
            return true;
        }
        @Override
        // ��@next
        public Character next() {
            if(hasNext()){
                return CharList.get(index++).getChar();
            }
            throw new IndexOutOfBoundsException();
        }

    }
}
