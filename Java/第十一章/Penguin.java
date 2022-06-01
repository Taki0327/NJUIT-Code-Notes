public class Penguin extends Pet{

    public Penguin(String name,  int health,int love,String sex) throws Exception {
        super(name);
        super.health=health;
        super.love=love;
        if(sex.equals("Q妹")||sex.equals("Q仔"))
        {
            this.sex=sex;
        }
        else
        {
            throw new Exception("性别错误");
        }
        // TODO Auto-generated constructor stub
    }
    String sex = "Q仔"; // 性别
    /**
     * 输出企鹅的信息。
     */
    public void eat()
    {
        super.health+=3;
    }
    public void print() {
        System.out.println("宠物的自白：\n我的名字叫" + this.name +
                "，健康值是"	+ this.health + "，和主人的亲密度是"
                + this.love + "，性别是 " + this.sex + "。");
    }
    public void swimming()
    {
        super.health-=10;
        super.love+=5;
    }
}
