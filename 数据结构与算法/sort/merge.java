import java.util.Arrays;
public class merge {
    public static void main(String[] args) {
        int[] X={91,82,75,53,17,61,70,12,61,58,26};
        mergeSort(X);
    }
    private static void merges(int[] X,int[] Y,int begin1,int begin2,int n)
    {
        int i=begin1,j=begin2,k=begin1;
        while(i<begin1+n&&j<begin2+n&&j<X.length)
        {
            if(X[i]<=X[j])
            {
                Y[k++]=X[i++];
            }
            else
            {
                Y[k++]=X[j++];
            }
        }
        while(i<begin1+n&&i<X.length)
            Y[k++]=X[i++];
        while(j<begin2+n&&j<X.length)
            Y[k++]=X[j++];
    }
    private static void mergepass(int[] X,int[] Y,int n)
    {
        for(int i=0;i<X.length;i+=2*n)
        {
            merges(X, Y, i, i+n, n);
        }
        System.out.println(Arrays.toString(Y));
    }
    private static void mergeSort(int[] X)
    {
        int[] Y=new int[X.length];
        int n=1;
        while(n<X.length)
        {
            mergepass(X, Y, n);
            n*=2;
            if(n<X.length)
            {
                mergepass(Y, X, n);
                n*=2;
            }
        }
    }
}

