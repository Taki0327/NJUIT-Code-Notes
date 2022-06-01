var stu=[[50,60,70,80],[99,100,70,80],[66,77,88,99]];
var sum,xs=1;
for(var i in stu)
{
    sum=0;
    for(var j in stu[i])
    {
        sum=sum+stu[i][j];
    }
    document.write('第'+(xs++)+'位学生平均分为：'+sum/stu[i].length+"<br>");
}

/*var y=0;
var sum=0;
var i=0;
while(y<stu[].length)
{
    for(;i<stu.length;i++){
        sum=sum+stu[i][y];
        console.log(stu[i][y]);
    }
    y++;
    i=0;
    console.log('平均分为：'+sum/stu.length);
    sum=0;
}*/
function button()
{
    document.write(jc(document.getElementById('text1').value));
}
function jc(num)
{
    if(num<=1)
    {
        return 1;
    }
    else
    {
        return num*jc(num-1);
    }
}