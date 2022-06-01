import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Studenthash<T> {
    public static void main(String[] args) {
        stu x1=new stu(1,"许欣");
        stu x2=new stu(2,"邹翔");
        stu x3=new stu(3,"张方泷");
        Map<String,List<stu>> stumap=new HashMap<>();
        List<stu> s1=new ArrayList<>();
        List<stu> s2=new LinkedList<>();
        s1.add(x1);
        s2.add(x2);
        s1.add(x3);
        stumap.put("普通班", s1);
        stumap.put("强化班", s2);
        ///foreach
        for (String key : stumap.keySet()) {
            for(int i=0;i<stumap.get(key).size();i++)
            {
                System.out.print(key + ",学生：");
                System.out.println(((stu)stumap.get(key).get(i)).toString());
            }
        }
        ///迭代
        Set set=stumap.keySet();
        Iterator<String> it = set.iterator();
		while (it.hasNext()) {
            String n = it.next();
            for(int i=0;i<stumap.get(n).size();i++)
            {
                System.out.print(n + ",学生：");
                System.out.println(((stu)stumap.get(n).get(i)).toString());
            }
        }
    }
}
class stu{
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String toString()
    {
        return "学号："+getId()+" 姓名："+getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public stu(int id, String name) {
        this.id = id;
        this.name = name;
    }

}
