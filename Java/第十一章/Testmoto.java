import java.util.*;
public class Testmoto {
    public static void main(String[] args) {		
		String no,brand,mtype,type;			
		int seatCount,days,rent=0;
		MotoVehicle[] motos = new MotoVehicle[4];
		motos[0] = new Car("宝马550i","京NY28588");
		motos[1] = new Car("宝马550i","京NNN328");
		motos[2] = new Car("别克林荫大道","京NY28588");
		motos[3] = new Bus("金龙",34);
		System.out.println("租金一共是："+calcTotalRent(motos,5));

		Scanner input = new Scanner(System.in);		
		System.out.println("欢迎您来到汽车租赁公司！");
		System.out.print("请输入要租赁的天数：");
		days=input.nextInt();	
		System.out.print("请输入要租赁的汽车类型（1：轿车      2、客车）:");
		mtype = input.next();		
        if("1".equals(mtype))
        {
			System.out.print("请输入要租赁的汽车品牌（1、宝马    2、别克）:");
			brand=input.next();
			System.out.print("请输入轿车的型号");
            if("1".equals(brand))
            {
                System.out.print("1、550i：");
            }
            else
            {
				System.out.print("2、商务舱GL8  3、林荫大道");
            }
			type=input.next();
			no="京BK5543";//简单起见，直接指定汽车牌号
			System.out.println("分配给您的汽车牌号是:"+no);
			Car car =new Car(no,brand,type);
			rent=car.CalcRent(days);
		}
		else if("2".equals(mtype)){
			System.out.print("请输入要租赁的客车品牌（1、金杯 2、金龙）:");
			brand=input.next();
			System.out.print("请输入客车的座位数:");
			seatCount=input.nextInt();
			no="京AU8769";//简单起见，直接指定汽车牌号
			System.out.println("分配给您的汽车牌号是:"+no);
			Bus bus=new Bus(no,brand,seatCount);
			rent=bus.CalcRent(days);
		}		
		System.out.println("顾客您好！您需要支付的租赁费用是"+rent);
	}
	public static int calcTotalRent(MotoVehicle[] motos,int days){
		int totalRent = 0; 
		for(int i=0;i<motos.length;++i){
			 totalRent += motos[i].CalcRent(days);
		} 
		return totalRent;
	}
 
}
