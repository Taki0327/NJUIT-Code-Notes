public class Matrix
{
    protected int rows, columns;
    protected int[][] element;
    private static final int MIN_CAPACITY=6;

    public Matrix(int m, int n)
    {
        if(m>=0 && n>=0)
        {
            this.rows = m;
            this.columns = n;
            if(m<MIN_CAPACITY)
                m=MIN_CAPACITY;
            if(n<MIN_CAPACITY)
                n=MIN_CAPACITY;
            this.element = new int[m][n];
        }
        else
            throw new IllegalArgumentException("矩阵行列数不能<0,m="+m+",n="+n);
    }

    public Matrix(int n)
    {
        this(n, n);
    }
    public Matrix()
    {
        this(0, 0);
    }

    public Matrix(int m, int n, int[][] values)
    {
        this(m, n);
        for(int i=0;  i<values.length && i<m;  i++)
            for(int j=0;  j<values[i].length && j<n;  j++)
                this.element[i][j] = values[i][j];
    }

    public int getRows()
    {
        return this.rows;
    }
    public int getColumns()
    {
        return this.columns;
    }
    public int get(int i, int j)
    {
        if(i>=0 && i<this.rows && j>=0 && j<this.columns)
            return this.element[i][j];
        throw new IndexOutOfBoundsException("i="+i+",j="+j);
    }
    public void set(int i, int j, int x)
    {
        if(i>=0 && i<this.rows && j>=0 && j<this.columns)
            this.element[i][j]=x;
        else
            throw new IndexOutOfBoundsException("i="+i+",j="+j);
    }

    public String toString()
    {
        String str="矩阵"+this.getClass().getName()+"（"+this.rows+"*"+this.columns+"）:\n";
        for(int i=0;  i<this.rows;  i++)
        {
            for(int j=0;  j<this.columns;  j++)
                str+=String.format("%6d", this.element[i][j]);
            str += "\n";
        }
        return str;
    }

    public void setRowsColumns(int m, int n)
    {
        if(m>=0 && n>=0)
        {
            if(m>this.element.length || n>this.element[0].length)
            {
                int[][] source = this.element;
                this.element = new int[m*2][n*2];
                for(int i=0;  i<this.rows;  i++)
                    for(int j=0;  j<this.columns;  j++)
                        this.element[i][j] = source[i][j];
            }
            this.rows = m;
            this.columns = n;
        }
        else
            throw new IllegalArgumentException("矩阵行列数不能<0,m="+m+",n="+n);
    }
}
