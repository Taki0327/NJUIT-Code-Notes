import java.util.ArrayList;

public class ArrayPenguin {
    public static void main(String[] args) throws Exception {
        Penguin p1=new Penguin("欧欧",90,80,"Q妹");
        Penguin p2=new Penguin("亚亚",98,89,"Q仔");
        Penguin p3=new Penguin("菲菲",87,89,"Q仔");
        Penguin p4=new Penguin("毛毛",78,79,"Q仔");
        ArrayList plist=new ArrayList();
        plist.add(p1);
        plist.add(p2);
        plist.add(p3);
        plist.add(p4);
        System.out.println("一共有多少只？"+plist.size());
        for(int i=0;i<plist.size();i++)
        {
            ((Penguin)plist.get(i)).print();
        }
        //删除指定位置的狗
        Penguin Penguin=(Penguin)plist.remove(1);
        System.out.println("删除了指定位置的元素名字");
        Penguin.print();

        //删除指定的元素的狗
        plist.remove(p3);
        for(int i=0;i<plist.size();i++)
        {
            ((Penguin)plist.get(i)).print();
        }

        if(plist.contains(p1))
        {
            System.out.println("OK");
        }
    }
}
