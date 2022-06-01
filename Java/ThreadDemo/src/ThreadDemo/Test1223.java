package ThreadDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1223 {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("courseName", "面向对象高级程序设计");
        Teacher t1 = new Teacher("001", "杨经理");
        map.put("teacher", t1);
        List<Student> lists = new ArrayList<>();
        Student s1 = new Student("01", "ZX");
        Student s2 = new Student("02", "XX");
        Student s3 = new Student("03", "ZFL");
        lists.add(s1);
        lists.add(s2);
        lists.add(s3);
        map.put("studentList", lists);
        try {
            PrintStream ps = new PrintStream(new FileOutputStream("D:/啧啧啧.txt", true));
            for(String key:map.keySet())
            {
                if(key=="courseName")
                {
                    System.out.println("课程名称："+map.get(key));
                    ps.println("课程名称："+map.get(key));
                }
                if(key=="teacher")
                {
                    System.out.println("教师："+((Teacher)map.get(key)).getName());
                    ps.println("教师："+((Teacher)map.get(key)).getName());
                }
                if(key=="studentList")
                {
                    for(Student stu:(List<Student>)map.get(key))
                    {
                        System.out.println("学生姓名："+stu.getName());
                        ps.println("学生姓名："+stu.getName());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }
}
class Student{
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
class Teacher{
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher(String id, String name) {
        this.id = id;
        this.name = name;
    }
}