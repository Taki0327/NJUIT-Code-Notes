public class SinglyList<T extends Comparable<T>> {
    public Node<T> head;
    public SinglyList()
    {
        this.head = new Node<T>();
    } 
    public SinglyList(T[] values)
    {
        this();
        Node<T> rear = this.head;
        for(int i=0;i<values.length;i++)
        {
            if(values[i]!=null)
            {
                rear.next=new Node<T>(values[i], null);
                rear = rear.next;
            }
        }
    }
    public T get(int i)
    {
        Node<T> p=this.head.next;
        for(int j=0;p!=null&&j<i;j++)
        {
            p=p.next;
        }
        return (i>=0&&p!=null)?p.data:null;
    }
    public void set(int i,T x)
    {
        Node<T> p=this.head.next;
        for(int j=0;p!=null&&j<i;j++)
        {
            p=p.next;
        }
        if(x!=null)
        {
            p.data=x;
        }
    }
    public boolean isEmpty()
    {
    	return this.head.next==null?true:false;
    }
    public int size()
    {
        int count=0;
        Node<T> p=this.head;
        while(p!=null)
        {
            count++;
            p=p.next;
        }
        return count;
    }
    public String toString()
    {
        String str=this.getClass().getName()+"(";
        for(Node<T> p=this.head.next;p!=null;p=p.next)
        {
            str +=p.data.toString()+(p.next!=null?",":"");
        }
        return str+")";
    }
    public Node<T> insert(int i,T x){
        if(x==null)
        {
            return null;
        }
        Node<T> front=this.head;
        for(int j=0;front.next!=null&&j<i;j++)
        {
            front=front.next;
        }
        front.next=new Node<T>(x,front.next);
        return front.next;
    }
    public Node<T> insert(T x)
    {
        return insert(Integer.MAX_VALUE,x);
    }
    public T remove(int i)
    {
        Node<T> front=this.head;
        for(int j=0;front.next!=null&&j<i;j++)
        {
            front=front.next;
        }
        if(i>=0&&front.next!=null)
        {
            T x=front.next.data;
            front.next=front.next.next;
            return x;
        }
        return null;
    }
    public void clear()
    {
        this.head.next=null;
    }
    public Node<T> search(T key)
    {
        Node<T> p=this.head;
        while(p.next!=null)
        {
            p=p.next;
            if(p.data==key)
            {
                return p;
            }
        }
        return null;
    }
    public T remove(T key)
    {
        Node<T> p=this.head;
        //Node<T> q;
        while(p.next!=null)
        {
            //q=p;
            p=p.next;
            if(p.next.data==key)
            {
                //q.next=p.next;
                p.next=p.next.next;
                return p.next.data;
                //return p.data;
            }
        }
        return null;
    }
    public T remove2(T key)
    {
        Node<T> p=this.head;
        while(p.next!=null)
        {
            p=p.next;
            if(p.data==p.next.data)
            {
                p.next=p.next.next;
            }
        }
        return null;
    }
    public void reverse(SinglyList<T> list)
    {
        Node<T> p=list.head.next.next,q=null;
        list.head.next.next=null;
        //list.head.next=null;
        while(p!=null)
        {
            q=p.next;
            p.next=list.head.next;
            list.head.next=p;
            p=q;
        }
    }
    public void reverse2(SinglyList<T> list)
    {
        Node<T> p=list.head.next,succ=null,front=null;;
        while(p!=null)
        {
            succ=p.next;
            p.next=front;
            front=p;
            p=succ;
        }
        list.head.next=front;
    }
    public Node<T> merge(SinglyList<T> list2)
    {
        if(list2.head.next==null)
        {
            return this.head;
        }
        Node<T> t,p,q,s;
        t=this.head;
        p=t.next;
        q=list2.head.next;
        s=q.next;
        if(p==null)
        {
            return list2.head;
        }
        while (q != null && p != null)
        {
            if(p.data.equals(q.data))
            {
                if(p.next==null)
                {
                    t.next=q;
                    break;
                }
                else
                {
                    p=p.next;
                    q=q.next;
                    t=t.next;
                    if(s==null)
                    {
                        break;
                    }
                    else
                    {
                        s=s.next;
                    }
                }
            }
            if(p.data.compareTo(q.data)>0)
            {
                q.next=p;
                t.next=q;
                t=t.next;
                q=s;
                s=s.next;
            }
            else if(p.data.compareTo(q.data)<0)
            {
               p=p.next;
               t=t.next;
            }
        }
        if(p==null)
        {
            t.next=q;
        }
        return this.head;
    }
}
class Test{
    public static void main(String[] args) {
        /*int i=0;
        String [] a={"a1","a2","a3"};
        SinglyList<String> test=new SinglyList<String>(a);
        Node<String> p=test.head;
        while(i<a.length)
        {
            p=p.next;
            System.out.println(p.data.toString()+" ");
            i++;
        }*/
        //String [] a={"a1","a2","a3"};
        //SinglyList<String> test=new SinglyList<String>(a);
        //SinglyList<String> test2=new SinglyList<String>();
        /*System.out.println(test.get(2));
        System.out.println(test.toString());
        test.set(2, "10086");
        System.out.println(test.toString());
        System.out.println(test.size());
        System.out.println(test.insert(2,"10000"));
        System.out.println(test.toString());
        System.out.println(test.insert("10001"));
        System.out.println(test.toString());
        System.out.println(test.remove(2));
        System.out.println(test.toString());

        System.out.println(test.search("a1"));

        System.out.println(test.remove("10086"));
        System.out.println(test.toString());*/
        //test2.reverse2(test);
        //System.out.println(test.toString());
        //test2.reverse2(test);
        //System.out.println(test.toString());
        Integer [] c={1,2,3,4};

        ///Integer [] d;
        Integer [] d={4,5,6,7,8};
        SinglyList<Integer> test3=new SinglyList<Integer>(c);
        SinglyList<Integer> test4=new SinglyList<Integer>(d);
        test3.merge(test4);
       // System.out.println(test3.toString());
    }
}