package Mediator;

import Observer.Function_Observer;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ObserverMediator {
    //private instance
    private static volatile ObserverMediator instance;
    private Map<String, Function_Observer> observers = new HashMap<>();
    //private constructor
    private ObserverMediator(){}
    //a method for get this instance.
    public static ObserverMediator getInstance() {
        if (instance == null){
            synchronized(ObserverMediator.class){
                if (instance == null){
                    instance = new ObserverMediator();
                }
            }
        }
        return instance;
    }

    public void register(Function_Observer function, String command){
        observers.put(command,function);
    }
    public void notify(String command) throws IOException {
        observers.get(command).update();
    }
}
