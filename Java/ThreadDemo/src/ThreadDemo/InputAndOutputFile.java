package ThreadDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InputAndOutputFile {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            // 1.创建输入流，负责读取文件
            fis = new FileInputStream("D:/test/123.txt");
            // 2.创建输出流，负责写入文件
            fos = new FileOutputStream("D:/啧啧啧.txt", true);
            // 3.创建一个中转站数组，存放每次读取的内容。
            byte[] words = new byte[1024];
            // 4.循环读写
            while (fis.read() != -1) {
                fis.read(words);
                fos.write(words, 0, words.length);;
            }
            System.out.println("复制完成");
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
