import java.util.Arrays;
public class shell {
    public static void main(String[] args) {
        int[] arr={1,2,5,10,6,9,3,7};
        System.out.println(Arrays.toString(shellsort(arr)));
    }
    public static int[] shellsort(int[] keys)
    {
        for(int detla=keys.length/2;detla>0;detla/=2)
        {
            for(int i=detla;i<keys.length;i++)
            {
                int x=keys[i],j;
                for(j=i-detla;j>=0&&x<keys[j];j-=detla)
                {
                    keys[j+detla]=keys[j];
                }
                keys[j+detla]=x;
            }
            System.out.println("detla:"+detla+" "+Arrays.toString(keys));
        }
        return keys;
    }
}
