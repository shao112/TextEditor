package Strategy;

import javax.swing.*;

/***
 * Context is the Context character in "Strategy Pattern".
 ---------------------------------------------------------
 We apply Strategy to set alignment.
 ***/
public class Context {
    private AlignStrategy strategy;

    public Context(AlignStrategy strategy) {
        this.strategy = strategy;
    }
    public void execute(JTextArea textArea){
        strategy.executeAlign(textArea);
    }
}
