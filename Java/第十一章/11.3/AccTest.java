public class AccTest {
    public static void main(String[] args) {
        Account2 a1 = new Account2(1122, 20000);
        a1.setAnnuallnterestRate(4.5);
        a1.withDraw(5000);
        System.out.println(a1.toString());

        CheckingAccount ca1=new CheckingAccount(244,5000);
        ca1.setAnnuallnterestRate(4.5);
        ca1.deposit(0);
        ca1.withDraw(7000);
        System.out.println(ca1.toString());

        SavingsAccount sa1=new SavingsAccount(254,32323);
        sa1.setAnnuallnterestRate(4.5);
        sa1.deposit(0);
        sa1.withDraw(33333);
        System.out.println(sa1.toString());
    }
}
