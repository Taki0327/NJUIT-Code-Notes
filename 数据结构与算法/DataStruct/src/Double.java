import java.util.Arrays;
import java.util.Scanner;

public class Double {
    public static void main(String[] args) {
        int arr[]={11,55,88,99,40,60,80,66,77,30,5,1};
        int start=0;
        int guess=0;
        int end=arr.length-1;
        for(int i=0;i<arr.length-1;i++)
        {
            for(int y=0;y<arr.length-1-i;y++)
            {
                if(arr[y]>arr[y+1])
                {
                    int a=arr[y];
                    arr[y]=arr[y+1];
                    arr[y+1]=a;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("输入猜的数：");
        Scanner sc=new Scanner(System.in);
        guess=sc.nextInt();
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(arr[mid]==guess)
            { 
                System.out.println("猜中了"+arr[mid]);
                break;
            }
            else if(arr[mid]>guess)
            {
                end=mid;
            }
            else if(arr[mid]<guess)
            {
                start=mid;
            }
          
        }
    }
}
