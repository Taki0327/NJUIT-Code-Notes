

public class Master {
    private String name;
    private double money;
    public Master(String name,double money)
    {
        this.name=name;
        this.money=money;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    public void feed(Pet pet)
    {
        pet.eat();
    }//用父类作为方法getPet的返回值
    public Pet getPet(String typeid) throws Exception
    {
        Pet pet=null;
        if(typeid.equals("1"))
        {
            pet=new Dog2("旺旺",78,87,"雪瑞纳");
        }
        if(typeid.equals("2"))
        {
            pet=new Penguin("小P",79,97,"Q仔");
        }
        return pet;
    }
    public void play(Pet pet)
    {
        if(pet instanceof Dog2)
        {
            Dog2 dog=(Dog2)pet;
            dog.catchingFly();
        }
        else if(pet instanceof Penguin)
        {
            Penguin penguin=(Penguin)pet;
            penguin.swimming();
        }
    }
}
