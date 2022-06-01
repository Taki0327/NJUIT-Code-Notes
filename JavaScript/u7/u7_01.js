window.onload=function(){
    var img=document.getElementById("img");
    var up=document.getElementById("up");
    var but=document.getElementById("but");
    var arr=["../u5/p1.jpg","../u5/p2.jpg","../u5/p3.jpg"];
    var index = 0;
    up.onclick=function(){
        index--;
        if (index < 0) {
            index = arr.length - 1;
        }
        img.src = arr[index];
    }
    but.onclick=function(){
        index++;
        if (index > arr.length - 1) {
            index = 0;
        }
        img.src = arr[index];
    }
}