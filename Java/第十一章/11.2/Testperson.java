public class Testperson {
    public static void main(String[] args) {
        Person a = new Person("张三","常州","1852342","22222222@qq。com");

        System.out.println(a.toStringPerson());
        Student a1 = new Student("zx","南京","18523342","23232143@qq。com","大三");

        System.out.println(a1.toStringStudent());
        Employee a2 = new Employee("南京大学",4000,"xx","南京","1852232342","13232232@qq。com",2000,8,29);

        System.out.println(a2.toStringEmployee());
        Faculty a3 = new Faculty("南京大学",6000,"9:00~21:00","博士","董凯","南京","1852342","1232@qq。com",2000,3,1);

        System.out.println(a3.toStringFaculty());
        Staff a4 = new Staff("东南大学",12000,"副教授","董凯","南京","1852342","1232@qq。com",2000,10,1);

        System.out.println(a4.toStringStaff()); 
    }
}
