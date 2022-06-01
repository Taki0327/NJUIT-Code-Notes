public class ComparableCircle extends Circle implements Comparable<ComparableCircle>{
    public static void main(String args[])
    {
        Circle c1=new ComparableCircle(10);
        Circle c2=new ComparableCircle(2);
        System.out.println("面积"+c1.getArea());
        System.out.println("面积"+c2.getArea());
        System.out.println(c2.compareTo(c1));
    }
    public ComparableCircle(int radius)
    {
        super(radius);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        // TODO Auto-generated method stub
        return 0;
    }
   
}
