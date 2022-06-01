var student = {
    name:'abc',
    sno:1234,
    year:20,
    classid:'2018',
    printInfo: function(){
        console.log(this.name);
        console.log(this.sno);
        console.log(this.year);
        console.log(this.classid);
    }
};
console.log(student);
student.printInfo();


function createstudent(name,sno,year,classid)
{
    var obj = new Object();
    obj.name=name;
    obj.sno=sno;
    obj.year=year;
    obj.classid=classid;
    obj.printInfo=function(){
        console.log("姓名："+this.name+"学号："+this.sno+"年龄："+this.year+"班级："+this.classid);
        console.log(obj);
    }
    return obj;
}
var s1= createstudent('x',1,21,'2018');
s1.printInfo();
var s2= createstudent('z1',2,20,'2018');
s2.printInfo();
var s3= createstudent('z2',3,20,'2018');
s3.printInfo();



function Student(name,sno,year,classid)
{
    this.name=name;
    this.sno=sno;
    this.year=year;
    this.classid=classid;
    this.printInfo=function(){
        console.log("姓名："+this.name+"学号："+this.sno+"年龄："+this.year+"班级："+this.classid);
        console.log(this);
    }
}
var s1=new Student('x',1,21,'2018');
s1.printInfo();
var s2=new Student('z1',2,20,'2018');
s2.printInfo();
var s3=new Student('z2',3,20,'2018');
s3.printInfo();