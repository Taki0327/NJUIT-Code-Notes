package 第三章;
import java.util.*;
public class E34 {
    public static void main(String[] args) {
        int sj=(int)(1+Math.random()*12);
        String yf="";
        switch(sj){
            case 1:yf="January"; ;break;
            case 2: yf="February";break;
            case 3:yf="March" ;break;
            case 4:yf="April" ;break;
            case 5:yf="May" ;break;
            case 6:yf="June" ;break;
            case 7:yf="July" ;break;
            case 8:yf="August" ;break;
            case 9:yf="September" ;break;
            case 10:yf="October" ;break;
            case 11:yf="November" ;break;
            case 12: yf="December";break;
        }
        System.out.println(yf);
    }
}