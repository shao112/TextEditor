package state;

import javax.swing.*;

/***
 * stateContext is the "Context" character in State Pattern.
 * 主要實作偵測編輯器頁面有沒有輸入文字，沒有的話會顯示請輸入文字頁面
 ***/
public class stateContext {
    private TextEditorState state;
    private JTextArea textArea;

    public stateContext(JTextArea textArea) {
        /***
         * 設定預設 state 為 TextEditorWithoutTexting ，因為編輯器打開時預設為空白
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
