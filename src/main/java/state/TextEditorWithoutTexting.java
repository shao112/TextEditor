package state;

import Iterator.List;

import javax.swing.*;
import java.util.Iterator;

/***
 * TextEditorWithoutTexting is the "ConcreteState" character in State Pattern.
 * ��@�������r�s�边���e���ŮɡA�z�L Iterator Pattern �h��� PlaceHolder ��r
 ***/
public class TextEditorWithoutTexting implements TextEditorState {

    @Override
    public void showPlaceHolder(JTextArea textArea, stateContext state) {
        List list = new List();
        list.add("\ntest");
        if (textArea.getText().equals("")) {
            // ���Xiterator
            Iterator it = list.getIterator();
            // �ϥ� hasNext�Pnext���Xlist�̭�������
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

