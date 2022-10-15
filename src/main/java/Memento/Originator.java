package Memento;

public class Originator {
    private String Text;

    public void set(String newText) {
        System.out.println("From Originator: Current Version of \n"+newText+ "\n");
        this.Text = newText;
    }

    public Memento storeInMemento() {
        System.out.println("From Originator: Saving to Memento");
        return new Memento(Text);
    }

    public String restoreFromMemento(Memento memento) {
        Text = memento.getSavedText();
        System.out.println("From Originator: Previous Text Saved in Memento\n"+ Text + "\n");
        return Text;
    }
}
