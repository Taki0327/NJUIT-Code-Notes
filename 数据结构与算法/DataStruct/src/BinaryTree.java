public class BinaryTree<T> {
    public BinaryNode<T> root;
    public BinaryTree()
    {
        this.root=null;
    }
    public BinaryTree(T[] prelist)
    {
        this.root=create(prelist);
    }
    public boolean isEmpty()
    {
        return this.root==null;
    }
    public void preorder()
    {
        preorder(this.root);
        System.out.println();
    }
    public void preorder(BinaryNode<T> p)
    {
        if(p!=null)
        {
            System.out.println(p.data.toString()+" ");
            preorder(p.left);
            preorder(p.right);
        }
    }
///中根
    public void inorder()
    {
        inorder(this.root);
        System.out.println();
    }
    public void inorder(BinaryNode<T> p)
    {
        if(p!=null)
        {
            inorder(p.left);
            System.out.println(p.data.toString()+" ");
            inorder(p.right);
        }
    }
    public void postorder()
    {
        postorder(this.root);
        System.out.println();
    }
    public void postorder(BinaryNode<T> p)
    {
        if(p!=null)
        {
            postorder(p.left);
            postorder(p.right);
            System.out.println(p.data.toString()+" ");
        }
    }
    private int i=0;
    private int leaf=0;
    private BinaryNode<T> create(T[] prelist)
	{
		BinaryNode<T> p=null;
		if(i<prelist.length)
		{
			T elem=prelist[i++];
			if(elem!=null)
			{
				p=new BinaryNode<T>(elem);
				p.left=create(prelist);
				p.right=create(prelist);
			}
		}
		return p;
    }
    ///节点总数
    public int size()
    {
        return size(this.root);
    }
    public int size(BinaryNode<T> p)
    {
        if(p==null)
        {
            return 0;
        }
        return 1+size(p.left)+size(p.right);
    }
    public int leafsize()
    {
        return leafsize(this.root);
    }
    public int leafsize(BinaryNode<T> p)
    {
        if(p==null)
        {
            return 0;
        }
        if(p.left==null&&p.right==null)
        {
            return 1;
        }
        return leafsize(p.left)+leafsize(p.right);
    }
    public int height()
    {
        return height(this.root);
    }
    public int height(BinaryNode<T> p)
    {
        if(p==null)
        {
            return 0;
        }
        int lh=height(p.left);
        int rh=height(p.right);
        return Math.max(lh, rh)+1;
    }
}
class bintest{
    public static void main(String[] args) {
        String[] prelist={"A","B","D",null,"G",null,null,null,"C","E",null,null,"F","H"};
        BinaryTree<String> bitree=new BinaryTree<String>(prelist);
        System.out.println("先根：");
        bitree.preorder();
        System.out.println("中根：");
        bitree.inorder();
        System.out.println("后根：");
        bitree.postorder();
        System.out.println("节点："+bitree.size());
        System.out.println("叶子节点："+bitree.leafsize());
        System.out.println("高度："+bitree.height());
    }
}