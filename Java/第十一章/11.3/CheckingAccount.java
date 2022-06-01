public class CheckingAccount extends Account2{
    public CheckingAccount (int id,double balance) {
        super(id,balance);
    }
    public void withDraw(double amount) {

        if(getBalance() - amount>-50000)
        {
            setBalance(getBalance()-amount);
        }
        else 
        {
            System.out.println("透支额度不足！");
        }

    }

}
