import Student from "./Student.js";
var studentlist=[];
function addStu(name,age,sex,id){
    studentlist.push(new Student(name,age,sex,id));
}
function popStu(){
    studentlist.pop();
}
function select(){
    var str="";
    for(var stu in studentlist)
    {
        str+=studentlist[stu].toString()+"<br>";
    }
    return str;
}
export{addStu,select,popStu};
export default {
    University:"njuit",
    Classid:"software2018"
};

