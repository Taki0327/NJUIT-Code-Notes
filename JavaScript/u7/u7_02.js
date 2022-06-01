window.onload=function(){
    var sub=document.getElementById("submit");
    var txt=document.getElementById("txt");
    sub.onclick=function(){
        if(document.all.size.value!=null)
        {
            txt.style.fontSize=document.all.size.value;
        }
        if(document.all.color!=null)
        {
            txt.style.color=document.all.color.value;
        }
        if(document.all.align!=null)
        {
            txt.style.textAlign=document.getElementsByName("align")[0].value;
        }
    }
}