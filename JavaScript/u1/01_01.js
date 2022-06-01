/*var a=prompt("请输入第一个数字",0);
var b=prompt("请输入第二个数字",0);
var c=parseInt(a)+parseInt(b);
console.log(a);
console.log(a+b,c);*/

var msg="111111122222223333334444444555555555666666666777777888888889999999";
var position=0;
function scroller(){
    var content=msg.substring(position,msg.length)
    +".........."
    +msg.substring(0,position);
    document.getElementById('text1').value=content;
    position++;
    if(position>msg.length){
        position=0;
    }
}
//var a=new BigInt();

var num=10000;
var year=0;
while(num<=50000)
{
    num=num+num*0.05;
    year++;
}
console.log(year);
console.log(num);
