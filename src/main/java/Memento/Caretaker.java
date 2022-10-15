package Memento;

import java.util.ArrayList;

public class Caretaker {
    private ArrayList<Memento> savedText = new ArrayList<Memento>();
    private int saveFiles = 0;
    private int currentText = 0;

    public void addMemento(Memento memento){
        savedText.add(memento);
    }

    public Memento getMemento(int index){
        return savedText.get(index);
    }

    public void setSaveFilesAddOne() {
        this.saveFiles++;
    }

    public void setCurrentTextAddOne() {
        this.currentText++;
    }

    public void setCurrentTextMinusOne() {
        this.currentText--;
    }

    public int getSaveFiles() {
        return saveFiles;
    }

    public int getCurrentText() {
        return currentText;
    }
}
