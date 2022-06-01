public class MatrixGraph<T> extends AbstractGraph<T>
{
    protected Matrix matrix;

    public MatrixGraph()
    {
        super();
        this.matrix = new Matrix(0,0);
    }
    public MatrixGraph(T[] vertexes)
    {
        this();
        for(int i=0; i<vertexes.length; i++)
            this.insert(vertexes[i]);
    }
    public MatrixGraph(T[] vertexes, Triple[] edges)
    {
        this(vertexes);
        for(int j=0; j<edges.length; j++)
            this.insert(edges[j]);
    }

    public String toString()
    {
        String str = super.toString()+"邻接矩阵： \n"  ;
//        str+=this.matrix.toString();
        int n = this.vertexCount();
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(this.matrix.get(i,j)==MAX_WEIGHT)
                    str += "     ∞";
                else
                    str += String.format("%6d", this.matrix.get(i,j));
            }
            str+="\n";
        }
        return str;

    }

    public int insert(T x)
    {
        this.vertexlist.insert(x);
        int i = this.vertexlist.size()-1;
        if(i >= this.matrix.getRows())
            this.matrix.setRowsColumns(i+1, i+1);
        for(int j=0; j<i; j++)
        {
            this.matrix.set(i, j, MAX_WEIGHT);
            this.matrix.set(j, i, MAX_WEIGHT);
        }
        return i;
    }

    public void insert(int i, int j, int w)
    {
        if(i!=j)
        {
            if(w<=0 || w>MAX_WEIGHT)
                w=MAX_WEIGHT;
            this.matrix.set(i,j,w);
        }
        else
            throw new IllegalArgumentException("不能插入自身环,i="+i+",j="+j);
    }
    public void insert(Triple edge)
    {
        this.insert(edge.row, edge.column, edge.value);
    }

    public void remove(int i, int j)
    {
        if(i!=j)
            this.matrix.set(i, j, MAX_WEIGHT);
    }
    public void remove(Triple edge)
    {
        this.remove(edge.row, edge.column);
    }


    public T remove(int i)
    {
        int n=this.vertexCount();
        if(i>=0 && i<n)
        {
            T x = this.vertexlist.get(n-1);
            this.vertexlist.set(i, x);
            x = this.vertexlist.remove(n-1);

            for(int j=0;  j<n;  j++)
                this.matrix.set(i, j, this.matrix.get(n-1,j));
            for(int j=0;  j<n;  j++)
                this.matrix.set(j, i, this.matrix.get(j, n-1));
            this.matrix.setRowsColumns(n-1, n-1);
            return x;
        }
        else
            throw new IndexOutOfBoundsException("i="+i);
    }

    public int weight(int i, int j)
    {
        return this.matrix.get(i,j);
    }

    protected int next(int i, int j)
    {
        int n=this.vertexCount();
        if(i>=0 && i<n && j>=-1 && j<n && i!=j)
            for(int k=j+1;  k<n;  k++)
                if(this.matrix.get(i,k)>0 && this.matrix.get(i,k)<MAX_WEIGHT)
                    return k;
        return -1;
    }
}
