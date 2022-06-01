function SCtable()
{
    var hang=document.getElementById("hang").value;
    var lie=document.getElementById("lie").value;
    var table = document.createElement("table");
    table.setAttribute("width",400);
    table.setAttribute("border",1);
    document.body.appendChild(table);
    for (var i = 0; i < hang; i++) {
        var trNode = table.insertRow(i);
        for (var j = 0; j < lie; j++) {
            (trNode.insertCell(j)).innerHTML = "&nbsp;";
        }
    }
}