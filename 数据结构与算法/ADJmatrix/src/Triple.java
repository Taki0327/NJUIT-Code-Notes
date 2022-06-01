public class Triple implements Comparable<Triple>, Addible<Triple>
{
    int row, column, value;
    public Triple(int row, int column, int value)
    {
        if(row>=0 && column>=0)
        {
            this.row = row;
            this.column = column;
            this.value = value;
        }
        else
            throw new IllegalArgumentException("行，列不能成为负数:row="+row+"，column="+column);
    }
    public Triple(String triple)
    {
        int i=triple.indexOf(','),  j=triple.indexOf(',', i+1);
        this.row = Integer.parseInt(triple.substring(1,i));
        this.column=Integer.parseInt(triple.substring(i+1,j));
        this.value=Integer.parseInt(triple.substring(j+1,triple.length()-1));
        if(this.row<0 || this.column<0)
            throw new IllegalArgumentException("行、列号错误row="+row+"，column="+column);
    }
    public Triple(Triple triple)
    {
        this(triple.row, triple.column, triple.value);
    }

    public String toString()
    {
        return "("+row+","+column+","+value+")";
    }

    public Triple toSymmetry()
    {
        return new Triple(this.column, this.row, this.value);
    }

    public boolean equals(Object obj)
    {
        if(this==obj)
            return true;
        if(obj instanceof Triple)
        {
            Triple triple = (Triple)obj;
            return this.row==triple.row && this.column==triple.column && this.value==triple.value;
        }
        return false;
    }

    public int compareTo(Triple triple)
    {
        if(this.row==triple.row && this.column==triple.column)
            return 0;
        return (this.row<triple.row || this.row==triple.row && this.column<triple.column)?-1:1;
    }

    public void add(Triple triple)
    {
        this.value += triple.value;
    }
    public boolean removable()
    {
        return this.value==0;
    }
}
