package Observer;

import Mediator.ObserverMediator;
import Product.MenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/***
 * Subject is the "Subject" character in "Observer Pattern".
 * 1.It knows Observer object(Function_Observer type).
 * 2.Any Observer object(Function_Observer type) can subscribe this Subject.
 * 3.Providing subscribe method( attach() ).
 ---------------------------------------------------------
 very loose coupling between a Subject(this) and its Observers(Function_Observer type)
 ***/
public class Subject implements ActionListener{ //被觀察者
    private ObserverMediator observerMediator;

    private String command;

    public Subject(){
         observerMediator = ObserverMediator.getInstance();
    }

    public String getCommand(){
        return command;
    }
    @Override//update all the Observer
    public void actionPerformed(ActionEvent e){
        command = e.getActionCommand();
        try {
            observerMediator.notify(command);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public void attach(Function_Observer observer, MenuItem item, String command){
      item.addActionListener(this); //這裡面要放有implement監聽器的class
      item.setActionCommand(command);
      observerMediator.register(observer,command);
    }
}
