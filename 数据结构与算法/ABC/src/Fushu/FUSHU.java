package Fushu;

public class FUSHU {
	 public static void main(String[] args) {
	        Complex c1=new Complex(1,2);
	        Complex c2=new Complex(3,4);
	        c1.add(c2);
	        System.out.println(c1.toString());
	        c1.sub(c2);
	        System.out.println(c1.toString());
	       }
}
