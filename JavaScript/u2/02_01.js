function YEAR(){
    var rn=document.getElementById('text1').value;
    if((rn%400==0)||(rn%4==0&&rn%100!=0))
    {
        console.log("是闰年");
    }
    else
    {
        console.log("不是闰年");
    }
}

var num=10000;
var year=0;
while(num<=50000)
{
    num=num+num*0.05;
    year++;
}
console.log(year);
console.log(num);

var ss=true;
for(var i=2;i<=100;i++)
{
    for(var j=2;j<i;j++)
    {
        if(i%j==0)
        {
           ss=false;
           break;
        }
        ss=true;
    }
    if(ss==true)
    {
        document.write(i+" ");
    }

}

var str="哈喽";
function robot(){
    while(true)
    {
        var r1 = prompt(str);
        if(r1)
        {
            console.log(r1);
            str=r1;
        }
        else
        {
            break;
        }
    }
}