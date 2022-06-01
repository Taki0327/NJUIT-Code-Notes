package ThreadDemo;

public class DemomThread2 {
    public static void main(String[] args) {
        /*myThread2 t1=new myThread2("线程A");
        myThread2 t2=new myThread2("线程B");
        Thread tt1=new Thread(t1);
        Thread tt2=new Thread(t2);
        tt1.start();
        tt2.start();*/
        new Thread(new myThread2("线程A")).start();
        new Thread(new myThread2("线程B")).start();
    }
}
