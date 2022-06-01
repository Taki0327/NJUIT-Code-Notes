var wz;
window.onload=function(){
     wz=document.getElementById("wz");
    document.getElementById("btn01").onclick = function () {
        if(wz.classList.contains("bg2")){
            wz.classList.replace("bg2","bg");
        }else{
            wz.classList.add("bg");
        }
    };
    document.getElementById("btn02").onclick = function () {
        if(wz.classList.contains("bg")){
            wz.classList.replace("bg","bg2");
        }else{
            wz.classList.add("bg2");
        }
    };
    wz.onclick=function(){
        if(wz.classList.contains("bg2")){
            wz.classList.replace("bg2","bg");
        }else{
            wz.classList.replace("bg","bg2");
        }
    }
}


