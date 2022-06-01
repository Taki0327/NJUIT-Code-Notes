package 第三章;

import java.util.Scanner;

public class E317 {
    public static void main(String[] args) {
        System.out.println("输入石头（0）剪刀（1）布（2）：");
        Scanner sc=new Scanner(System.in);
        int sr=sc.nextInt();
        if(sr>2||sr<0)
        {
            System.out.println("你输错了！");
        }
        else
        {
        int cpu=(int)(0+Math.random()*2);
        String jg="";
        String str="";
        if(cpu==sr){
            jg="平局";
        }
        else
        {
            switch(sr){
                case 0: if(cpu==1){
                    jg="你赢了";
                }
                else
                {
                    jg="你输了";
                };break;
                case 1:if(cpu==2){
                    jg="你赢了";
                }
                else
                {
                    jg="你输了";
                };break;
                case 2:if(cpu==0){
                    jg="你赢了";
                }
                else
                {
                    jg="你输了";
                };break;
            }
        }
        if(cpu==0){
            str="电脑出的是石头 "+jg;
        }
        else if(cpu==1){
            str="电脑出的是剪刀 "+jg;
        }
        else if(cpu==2){
            str="电脑出的是布 "+jg;
        }
        System.out.println(str);
        }
    }
}