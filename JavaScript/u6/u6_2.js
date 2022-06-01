var arr=["p1.jpg","p2.jpg","p3.jpg"];
var i=0;
function change()
{
    i++;
    i=i%arr.length;
    document.getElementById('Link').search=arr[i];
}

function change2()
{
    i++;
    i=i%arr.length;
    document.getElementById('Link').search=arr[i];
    document.getElementById('img').src="../u5/"+arr[i];
}
