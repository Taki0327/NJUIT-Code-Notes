public class Edog {
    public static void main(final String[] args) {
        final Dog d1=new Dog();
        d1.setName("zx");
        d1.setHealth(100);
        d1.setLove(50);
        d1.setStrain("中华田园犬");
        System.out.println(d1.toString());
    }
}
class Dog {
    private String name;
    private int health;
    private int love;
    //品种
    private String strain;
    public Dog(){};
    public Dog(final String name,final int health,final int love,final String strain)
    {
        this.name=name;
        this.health=health;
        this.love=love;
        this.strain=strain;
    }
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(final int health) {
        this.health = health;
    }

    public int getLove() {
        return love;
    }

    public void setLove(final int love) {
        this.love = love;
    }

    public String getStrain() {
        return strain;
    }

    public void setStrain(final String strain) {
        this.strain = strain;
    }

    public String toString(){
        return "狗的名字是： "+name+" 狗的健康度为"+health+" 狗的亲密度为"+love+" 狗的品种是："+strain;
    }
}