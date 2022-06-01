/*var score=[];
var scoreid=0;
var str="小明:87;小花:81;小红:97;小天:76;小张:74;小小:94;小西:90;小伍:76;小迪:64;小曼:76";
var result=str.split(';').toString();
result=result.split(':').toString();
result=result.split(/[\u4e00-\u9fa5]+[\u4e00-\u9fa5]/g).toString();
result=result.split(',');
for(var i in result)
{
   if(result[i]!="")
   {
       score[scoreid]=result[i];
       scoreid++;
   }
}
console.log(score);*/


var score=[];
var str="小明:87;小花:81;小红:97;小天:76;小张:74;小小:94;小西:90;小伍:76;小迪:64;小曼:76";
var result=str.split(';');
var sum=0;
for(var i in result)
{
    sum=sum+parseInt(result[i].substring(3));
}
console.log(sum/10);



var imagelist=new Array;
imagelist[0]="p1.jpg";
imagelist[1]="p2.jpg";
imagelist[2]="p3.jpg";
imagelist[3]="p4.jpg";
var int=self.setInterval("test()",2000);
function test()
{
    var imagechoice=Math.floor(Math.random()*imagelist.length);
    document.write('<img src="'+imagelist[imagechoice]+'">');
}