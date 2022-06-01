var myWin = null;
var timer=null;
var timer2 = null;
function openWin(){
    myWin= window.open("u6.html","newWin","width=200,height=0,scollbars=no");
    myWin.moveBy(screen.availWidth,screen.availHeight);
    //myWin.focus();
    timer = setTimeout(closewin,10000);
    timer2=window.setInterval(showwin,10);
    console.log(myWin);
}
function closewin(){
    if(!myWin.closed) {
        myWin.close();
    }
    window.clearInterval(timer2);
    alert('广告关闭了！');
}
function showwin(){
    myWin.moveBy(0,-1);
}