class Person{
    constructor(name, age) {
        this.name = name;
        this.age = age;
    }
    toString(){
        return "姓名："+this.name+" 年龄："+this.age;
    }
}
class Student extends Person{
    constructor(name, age,major) {
        super(name,age);
        this.name = name;
        this.age = age;
        this.major=major;
    }
    toString(){
        return  super.toString()+" 专业："+this.major;
    }
}
class StudentLeader extends Student{
    constructor(name, age,major,position) {
        super(name,age,major);
        this.name = name;
        this.age = age;
        this.major=major;
        this.position=position;
    }
    toString(){
        
        return super.toString()+" 职位："+this.position;
    }
}
var user=new StudentLeader("xx",20,"软件工程","帅哥");
console.log(user.toString());



Date.prototype.toString=function(){
    return "今天是第"+Math.floor(this.getFullYear()/100+1)+"世纪、"+this.getFullYear().toString().substr(2, 2)+"年份、"+(this.getMonth()+1)+"月、"+this.getDate() +"日";
 }

 var date = new Date();
 console.log(date.toString());