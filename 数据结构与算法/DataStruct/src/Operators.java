import java.util.*;
public class Operators implements Comparator<String>{
    private String[] operator={"*","/","%","+","-","&","^","|"};
    private int[] priority={3,3,3,4,4,8,9,10};
    private SeqList<String> openlist;

    public Operators()
    {
        this.openlist=new SeqList<String>(this.operator);
    }
    public int compare(String oper1,String oper2)
    {
        int i=openlist.search(oper1),j=openlist.search(oper2);
        return this.priority[i]-this.priority[j];
    }
    public int operate(int x,int y,String oper)
    {
        int value=0;
        switch(oper)
        {
            case "+":value=x+y;break;
            case "-":value=x-y;break;
            case "*":value=x*y;break;
            case "/":value=x/y;break;
            case "%":value=x%y;break;
            case "&":value=x&y;break;
            case "^":value=x^y;break;
            case "|":value=x|y;break;
        }
        return value;
    }
}