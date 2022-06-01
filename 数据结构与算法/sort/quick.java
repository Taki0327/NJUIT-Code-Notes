import java.util.Arrays;
public class quick {
    public static void main(String[] args) {
        int[] keys={72,73,71,23,94,16,5};
        quickSort(keys);
    }
    public static void quickSort(int[] keys)
    {
        quickSort(keys,0,keys.length-1);
    }
    public static void quickSort(int[] keys,int begin,int end)
    {
        System.out.println(Arrays.toString(keys));
        if(begin>=0&&begin<end&&end<keys.length)
        {
            int i=begin,j=end,x=keys[i];
            while(i!=j)
            {
                while(i<j&&keys[j]>=x)
                {
                    j--;
                }
                if(i<j)
                {
                    keys[i++]=keys[j];
                }
                while(i<j&&keys[i]<=x)
                {
                    i++;
                }
                if(i<j)
                {
                    keys[j--]=keys[i];
                }
            }
            keys[i]=x;
            System.out.println(Arrays.toString(keys));
            quickSort(keys,begin,j-1);
            quickSort(keys,i+1,end);
        }
    }
}
