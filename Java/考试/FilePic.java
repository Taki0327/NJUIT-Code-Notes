import java.io.*;
import java.util.Scanner;
public class FilePic {
    public static void main(String[] args) {
        PicThread pt=new PicThread();
        pt.start();
        System.out.println("是否开始复制图片？");
        Scanner sc=new Scanner(System.in);
        if("1".equals(sc.nextLine()))
        {
            synchronized(pt){
                  pt.notify();
            }
        }
        sc.close();
    }
}
