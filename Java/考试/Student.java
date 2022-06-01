public class Student extends Person {

    public Student (String name, String age) {
        super.setName(name);
        super.setAge(age);
    }
	@Override
	public void Study() {
		System.out.println("姓名："+super.getName()+" 年龄："+super.getAge()+" 学习Java"); 
	}
}
class Studenttest{
    public static void main(String[] args) {
        Person p=new Student("帅哥", "20");
        p.Study();
    }
}