package state;

import javax.swing.*;

/***
 * TextEditorState is the "State" character in State Pattern.
 * 設定 TextEditorState 去實作 showPlaceHolder Methods
 ***/
public interface TextEditorState {
    void showPlaceHolder(JTextArea textArea, stateContext state);
}
