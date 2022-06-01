import java.util.Scanner;
public class Exception1 {
    public static void main(String[] args) {
        try
        {
            Scanner in = new Scanner(System.in);
            System.out.print("请输入被除数:");
            int num1 = in.nextInt();
            System.out.print("请输入除数:");
            int num2 = in.nextInt();
            System.out.println(String.format("%d / %d = %d",num1, num2, num1 / num2));
            System.out.println("感谢使用本程序！");
        }
        catch(ArithmeticException e)
        {
            e.printStackTrace();
            System.out.println("除数不能为0");
        }
        catch(Exception e)
        {

        }
    }
}
