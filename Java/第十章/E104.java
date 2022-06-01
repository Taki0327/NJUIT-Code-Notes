public class E104 {
    public static void main(String[] args) {
        MyPoint t1=new MyPoint();
        MyPoint t2=new MyPoint(10,30.5);
        System.out.println(t1.distance(t2));
        System.out.println(t1.distance(10,30.5));
    }
}
class MyPoint{
    private double x;
    private double y;
    public double getX()
    {
        return this.x;
    }

    public double getY()
    {
        return this.y;
    }
    public MyPoint()
    {
        this.x=0;
        this.y=0;
    }
    public MyPoint(double x,double y)
    {
        this.x=x;
        this.y=y;
    }
    public double distance(MyPoint my)
    {
        return Math.sqrt((x-my.getX())*(x-my.getX())+(y-my.getY())*(y-my.getY()));
    }
    public double distance(double x,double y)
    {
        return Math.sqrt((this.x-x)*(this.x-x)+(this.y-y)*(this.y-y));
    }
}