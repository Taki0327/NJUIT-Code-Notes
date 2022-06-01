public class Student extends Person{
    public static final String First = "大一";
    public static final String Second = "大二";
    public static final String Third = "大三";
    public static final String Fourth = "大四";
    private String status;
    public Student(String name, String address, String phone, String email,String status) {
        super(name, address, phone, email);
        this.status=status;
    }
    public String getStudentState() {
        return status;
    }
    public String toStringStudent() {
        return "学生:"+getName()+" 详细信息如下"+"\n"+"名字:"+getName()+"\n"+"地址:"+getAddress()+"\n"+"电话:"+getPhone()+"\n"+"邮箱地址:"+getEmail()+"\n"+"年级:"+getStudentState()+"\n";
    }

}
