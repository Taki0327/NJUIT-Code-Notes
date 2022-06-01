public class Staff extends Employee{
    private String Title;

    public String getTitle() {
        return Title;
    }
    public Staff(String Office,double Salary,String Title,String name,String address,String phone, String Email,int year,int month,int day) {
        super(Office,Salary,name,address,phone,Email,year,month,day);
        this.Title = Title;
    }
    public String toStringStaff() {
        return "职员:"+getName()+" 详细信息如下"+"\n"+"姓名:"+getName()+"\n地址:"+getAddress()+"\n电话:"+getPhone()+"\n邮箱地址:"+getEmail()+"\n工资:"+getSalary()+"\n办公室:"+getOffice()+"\n称号:"+getTitle()+"\n受聘时间:"+getEmployeetime()+"\n";
    }
    
}
