package 第三章;

import java.util.Scanner;

public class E31 {
    public static void main(String[] args) {
        System.out.println("输入abc的值");
        double a,b,c=0.0;
        Scanner sc=new Scanner(System.in);
        a=sc.nextDouble();
        b=sc.nextDouble();
        c=sc.nextDouble();
        double pbs=b*b-4*a*c;
        double g1=((-b+Math.pow(pbs,0.5))/2*a);
        double g2=((-b-Math.pow(pbs,0.5))/2*a);
        if(pbs>0)
        {
            System.out.println(String.format("%.6f", g1)+" and "+String.format("%.6f", g2));
        }
        else if(pbs==0)
        {
            System.out.println(g1);
        }
        else
        {
            System.out.println("The quation has no real roots");
        }
    }
}
