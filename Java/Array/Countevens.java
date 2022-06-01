import java.util.ArrayList;

public class Countevens {
    public static int countEvens(ArrayList<String> arr)
    {
        int n=0;
        /*for(int i=0;i<arr.size();i++)
        {
            String a=arr.get(i).toString();
            int count = 0;
            for (int j = 0;j < a.length();j++) {
                    if (Character.isLetter(a.charAt(j)))
                        count++;
            }
            if (count%2==0)
                n++;
        }*/
        for(String s:arr)
        {
            if(s.length()%2==0)
            {
                n++;
            }
        }
        return n;
    }
    public static void main(String[] args) {
        ArrayList list=new ArrayList();
        list.add("one");
        list.add("peach");
        list.add("pear");
        list.add("plum");
        System.out.println(countEvens(list));
    }
}
