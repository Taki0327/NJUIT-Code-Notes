public class E103 {
    public static void main(String[] args) {
        char[] t4={'1','2','5'};
        String t5="5201314";
        MyInteger m1=new MyInteger(1111);
        MyInteger m2=new MyInteger(1000);
        System.out.println(m1.isEven());
        System.out.println(m1.isOdd());
        System.out.println(m1.isPrime());
        System.out.println(m1.isEven(10));
        System.out.println(m1.isOdd(20));
        System.out.println(m1.isPrime(30));
        System.out.println(m1.isEven(m2));
        System.out.println(m1.isOdd(m2));
        System.out.println(m1.isPrime(m2));
        System.out.println(m1.equals(m2));
        System.out.println(m1.equals(1111));
        System.out.println(m1.parselnt(t4));
        System.out.println(m1.parselnt(t5));
    }
}
class MyInteger{
    private int value;
    public MyInteger(int value){
        this.value=value;
    }
    public int getInt()
    {
        return value;
    }
    public boolean isEven()
    {
        if(value%2==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean isEven(int value)
    {
        if(value%2==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean isEven(MyInteger myinteger)
    {
        if(myinteger.getInt()%2==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean isOdd()
    {
        if(value%2!=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean isOdd(int value)
    {
        if(value%2!=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean isOdd(MyInteger myinteger)
    {
        if(myinteger.getInt()%2!=0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean isPrime()
    {
        for(int i=2;i<value;i++)
        {
            if(value%i==0)
            {
                return false;
            }
        }
        return true;
    }
    public boolean isPrime(int value)
    {
        for(int i=2;i<value;i++)
        {
            if(value%i==0)
            {
                return false;
            }
        }
        return true;
    }
    public boolean isPrime(MyInteger myinteger)
    {
        for(int i=2;i<value;i++)
        {
            if(myinteger.getInt()%i==0)
            {
                return false;
            }
        }
        return true;
    }
    public boolean equals(int value)
    {
        if(value==this.value)
        {
            return true;
        }
        else{
            return false;
        }
    }
    public boolean equals(MyInteger myinteger)
    {
        if(myinteger.value==this.value)
        {
            return true;
        }
        else{
            return false;
        }
    }
    public int parselnt(char[] value)
    {
        int num=0;
        for(int i=0;i<value.length;i++)
        {
            num=num*10+value[i]-'0';
        }
        return num;
        //return Integer.valueOf(value.toString());
    }
    public int parselnt(String value)
    {
        return Integer.valueOf(value);
    }
}