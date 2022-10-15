package state;

import Iterator.List;

import javax.swing.*;
import java.util.Iterator;

/***
 * TextEditorHasTexted is the "ConcreteState" character in State Pattern.
 * ��@�������r�s�边���e�� PlaceHolder ��r�ɡA�N�����M�šA�åi��J��r
 * �p�G�s�边��r�Q�M�šA�N�|�������A�^ TextEditorWithoutTexting
 ***/
public class TextEditorHasTexted implements TextEditorState {
    private List list;
    public TextEditorHasTexted(List list) {
         this.list = list;
    }

    @Override
    public void showPlaceHolder(JTextArea textArea, stateContext state) {
        String listStr = "";
        // ���Xiterator
        Iterator it = list.getIterator();
        // �ϥ� hasNext�Pnext���Xlist�̭�������
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

