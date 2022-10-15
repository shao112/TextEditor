package state;

import javax.swing.*;

/***
 * TextEditorState is the "State" character in State Pattern.
 * �]�w TextEditorState �h��@ showPlaceHolder Methods
 ***/
public interface TextEditorState {
    void showPlaceHolder(JTextArea textArea, stateContext state);
}
