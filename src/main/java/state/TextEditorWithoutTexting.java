package state;

import Iterator.List;

import javax.swing.*;
import java.util.Iterator;

/***
 * TextEditorWithoutTexting is the "ConcreteState" character in State Pattern.
 * 實作偵測到文字編輯器內容為空時，透過 Iterator Pattern 去顯示 PlaceHolder 文字
 ***/
public class TextEditorWithoutTexting implements TextEditorState {

    @Override
    public void showPlaceHolder(JTextArea textArea, stateContext state) {
        List list = new List();
        list.add("\ntest");
        if (textArea.getText().equals("")) {
            // 取出iterator
            Iterator it = list.getIterator();
            // 使用 hasNext與next取出list裡面的元素
            while (it.hasNext()) {
                char line = (char) it.next();
                textArea.setText(textArea.getText() + line);
            }
            textArea.setEditable(false);
        } else {
            state.setState(new TextEditorHasTexted(list));
            state.execute();
        }
    }
}

