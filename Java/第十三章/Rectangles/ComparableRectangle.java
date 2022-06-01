import java.util.Arrays;

public class ComparableRectangle extends Rectangle implements Comparable<ComparableRectangle>{
    public static void main(String args[])
    {
        Rectangle r1=new Rectangle(5,4);
        System.out.println("面积"+r1.getArea());
        new ComparableRectangle(4,5);
        
    }
    public ComparableRectangle(int weight,int height)
    {
        super(weight,height);
    }
    public int compareTo(ComparableRectangle o)
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
        return "宽度："+getWeight()+"长度："+getHeight()+"面积:"+getArea()+"周长:"+getCicle();
    }
}
class Rectangle
{
    public Rectangle(int weight,int height)
    {
        this.weight=weight;
        this.height=height;
    }
    private int weight;
    private int height;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public int getArea()
    {
        return height*weight;
    }
    public int getCicle()
    {
        return (height+weight)*2;
    }
    public String toString()
    {
        return "宽度："+getWeight()+"长度："+getHeight()+"面积:"+getArea()+"周长:"+getCicle();
    }
}
