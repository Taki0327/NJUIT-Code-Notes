import java.util.HashMap;
import java.util.Scanner;

public class hash11 {
    public static void main(String[] args) {
        HashMap<String, String> map=new HashMap<>();
        map.put("1930年", "乌拉圭");
        map.put("1934年", "意大利");
        map.put("1938年", "意大利");
        map.put("1950年", "乌拉圭");
        map.put("1954年", "西德");
        map.put("1958年", "巴西");
        map.put("1962年", "巴西");
        map.put("1966年", "英格兰");
        map.put("1970年", "巴西");
        map.put("1974年", "西德");
        map.put("1978年", "阿根廷");
        map.put("1982年", "意大利");
        map.put("1986年", "阿根廷");
        map.put("1990年", "西德");
        map.put("1994年", "巴西");
        map.put("1998年", "法国");
        map.put("2002年", "巴西");
        map.put("2006年", "意大利");
        map.put("2012年", "西班牙");
        map.put("2016年", "德国");
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一个年份：");
        String str=sc.nextLine();
        if(map.containsKey(str)==false)
        {
            System.out.println("该年没有举办世界杯！");
        }
        else
        {
            System.out.println("该年的世界杯冠军是："+map.get(str));
        }
    }
}
