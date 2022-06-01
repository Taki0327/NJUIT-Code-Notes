import java.util.Scanner;

public class Exception2 {
    public static void main(String[] args) {
        try
        {
            Scanner in = new Scanner(System.in);
            System.out.println("请输入课程代号（1~3）:");
            int dh = in.nextInt();
            if(dh==1)
            {
                System.out.println("C#");
            }
            else if(dh==2)
            {
                System.out.println("Java");
            }
            else if(dh==3)
            {
                System.out.println("HtmL");
            }
            else
            {
                throw new Exception();
            }
        }
        catch(Exception e)
        {   
            System.out.println("输入错误");
        }
        finally{
            System.out.println("欢迎提出建议！");
        }
    }
}
