package ThreadDemo;

public class ticketUser {
    public static void main(String[] args) {
        new Thread(new TicketThread("xx")).start();
        new Thread(new TicketThread("zx")).start();
        new Thread(new TicketThread("zfl")).start();
        new Thread(new TicketThread("zc")).start();
        new Thread(new TicketThread("csh")).start();
        new Thread(new TicketThread("jf")).start();
    }
}
