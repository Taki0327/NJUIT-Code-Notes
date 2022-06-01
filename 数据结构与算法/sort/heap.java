import java.util.Arrays;

public class heap {
    public static void main(String[] args) {
        int[] keys={40,11,37,25,67,52,85,40};
        heapSort(keys);
    }
    public static void heapSort(int keys[])
    {
        for(int i=keys.length/2-1;i>=0;i--)
        {
            sift(keys,i,keys.length-1);
        }
        for(int i=keys.length-1;i>0;i--)
        {
            swap(keys,0,i);
            System.out.println(Arrays.toString(keys));
            sift(keys,0,i-1);
        }
    }
    public static void swap(int[] array, int x, int y)
    {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
    public static void sift(int[] keys,int parent,int end)
    {
        int child=2*parent+1;
        int x=keys[parent];
        while(child<=end)
        {
            if(child<end&&keys[child+1]>keys[child])
                child++;
            if(x<keys[child])
            {
                keys[parent]=keys[child];
                parent=child;
                child=2*parent+1;
            }
            else
                break;
        }
        keys[parent]=x;
        
    }
}
