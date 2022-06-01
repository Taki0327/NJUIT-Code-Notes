var A=[],B=[],D=[];
for(var i=0;i<=500;i++)
{
    if(i%3==0)
    {
        A.push(i);
    }
    if(i%4==0)
    {
        B.push(i);
    }
}
D=D.concat(A,B);
D.sort(function sortNumber(a, b)
{
return b-a;
});
for (i=0; i<D.length-1;)  
{   if (D[i]==D[i+1])
    {
         D.splice(i+1,1)
    }
    else  
    {
          i++; 
    }
}
document.write("A:"+A+"<br>");
document.write("B:"+B+"<br>");
document.write("D:"+D+"<br>");
var arr1=[1,2,3,4,3,5,6,2,7,2];
var arr2=arr1.filter(
    function(num)
    {
        return num!=2;
    }
)
console.log(arr2);

var runnian=function isLeapYear(){
    var rn=document.getElementById('text1').value;
    if((rn%400==0)||(rn%4==0&&rn%100!=0))
    {
        console.log("true");
    }
    else
    {
        console.log("false");
    }
};
runnian();