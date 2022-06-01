import java.text.SimpleDateFormat;
import java.util.Date;

public class E97 {
    public static void main(String[] args) {
        Account user= new Account(1122,20000);
        user.setAnnuallnterestRate(4.5);
        user.withDraw(2500);
        user.deposit(3000);
        System.out.println("账户余额为："+user.getBalance()+" 月利息："+user.getMonthlyInterest()+" 账户的开户日期:"+user.getDateCreated());
    }
}
class Account{
    private int id=0;
    private double balance=0;
    private double annuallnterestRate =0;
    private Date dateCreated;
    public Account(){
    };
    public Account(int id,double balance){
        this.id=id;
        this.balance=balance;
        dateCreated=new Date();
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnuallnterestRate() {
        return annuallnterestRate;
    }

    public void setAnnuallnterestRate(double annuallnterestRate) {
        this.annuallnterestRate = annuallnterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
    public double getMonthlyInterest()
    {
        return balance*getMonthlyInterestRate();
    }
    public double getMonthlyInterestRate()
    {
        return (annuallnterestRate/100/12);
    }
    public void withDraw(double money)
    {
        balance=balance-money;
    }
    public void  deposit(double money)
    {
        balance=balance+money;
    }
}