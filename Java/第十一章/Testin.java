import java.util.*;
public class Testin {
    public static void main(String[] args) throws Exception {
        /*Pet dog=new Dog2("欢欢","拉布拉多");
        dog.toString();
        Master master=new Master("小王", 100);
        master.feed(dog);
        dog.print();
        Pet penguin=new Penguin("小Q",90,89,"Q妹");
        master.feed(penguin);
        penguin.print();*/
        Scanner sc=new Scanner(System.in);
        Master master=new Master("小李", 1000);
        System.out.println("欢迎您来到宠物店，请选择领养宠物的类型");
        String typeid=sc.next();
        Pet pet=master.getPet(typeid);
        master.feed(pet);
        master.play(pet);
    }
}
