import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
public class movie {
    public static void main(String[] args) {
        int num=0;
        String name="";
        HashMap<String, Integer> moive=new HashMap<>();
        moive.put("花木兰", 10000);
        moive.put("叶问", 1000);
        moive.put("姜子牙", 20000);
        moive.put("哪吒", 998);
        Set set=moive.keySet();
        Iterator<String> it = set.iterator();
		while (it.hasNext()) {
            String n = it.next();
            if(moive.get(n)>num)
            {
                num= moive.get(n);
                name=n;
            }
			System.out.println("电影："+n + ",下载量：" + moive.get(n));
        }
        System.out.println("下载最多的电影是："+name + ",下载量：" + moive.get(name));
    }
}
