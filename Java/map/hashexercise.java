import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class hashexercise {
    public static void main(String[] args) {
        HashMap<String,String> teacher=new HashMap<>();
        teacher.put("Tom", "Corejava");
        teacher.put("John", "Oracle");
        teacher.put("Susan", "Oracle");
        teacher.put("Jerry", "JDBC");
        teacher.put("Jim", "Unix");
        teacher.put("Kevin", "JSP");
        teacher.put("Lucy", "JSP");
        //修改更新
        teacher.put("Allen", "JDBC");
        teacher.put("Lucy", "CoreJava");
        
        Set set=teacher.keySet();
        Iterator<String> it2 = set.iterator();
		while (it2.hasNext()) {
			String n2 = it2.next();
			System.out.println("老师："+n2 + ",课程：" + teacher.get(n2));
        }
        Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String n = it.next();
			if (teacher.get(n).equals("JSP")) {
				System.out.println(n);
			}
		}
    }
}
