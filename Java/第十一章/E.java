public class E {
    public static void main(String[] args) {
       AAA a=null;
       System.out.printf("%d：%d",AAA.m,a.m);
    }
  
}
class AAA{
    static int m;
    static{
        m=888;
    }
}
