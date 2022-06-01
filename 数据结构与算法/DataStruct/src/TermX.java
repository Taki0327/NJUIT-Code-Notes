/*public class TermX implements Comparable<TermX>,Addible<TermX> {
    protected int coef,xexp;
    public TermX(int coef,int xexp)
    {
        this.coef=coef;
        this.xexp=xexp;
    }
    public TermX(TermX term)
    {
        this.coef=term.coef;
        this.xexp=term.xexp;
    }
    public TermX(String termstr)
    {
        
    }
    public String toString()
    {
        return coef+"×^"+xexp;
    }
    /*public boolean equals(Object obj)
    {
        if(obj.equals(this.coef))
        {
            return true;
        }
    }*/