import java.util.Arrays;

public class Insert {
    public static void main(String[] args) {
        int[] arr={1,2,5,10,6,9};
        System.out.print(Arrays.toString(Insert2(arr, true)));
    }
    public static int[] Insert2(int[] keys,boolean asc)
    {
        for(int i=1;i<keys.length;i++)
        {
            int x=keys[i],j;
            for(j=i-1;j>=0&&(asc?x<keys[j]:x>keys[j]);j--)
            {
                keys[j+1]=keys[j];
            }
            keys[j+1]=x;
        }
        return keys;
    }
}
