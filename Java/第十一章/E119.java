public class E119
{
    public static void main(String args[]) {
        CPU c1 = new CPU();
        c1.setSpeed(2200);
        HardDisk disk =new HardDisk();
        disk.setAmount(200);
        PC pc=new PC();
        pc.setCPU(c1);
        pc.setHardDisk(disk);
        pc.show();
    }
}
class CPU {
    int speed;
    int getSpeed(){
        return speed;
    }
    public void setSpeed(int m){
        this.speed=m;
    }

}
class HardDisk {
    int amount;
    int getAmount(){
        return amount;
    }
    public void setAmount(int m){
        this.amount=m;
    }

}
class PC {
    CPU cpu;
    HardDisk HD;


    void setCPU(CPU c) {
        this.cpu = c;
    }

    void setHardDisk(HardDisk h) {
        this.HD = h;
    }
    void show(){
        System.out.println("CPU速度"+cpu.getSpeed());
        System.out.println("硬盘容量"+HD.getAmount());
    }
}
