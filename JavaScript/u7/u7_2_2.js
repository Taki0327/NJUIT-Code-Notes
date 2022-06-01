var table,id=0,tbodytr;
window.onload=function(){
    table = document.createElement("table");
    table.setAttribute("width",400);
    table.setAttribute("border",1);
    document.body.appendChild(table);
    tbodytr = table.insertRow(id) ;
    tbodytr.insertCell(0).innerHTML ="姓名";
    tbodytr.insertCell(1).innerHTML = "学号";
    tbodytr.insertCell(2).innerHTML = "分数";
    tbodytr.insertCell(3).innerHTML = "";
    document.getElementById("submit").onclick=function ()
    {
        tbodytr=table.insertRow(table.rows.length);
        tbodytr.insertCell(0).innerHTML=document.getElementById("name").value;
        tbodytr.insertCell(1).innerHTML=document.getElementById("xh").value;
        tbodytr.insertCell(2).innerHTML=document.getElementById("cj").value;
        tbodytr.insertCell(3).innerHTML = "<button onclick=\"Delete(this)\">删除本行<tton>";
    }
}
function Delete(bu) {
    var tr = bu.parentNode.parentNode;
    tr.parentNode.removeChild(tr);
}