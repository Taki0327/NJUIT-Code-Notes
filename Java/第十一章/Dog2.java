
public class Dog2 extends Pet{
    //品种
    String strain="拉布拉多";
    public Dog2(String name, String strain)
    {
        super(name);
        this.strain=strain;
    }
    public Dog2(String name, int health , int love,String strain)
    {
        super(name);
        super.health=health;
        super.love=love;
        this.strain=strain;
    }
    public String getStrain() {
        return strain;
    }

    public void setStrain(final String strain) {
        this.strain = strain;
    }

    public String toString(){
        super.toString();
        return "狗的名字是： "+name+" 狗的健康度为"+health+" 狗的亲密度为"+love+" 狗的品种是："+strain;
    }
    @Override
    public void eat()
    {
        super.health+=3;
    }
    public void print()
    {
        System.out.println("狗的名字是： "+super.name+" 狗的健康度为"+super.health+" 狗的亲密度为"+super.love+" 狗的品种是："+strain);
    }
    public void catchingFly()
    {
        super.health-=10;
        super.love+=5;
    }
}