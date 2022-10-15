package Observer;

import java.io.IOException;

/***
 * Function_Observer is the "Observer" character in "Observer Pattern".
 ***/
public abstract class Function_Observer{
    protected String command;
    protected Subject subject;
    //update() have no parameter.
    public abstract void update() throws IOException;
}
