package ThreadDemo;

public class TicketThread implements Runnable{
    private static int ticket=5;
    private String name;

    public TicketThread(String name) {
        this.name = name;
    }
    @Override
    public synchronized void run() {
        // TODO Auto-generated method stub
        for (int i = 1; i <= 100; i++) {
            if(ticket>0)
            {
                System.out.println(name+"ticket="+ticket--);
            }
        }
    }

}
