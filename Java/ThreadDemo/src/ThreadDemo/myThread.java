package ThreadDemo;

public class myThread extends Thread {
    private String name;
    private int time=5;
    public myThread(String name) {
        this.name = name;
    }

    public static void main(String args[]) {

    }
    public void cz(){
        time=5;
    }
    public void run() {
       for (int i = 1; i <= 10; i++) {
            try {
                Thread.sleep(1000);
           } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(name+"第"+i+"次循环");
        }
        /*myThread.sleep(1000);
        time--;
        if(time<=0)
        {
            this.interrupt();
            new DemomyThread();
        }*/
    }
}
