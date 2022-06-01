public class SeqList<T> {
    Object[] element;
    int n;
    public SeqList(int length) {
        this.element = new Object[length];
        this.n=0;
    }
    public SeqList() {
        this(64);
    }
    public SeqList(T[] values) {
        this(values.length);
        for(int i = 0;i<values.length;i++)
            this.element[i] = values[i];
        this.n = element.length;
    }
    public boolean isEmpty() {
        return this.n == 0;
    }
    public int size(){
        return this.n;
    }
    public T get(int i) {
        if(i>=0 && i<this.n)
            return (T)this.element[i];
        return null;

    }
    public void set(int i,T x) {
        if(x==null)
            throw new NullPointerException("x==null");
        if(i>=0&&i<this.n)
            this.element[i]=x;
        else
            throw new IndexOutOfBoundsException(i+"");



    }
    public String toString() {
        String str = this.getClass().getName()+"(";
        if(this.n>0)
            str += this.element[0].toString();
        for(int i = 1;i<this.n;i++)
            str += ","+this.element[i].toString();
        return str+")";

    }
    public static void main(String[] args) {
        String[] values= {"A","B","C","D","E"};
        SeqList<String> lista = new SeqList<String>(values);
        SeqList<Integer> list1 = new SeqList<Integer>();
        System.out.println(lista.toString());
    }
    public int insert(int i ,T x) {
        if(x==null)
            return -1;
        if(i<0)
            i=0;
        if(i>this.n)
            i=this.n;
        Object[] source = this.element;
        if(this.n==element.length) {
            this.element = new Object[source.length*2];
            for(int j=0;j<i;j++)
                this.element[j] = source[j];
        }
        for(int j = this.n-1;j>=i;j--)
            this.element[j+1]=source[j];
        this.element[i]=x;
        this.n++;
        return i;
    }
    public int insert(T x) {
        return this.insert(this.n,x);
    }
    public T remove(int i) {
        if(i>=0 && i<this.n) {
            T x = (T)this.element[i];
            for(int j=i;j<this.n-1;j++)
                this.element[j] = this.element[j+1];
            this.element[this.n-1]=null;
            this.n--;
            return x;
        }
        return null;
    }
    public void clear() {
        this.n=0;
    }
    public int search(T key) {
        for(int i=0;i<this.n;i++)
            if(key.equals(this.element[i]))
                return i;
        return -1;
    }
}