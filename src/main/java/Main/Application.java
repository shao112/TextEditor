package Main;
/***
 The main method is executed in here
 ***/
public class Application {
    public static OperatingSystem os; //Bridge的implementor
//        	public static OperatingSystem os = new MacOS(); // <- 測試MacOS環境
    public static String osName;
    public static void main(String[] args)
    {
        try {
            createOS();
            GUI gui = new GUI(os);
//            System.out.println(osName); //測試 delete
        }catch(Exception e) {
            System.out.println("some error here" + e);
        }
    }
    //抓取你的作業系統是Windows還是Mac，由此來決定要new出何種OperatingSystem
    public static void createOS() {
        osName = System.getProperty("os.name");
        if(osName.startsWith("Windows")) {
            os = new WinOS();
            System.out.println("Windows success"); //delete
        }
        else if(osName.startsWith("Mac OS")) {
            os = new MacOS();
            System.out.println("Mac OS success"); //delete
        }
    }
}
