package ThreadDemo;

public class myThread2 implements Runnable{
    private String name;

    public myThread2(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 1; i <= 10; i++) {
            System.out.println(name+"第"+i+"次循环");
            Thread.sleep(1000);
        }
    }
    
}
