function change(a){
    alert("华氏度："+(32+a*1.8));
}

function button()
{
    change(document.getElementById('text1').value);
}


var cj=function(...num){
    var sum=1;
    num.forEach(function(value){
        sum*=value;
    })
    return sum;
}(1,2,3,4,5);
console.log(cj);

var arr=[1,2,3,4,5];
var arrhd=arr.map((value,index)=>value*value);
console.log(arrhd);


function func1(fn,a,b,c) {
    fn(a,b,c)
}

func1(function () {
    for(var i=0;i<arguments.length;i++)
        document.write(arguments[i]);
},3,2,1)