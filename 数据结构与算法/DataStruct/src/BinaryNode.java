public class BinaryNode<T> {
    public T data;
    public BinaryNode<T> left,right;
    public BinaryNode(T data,BinaryNode<T> left,BinaryNode<T> right)
    {
        this.data=data;
        this.left=left;
        this.right=right;
    }
    public BinaryNode(T data)
    {
        this.data=data;
        this.left=null;
        this.right=null;
    }
    public String toString()
    {
        return data+" ";
    }
    public boolean isLeaf()
    {
        if(left==null&&right==null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

