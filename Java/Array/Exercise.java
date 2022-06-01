import java.util.ArrayList;
import java.util.Date;

public class Exercise {
    public static void main(String[] args) {
        Circle c1=new Circle(3);
        Rectangle r1=new Rectangle(5,4);
        Date d1=new Date();
        ArrayList list=new ArrayList();
        list.add(c1);
        list.add(r1);
        list.add(d1);
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i).toString());
        }
    }
}
