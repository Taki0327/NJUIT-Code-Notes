
public class Circle {
    private double radius;
    public double getArea(){
        return Math.PI*radius*radius;
    }
    public double getPerimeter(){
        return 2*Math.PI*radius;
    }
    public Circle(double radius)
    {
        this.radius=radius;
    }
    public int compareTo(Circle o)
    {
        if(this.getArea()>o.getArea())
            return 1;
        else if(this.getArea()<o.getArea())
            return -1;
        else
            return 0;
    }
    public String toString()
    {
        return "面积："+getArea()+"周长："+getPerimeter();
    }
}
class test
{
    public static void main(String[] args) {
        int i;
        Circle c1=new Circle(3);
        Circle c2=new Circle(2);
        System.out.println("c1的面积和周长分别是"+c1.getArea()+" "+c1.getPerimeter());
        System.out.println("c2的面积和周长分别是"+c2.getArea()+" "+c2.getPerimeter());
    }
}