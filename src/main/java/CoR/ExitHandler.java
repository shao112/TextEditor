package CoR;

public abstract class ExitHandler {
    protected ExitHandler next;
    ExitHandler(ExitHandler next) {
        this.next = next;
    }
    void toNext(String saveState) {
        if(next != null) {
            next.handle(saveState);
        }
        //�S�����~�̡A��ܬO���ݤF�C
    }
    public abstract void handle(String saveState);
}
