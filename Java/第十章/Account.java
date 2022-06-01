import java.util.Date;
public class Account {
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