package state;

import javax.swing.*;

/***
 * stateContext is the "Context" character in State Pattern.
 * �D�n��@�����s�边�������S����J��r�A�S�����ܷ|��ܽп�J��r����
 ***/
public class stateContext {
    private TextEditorState state;
    private JTextArea textArea;

    public stateContext(JTextArea textArea) {
        /***
         * �]�w�w�] state �� TextEditorWithoutTexting �A�]���s�边���}�ɹw�]���ť�
         ***/
        state = new TextEditorWithoutTexting();
        this.textArea = textArea;
    }

    public void execute() {
        state.showPlaceHolder(textArea,this);
    }

    public void setState(TextEditorState state) {
        this.state = state;
    }
}
