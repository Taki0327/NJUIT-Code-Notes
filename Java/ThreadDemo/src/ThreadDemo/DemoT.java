package ThreadDemo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public class DemoT implements Runnable {
    public static void main(String[] args) {
        new Thread(new DemoT()).start();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        //SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  //8以前
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");//日期
        while (true) {
            try {
                Thread.sleep(1000);
                LocalDateTime now=LocalDateTime.now();
                System.out.println(dtf.format(now));
                /*if(now.isAfter(2012, 6, 30, 12, 00))
                {
                    break;
                }*/
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            //System.out.println(sdf.format(new Date()));
        }
    }
}
