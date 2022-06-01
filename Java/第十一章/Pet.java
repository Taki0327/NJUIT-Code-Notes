import java.sql.Struct;

public abstract class Pet {
    String name = "无名氏"; // 昵称
    int health = 100; // 健康值
    int love = 0; // 亲密度
    public Pet(String name)
    {
        this.name=name;
    }
    public abstract void eat();
    public abstract void print();
}
