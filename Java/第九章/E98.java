

public class E98 {
    public static void main(String[] args) {
        Fan f1=new Fan();
        f1.setSpeed(3);
        f1.setRadius(10);
        f1.setColor("yellow");
        f1.setOn(true);
        Fan f2=new Fan();
        f2.setSpeed(2);
        f2.setRadius(5);
        f2.setColor("blue");
        f2.setOn(false);
        System.out.println(f1.toString());
        System.out.println(f2.toString());
    }
    
}
class Fan{
    private static final int SLOW=1;
    private static final int MEDIUM=2;
    private static final int FAST=3;
    private int speed=SLOW;
    private boolean on=false;
    private double radius=5;
    public String color="blue";
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public Fan(){};
    public String toString(){
        if(isOn()==true)
        {
            return "风扇的速度："+getSpeed()+" 风扇的颜色："+getColor()+" 风扇的半径："+getRadius();
        }
        else
        {
            return "fan is off "+getColor()+" "+getRadius();
        }
    }
}