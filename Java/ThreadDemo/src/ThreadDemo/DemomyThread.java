package ThreadDemo;

public class DemomyThread {
    public static void main(String[] args) {
        myThread t1=new myThread("线程A");
        myThread t2=new myThread("线程B");
        t1.start();
        t2.start();
    }
}
