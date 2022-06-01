import java.util.Date;
public class Employee extends Person{
    private String Office;
    private double Salary;
    private Date Employeetime;
    public Employee(String Office,double Salary,String name, String address, String phone, String email,int year,int month,int day) {
        super(name, address, phone, email);
        this.Office=Office;
        this.Salary=Salary;
        this.Employeetime = new Date(year-1900,month-1,day);
    }
    public String getOffice() {
        return Office;
    }

    public double getSalary() {
        return Salary;
    }

    public Date getEmployeetime() {
        return Employeetime;
    }
    public String toStringEmployee() {
        return "雇员:"+getName()+" 详细信息如下"+"\n"+"姓名:"+getName()+"\n地址:"+getAddress()+"\n电话:"+getPhone()+"\n邮箱地址:"+getEmail()+"\n工资:"+getSalary()+"\n办公室:"+getOffice()+"\n受聘时间:"+getEmployeetime()+"\n";
    }
}
