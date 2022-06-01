import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListEE {
    public static void main(String[] args) {
        Dog dog1=new Dog("欢欢",90,80,"雪纳瑞");
        Dog dog2=new Dog("进宝",98,89,"哈士奇");
        Dog dog3=new Dog("旺旺",87,89,"金毛");
        Dog dog4=new Dog("毛毛",78,79,"泰迪");
        //ArrayList<Dog> dogList=new ArrayList<>();
        LinkedList<Dog> dogList=new LinkedList<>();
        dogList.add(dog1);
        dogList.add(dog2);
        //dogList.add(dog3);
        //dogList.add(dog4);
        dogList.addFirst(dog3);
        dogList.addLast(dog4);
        for(Dog dog:dogList)
        {
            System.out.println(dog);
        }
        System.out.println("一共有多少条？"+dogList.size());
        for(int i=0;i<dogList.size();i++)
        {
            System.out.println(((Dog)dogList.get(i)).toString());
        }
        //删除指定位置的狗
        Dog dog=(Dog)dogList.remove(1);
        System.out.println("删除了指定位置的元素名字"+dog.toString());

        //删除指定的元素的狗
        dogList.remove(dog4);
        for(int i=0;i<dogList.size();i++)
        {
            System.out.println(((Dog)dogList.get(i)).toString());
        }

        if(dogList.contains(dog3))
        {
            System.out.println("OK");
        }
    }
}
