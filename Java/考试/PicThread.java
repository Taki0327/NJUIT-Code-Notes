import java.io.FileInputStream;
import java.io.*;

public class PicThread extends Thread {
    public void run()
    {
        try {
            synchronized(this){
                this.wait();
            }
            FZ();
        } 
        catch (InterruptedException e) {
        }
    }
    public synchronized void FZ()
    {
        String filename1 = "D:/1.jpg";
        String filename2 = "E:/1.jpg";
        try{
            FileInputStream fis=new FileInputStream(filename1);
            FileOutputStream fos=new FileOutputStream(filename2);
            byte[] words = new byte[1024];
            int count=0;
            while ((count=fis.read(words))!= -1) {
                fos.write(words, 0, words.length);;
            }
            System.out.println("复制完成");
            fos.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
