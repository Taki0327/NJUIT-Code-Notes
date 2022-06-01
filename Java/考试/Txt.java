import java.io.FileWriter;
import java.util.Scanner;
import java.io.*;

public class Txt {
    public static void main(String[] args) {
        try {
        System.out.println("请输入要写入的内容：");
        Scanner sc=new Scanner(System.in);
        String txt=sc.nextLine();
       FileWriter fw= new FileWriter("D:/啧啧啧.txt", true);
        fw.flush();
        fw.close();
        fw.write(txt);
        PrintStream ps = new PrintStream(new FileOutputStream("D:/啧啧啧.txt", true));
        ps.println(txt);
        System.out.println("写入成功！");
        sc.close();
      
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
