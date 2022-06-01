public class Person {
    private String name;
    private String address;
    private String phone;
    private String email;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Person(String name,String address,String phone,String email)
    {
        this.name=name;
        this.address=address;
        this.phone=phone;
        this.email=email;
    }
    
    public String toStringPerson() {
        return "姓名:"+getName()+" 详细信息如下"+"\n"+"名字:"+getName()+"\n"+"地址:"+getAddress()+"\n"+"电话:"+getPhone()+"\n"+"邮箱地址:"+getEmail()+"\n";
    }
}
