public class SavingsAccount extends Account2{
    public SavingsAccount (int id,double balance) {
        super(id,balance);
    }
    public void withDraw(double amount) {

        if(getBalance() - amount<0)
        {
            System.out.println("不允许透支！");
        }
        else {

            setBalance(getBalance()-amount);
        }

    }
}
