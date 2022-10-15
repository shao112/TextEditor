package state;

import Iterator.List;

import javax.swing.*;
import java.util.Iterator;

/***
 * TextEditorHasTexted is the "ConcreteState" character in State Pattern.
 * 實作偵測到文字編輯器內容有 PlaceHolder 文字時，將頁面清空，並可輸入文字
 * 如果編輯器文字被清空，將會切換狀態回 TextEditorWithoutTexting
 ***/
public class TextEditorHasTexted implements TextEditorState {
    private List list;
    public TextEditorHasTexted(List list) {
         this.list = list;
    }

    @Override
    public void showPlaceHolder(JTextArea textArea, stateContext state) {
        String listStr = "";
        // 取出iterator
        Iterator it = list.getIterator();
        // 使用 hasNext與next取出list裡面的元素
        while (it.hasNext()) {
            char line = (char)it.next();
            listStr+=String.valueOf(line);
        }
        if (textArea.getText().equals("")){
            state.setState(new TextEditorWithoutTexting());
            state.execute();
        }else if (textArea.getText().equals(listStr)) {
            textArea.setText("");
        }
    }
}

