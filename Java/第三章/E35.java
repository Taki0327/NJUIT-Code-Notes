package 第三章;
import java.util.Scanner;
public class E35 {
    public static void main(String[] args) {
        System.out.println("输入今天是周几的数字：");
        Scanner sc=new Scanner(System.in);
        int day=sc.nextInt();
        System.out.println("输入未来是周几的数字：");
        int fday=sc.nextInt();
        String xqj="0";
        switch(day){
            case 1:xqj="星期一"; ;break;
            case 2:xqj="星期二";break;
            case 3:xqj="星期三";break;
            case 4:xqj="星期四";break;
            case 5:xqj="星期五";break;
            case 6:xqj="星期六";break;
            case 0:xqj="星期七" ;break;
        }
        System.out.println("今天是"+xqj);
        switch(fday){
            case 1:xqj="星期一"; ;break;
            case 2:xqj="星期二";break;
            case 3:xqj="星期三";break;
            case 4:xqj="星期四";break;
            case 5:xqj="星期五";break;
            case 6:xqj="星期六";break;
            case 0:xqj="星期七" ;break;
        }
        System.out.println("今天是"+xqj);
    }
}