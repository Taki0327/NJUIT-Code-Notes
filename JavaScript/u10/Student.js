export default class Student {
    constructor(name,age,sex,id) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.id = id;
    }
    toString() {
        return `姓名：${this.name} 年龄：${this.age}性别：${this.sex}学号：${this.id}`;
    }
}