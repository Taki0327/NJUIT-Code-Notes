public class TriElement {
    int data;
    int parent,left,right;
    public TriElement(int data, int parent,int left,int right)
    {
        this.data=data;
        this.parent=parent;
        this.left=left;
        this.right=right;
    }
    public TriElement(int data)
    {
        this.data=data;
        this.parent=-1;
        this.left=-1;
        this.right=-1;
    }
    public String toString()
    {
        return "("+data+","+parent+","+left+","+right+")";
    }
    public boolean isLeaf()
    {
        if(this.left==-1&&this.right==-1)
        {
            return true;
        }
        return false;
    }
}
