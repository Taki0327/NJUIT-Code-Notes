public class theftproofDoor extends Door implements Lock {

    public  void lockup(){
        System.out.println("插入钥匙，向左转三圈，拔出钥匙");
    }
    public void openlock(){
        System.out.println("插入钥匙，向右转三圈，拔出钥匙");
    }
}
class Door{
    public  void open(){
        System.out.println("门开了");

    }
    public  void close(){
        System.out.println("门关上了");
    }
    public  static void main(String [] args){
        theftproofDoor a=new theftproofDoor();
        System.out.println("上课去");
        a.close();
        a.lockup();
        System.out.println("下课了");
        a.openlock();
        a.open();
    }
}

interface  Lock{
    public  abstract  void lockup();
    public  abstract  void openlock();
}
