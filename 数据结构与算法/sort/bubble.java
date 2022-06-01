import java.util.Arrays;
public class bubble {
    public static void main(String[] args) {
        int[] arr={11,2,5,10,6,9};
        bubble2(arr);
    }
    public static int[] bubble2(int[] keys)
    {
        boolean exchange=true;
        for(int i=1;i<keys.length&&exchange;i++)
        {
            exchange=false;
            for(int j=keys.length-2;j>=0;j--)
            {
                if(keys[j]>keys[j+1])
                {
                    int temp=keys[j];
                    keys[j]=keys[j+1];
                    keys[j+1]=temp;
                    exchange=true;
                }
            }
            System.out.println(Arrays.toString(keys));
        }
        return keys;
    }
}
