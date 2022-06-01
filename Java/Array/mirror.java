import java.util.ArrayList;

public class mirror {
    public static void main(String[] args) {
        ArrayList arr=new ArrayList();
        arr.add(1);
        arr.add(5);
        arr.add(2);
        arr.add(6);
        System.out.println(arr);
        System.out.println(mirror2(arr));
    }
    public static ArrayList mirror2(ArrayList arr)
    {
        int init=arr.size()-1;
        int length= arr.size()*2;
        ArrayList arr2=new ArrayList(length);
        arr2=arr;
        for(int i=init;i>=0;i--)
        {
            arr2.add(arr.get(i));
        }
        return arr;
    }
}
