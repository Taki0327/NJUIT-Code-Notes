public class Faculty  extends Employee{
    private String OfficeTime;
    private String FacultyGrade;
    public String getOfficeTime() {
        return OfficeTime;
    }

    public String getFacultyGrade() {
        return FacultyGrade;
    }
    public Faculty(String Office,double Salary,String OfficeTime,String FacultyGrade,String name,String address,String phone, String Email,int year,int month,int day) {
        super(Office,Salary,name,address,phone,Email,year,month,day);
        this.OfficeTime = OfficeTime;
        this.FacultyGrade = FacultyGrade;
    }

    
    public String toStringFaculty() {
        return "教员:"+getName()+" 详细信息如下"+"\n"+"姓名:"+getName()+"\n地址:"+getAddress()+"\n电话:"+getPhone()+"\n邮箱地址:"+getEmail()+"\n工资:"+getSalary()+"\n办公室:"+getOffice()+"\n教员级别:"+getFacultyGrade()+"\n办公时间:"+getOfficeTime()+"\n受聘时间:"+getEmployeetime()+"\n";
    }

}
