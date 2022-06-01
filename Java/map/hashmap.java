import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class hashmap {
    public static void main(String[] args) {
        HashMap<String,String> countries=new HashMap<>();
        HashMap<String,String> nations=new HashMap<>();
        countries.put("CN", "中华人民共和国");
        countries.put("RU", "俄罗斯联邦");
        countries.put("US", "美利坚合众国");
        countries.put("FR", "法兰西共和国");
        countries.put("JP", "日本");
        //获取指定元素的值
        System.out.println(countries.get("CN"));
        //取元素个数
        countries.size();
        countries.remove("JP");
        countries.remove("FR", "法兰西共和国");
        countries.containsKey("AUS");
        countries.containsValue("美利坚合众国");
        for(String key:countries.keySet())
        {
            System.out.println(countries.get(key));
        }
        for(int i=0;i<countries.size();i++)
        {
            System.out.println(countries.get(i));
        }
        System.out.println(countries);
        System.out.println(countries.keySet());
        System.out.println(countries.values());
        //使用迭代器输出
        //1.key输出
        Set key=countries.keySet();
        Iterator it= key.iterator();
        while(it.hasNext())
        {
            String keys=(String)it.next();
            System.out.println(countries.get(keys));
        }
    }
}
