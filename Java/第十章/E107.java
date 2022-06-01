import java.util.Scanner;
public class E107{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你的账户：");
        int user=sc.nextInt();
        ATM test=new ATM();
        if(test.login(user)==true)
        {
            int xz=888;
            while(xz!=4)
            {
                meun();
                Account2 u1 = new Account2(user, 100);
                xz= sc.nextInt();
                if (xz == 1) {
                    System.out.println("账户余额为：" + u1.getBalance());
                } else if (xz == 2) {
                    System.out.println("请输入取钱的数目：");
                    u1.withDraw(sc.nextInt());
                    System.out.println("账户余额为：" + u1.getBalance());
                } else if (xz == 3) {
                    System.out.println("请输入存钱的数目：");
                    u1.deposit(sc.nextInt());
                    System.out.println("账户余额为：" + u1.getBalance());
                } else if (xz == 4) {
                    test = null;
                    main(args);
                    System.out.println("退出成功！");
                }
            }
        } else {
            test = null;
            main(args);
        }
    }

    public static void meun()
    {
        System.out.println("主菜单");
        System.out.println("1：查看当前收支：");
        System.out.println("2：取钱");
        System.out.println("3：存钱");
        System.out.println("4：退出主菜单");
    }
}
class ATM
{
    int []id={0,1,2,3,4,5,6,7,8,9};
    public boolean login(int user)
    {
        for(int i=0;i<id.length;i++)
        {
            if(user==i)
            {
                return true;
            }
        }
        System.out.println("账户不存在 请重新输入");
        return false;
    }
}
