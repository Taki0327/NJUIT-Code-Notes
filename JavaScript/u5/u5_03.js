class Emploeey{
    constructor(name,sno,year,apart,money)
    {
        this.name=name;
        this.sno=sno;
        this.year=year;
        this.apart=apart;
        this.money=money;
    }
    printInfo(){
        console.log("姓名："+this.name+" 工号："+this.sno+" 年龄："+this.year+" 部门："+this.apart+" 工资："+this.money);
        console.log(this);
    }
}
var e1 = new Emploeey('x',111,21,'2018',1000);;
e1.printInfo();
var e2 = new Emploeey('z',112,20,'2018',2000);;
e2.printInfo();