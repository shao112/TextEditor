package Flyweight;

import java.util.HashMap;
import java.util.Map;

public class CharFactory {
    private static Map<Character,Char> charpool = new HashMap<>();

    public static Char getChar(char c){
        // 如果沒有這個字元，就新增
        if(!charpool.containsKey(c)){
            charpool.put(c,new Char(c));
            return new Char(c);
        }
        // 已經有字元，拿 pool 裡面的出來
        return charpool.get(c);
    }
}
