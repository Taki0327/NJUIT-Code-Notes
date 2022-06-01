var weight,dw;
var result="";
function cou(){
    weight=document.getElementById("sz").value;
    dw=document.getElementById("sc").value;
}
function Pounds(){
    if(dw=="kg")
    {
        result=weight*2.20462262;
    }
    else if(dw=="yb")
    {
        result=weight*0.45359237;
    }
    return result;
}
export {Pounds,cou};