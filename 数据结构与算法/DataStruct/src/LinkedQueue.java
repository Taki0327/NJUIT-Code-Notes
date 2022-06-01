public final class LinkedQueue<T> implements Queue<T>{
    private Node<T> front,rear,head;
    public LinkedQueue()
    {
        this.head=new Node<T>();
        this.front=this.rear=head;
    }
    public boolean isEmpty()
    {
        return this.front==this.head&&this.rear==this.head;
    }
    public boolean add(T x)
    {
        if(x==null)
        {
            return false;
        }
        Node<T> q=new Node<T>(x,null);
        if(this.front==this.head)
        { 
            this.head.next=q;
            this.front=q;
        }
        else
        {
            this.rear.next=q;
        }
        this.rear=q;
        return true;
    }
    public T peek()
    {
        return this.isEmpty()?null:this.front.data;
    }
    public T poll()
    {
        if(isEmpty())
        {
            return null;
        }
        T x=this.front.data;
        this.front=this.front.next;
        this.head.next=this.front;
        if(this.front==this.head)
        {
            this.rear=this.head;
        }
        return x;
    }
    public String toString()
    {
        String str="(";
        for(Node<T> p=this.head.next;p!=null;p=p.next)
        {
            str +=p.data.toString()+(p.next!=null?",":"");
        }
        return str+")";
    }
}