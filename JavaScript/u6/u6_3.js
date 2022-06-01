var time=3;
var timer1;
window.onload=function(){
    timer1=window.setInterval(openWin,1000);
}
function openWin()
{
    if(time==0)
    {
        window.clearInterval(timer1);
        location.href='http://www.baidu.com'
    }
    else{
        document.getElementById('text1').innerHTML="倒计时："+time;
        time--;
    }
}

