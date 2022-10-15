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
        //沒有後繼者，表示是尾端了。
    }
    public abstract void handle(String saveState);
}
