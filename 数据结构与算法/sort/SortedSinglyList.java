//《数据结构与算法（Java版）（第5版）》，作者：叶核亚，2019年7月23日
//§2.4  排序线性表的存储和实现
//§2.4.3 排序单链表
//§9.5.2 单链表的排序算法

//排序单链表类，继承单链表类；增加成员变量asc指定排序次序，升序或降序。
//T或T的某个祖先类?实现Comparable<?>接口，提供compareTo()方法比较对象大小和相等
public class SortedSinglyList<T extends Comparable<? super T>> extends SinglyList<T>
{
    protected boolean asc;                       //排序次序，取值为true（升序）或false（降序）
    
    public SortedSinglyList(boolean asc)         //构造空排序单链表，asc指定升/降序
    {
        super();                                 //构造空单链表，默认调用父类构造方法SinglyList()
        this.asc = asc;
    }    
    public SortedSinglyList()                    //构造空排序单链表，默认升序
    {
        this(true);
    }
    
    //构造方法，按值插入values数组元素，asc指定升/降序。直接插入排序算法
    public SortedSinglyList(T[] values, boolean asc)
    {
        this(asc);                               //构造空排序单链表
        for(int i=0; i<values.length; i++)       //直接插入排序，每趟插入1个元素
            this.insert(values[i]);              //排序单链表按值插入，覆盖，O(n)
    }
    public SortedSinglyList(T[] values)          //构造方法，按值插入values数组元素，默认升序
    {
        this(values, true);
    }
    //1.  排序单链表类声明

    
    //3.  排序单链表类覆盖父类成员方法
    //3.（1）  不需要从父类继承来的方法，覆盖并抛出异常
    //不支持父类的以下成员方法，将其覆盖并抛出异常。
    public void set(int i, T x) 
    {
        throw new java.lang.UnsupportedOperationException("set(int i, T x)");
    }
    public Node<T> insert(int i, T x) 
    {
        throw new java.lang.UnsupportedOperationException("insert(int i, T x)");
    }
    
    //3.（2） 排序单链表的插入操作，覆盖父类方法
    //插入x，x!=null，根据x对象大小顺序查找确定插入位置，插入在等值结点之后；返回插入结点。O(n)
    //由T类的compareTo()方法比较对象大小。覆盖父类insert(x)方法，参数列表和返回值相同。
    ////插入在等值结点之后。优先队列用
    public Node<T> insert(T x)
    {
        if(x==null)
            return null;
        //以下循环寻找插入位置，插入在等值结点之后
        Node<T> front=this.head,  p=front.next;            //front指向p的前驱结点
        while(p!=null && (this.asc ? x.compareTo(p.data)>=0 : x.compareTo(p.data)<=0))
        {
            front = p;
            p = p.next;
        }
        front.next = new Node<T>(x, p);                    //在front之后、p之前插入值为x结点
        return front.next;                                 //返回插入的x结点
    }    
    //说明：学生将上述循环写成以下这样，运行排序单链表{1,2,3,4,5}看不出问题。
//    while(p!=null && (this.asc == x.compareTo(p.data)>=0))
    //但是，①逻辑没有上句清楚；② 运行例4.4优先队列时出错如下，同优先级的元素排队反序。
//    出队元素：(E,10) (C,5) (B,5) (F,4) (A,4) (D,1) 

    
    //3.（3） toString()方法，覆盖父类方法，扩充功能
    //返回所有元素的描述字符串，形式为“(,)”，增加asc属性。覆盖
//    public String toString()
//    {
//        return super.toString()+"，"+(this.asc?"升序":"降序");  //其中super.toString()调用被覆盖的父类toString()方法
//    }//也可不覆盖
        
    //3.（4） 排序单链表的查找和删除操作，覆盖父类方法
    //顺序查找并返回首个与key相等元素结点，由compareTo()比较对象大小和相等；
    //若查找不成功返回null，O(n)。覆盖父类search(T key)方法。    
    //调用者：§5.2.2节稀疏矩阵行的单链表；
    //§7.2.3 AdjListGraph<T>的next(int i, int j)，必须返回结点，要寻找其后继结点。
    public Node<T> search(T key)
    {
//        System.out.print(this.getClass().getName()+".search("+key+")，");
        Node<T> p=this.head.next;  
        while(p!=null && (this.asc ? key.compareTo(p.data)>0 : key.compareTo(p.data)<0))
            p = p.next;
        if(p!=null && key.compareTo(p.data)==0)
            return p;
        return null; 
    }

    //顺序查找并删除首个与key相等元素结点，由compareTo()比较对象大小和相等，返回被删除元素；
    //若查找不成功返回null，O(n)。覆盖父类remove(T key)方法。
    //用于5.2.2节稀疏矩阵行的单链表
    public T remove(T key)
    {
        Node<T> front=this.head, p=front.next;   //front是p的前驱结点
        //以下循环查找与key相等元素结点（p指向）
        while(p!=null && (this.asc ? key.compareTo(p.data)>0 : key.compareTo(p.data)<0))
        {
            front = p;
            p = p.next;
        }
        if(p!=null && key.compareTo(p.data)==0)  //若查找成功，删除p结点，返回被删除元素
        {
            front.next = p.next;                 //删除p结点
            return p.data;
        }
        return null;
    }
    
    //4.  类型的多态，子类对象即是父类对象
    //（2） 排序单链表重载拷贝构造方法
    //以下拷贝构造方法，由list构造，深拷贝
    public SortedSinglyList(SortedSinglyList<T> list)  //拷贝构造方法，算法调用父类的深拷贝，O(n)；asc属性同list
    {
        super(list);                             //调用父类SinglyList(SinglyList<T> list)
        this.asc = list.asc;
    }   

    //leetCode，83. 删除排序链表中的重复元素//WSZ
    public void deleteDuplicates()
    {
        Node<T> front = head.next, p=front.next;
        while(front!=null && p!=null)
        {
            if(front.data.equals(p.data))
                front.next = p.next;
            else
                front = front.next;
            p = front.next;
        }
    } 
    
    
    //§9.5.2 单链表的排序算法
    //1．单链表的直接插入排序
    //由单链表list构造，深拷贝，重载构造方法，O(n*n)；asc指定升/降序；list可引用子类实例。
    //参数类型SinglyList<T>中的T，是SortedSinglyList<T>类声明的T，可比较大小。
    //算法按值插入list所有元素
/*    public SortedSinglyList(SinglyList<T> list, boolean asc)
    {
        this(asc);                               //构造空排序单链表
        for(Node<T> p=list.head.next; p!=null; p=p.next) //直接插入排序，每趟插入1个元素
            this.insert(p.data);                 //排序单链表按值插入，覆盖，O(n)
    }*/
//    public SortedSinglyList(SinglyList<T> list)    //由单链表list构造，深拷贝，升序，重载构造方法
//    {
//        this(list, true);
//    }
    
    //4.（3） equals(Object)方法，覆盖，扩充功能
    public boolean equals(Object obj)            //比较相等，覆盖
    {
        System.out.print(this.getClass().getName()+".equals("+obj.getClass().getName()+")，");
        if(obj == this)
            return true;
        if(obj instanceof SortedSinglyList<?>)   //排序单链表与单链表不可比较相等
        {
            SortedSinglyList<T> list = (SortedSinglyList<T>)obj;
            return this.asc==list.asc && super.equals(list);
               //其中，super.equals(list)调用被覆盖的父类方法，比较两条单链表是否相等
        }
        return false;
    }
    
    //4.（3） 排序单链表的集合并运算，覆盖                  ////泛型的继承性。
    public void concat(SinglyList<T> list)       //不支持直接首尾合并连接，抛出异常。覆盖
    {
        throw new UnsupportedOperationException("concat(SinglyList<T> list)");
    }
    
    //集合并，this+=list，复制list所有结点按值插入元素到this排序单链表中；不改变list，O(n*n)。覆盖
    public void addAll(SinglyList<T> list)
    {
        for(Node<T> p=list.head.next;  p!=null;  p=p.next)//直接插入排序，每趟插入1个元素
            this.insert(p.data);                 //运行时多态，排序单链表按值插入
    }    
    
    //返回并集（this+list），返回复制this和list所有结点的排序单链表，不改变this和list。
    //返回排序单链表对象，覆盖的返回值类型与父类的返回值类型赋值相容
    public SortedSinglyList<T> union(SinglyList<T> list)
    {
        //下句由list单链表构造排序单链表this，深拷贝，默认升序
        SortedSinglyList<T> result = new SortedSinglyList<T>(this);
        result.addAll(list);                     //调用排序单链表的addAll(list)
        return result;                           //返回排序单链表对象
    }
    //说明：必须覆盖，否则其中创建单链表，调用单链表addAll(list)并返回SinglyList<T>，不能返回子类实例。
    
    //以上第2章
    //@author：Yeheya，2015-10-5，2019年8月26日
    
    
    //第9章
    //§9.5.2 单链表的排序算法
    //2.  单链表的直接选择排序
    //由单链表list构造排序单链表，直接选择排序，O(n*n)
    public SortedSinglyList(SinglyList<T> list, boolean asc)
    {
        super(list);                             //this深拷贝list单链表
        this.asc = asc;
        //以下直接选择排序算法，每趟选择最小值并交换结点元素值，不删除和插入结点
        for(Node<T> first=this.head.next; first.next!=null; first=first.next)
        {                                        //first指向待排序单链表首个结点  
            Node<T> min=first;                   //min指向最小值结点
            for(Node<T> p=min.next;   p!=null;   p=p.next) //遍历单链表，寻找最小值结点
                if(this.asc ? p.data.compareTo(min.data)<0 : p.data.compareTo(min.data)<0)//比较大小
                    min = p;                     //min记住最小值结点
            if(min!=first)                       //交换min元素到前面first结点
            {
                T temp = min.data;
                min.data = first.data;
                first.data = temp;
            }
//            System.out.println(this.toString());
        }
    }
    

    //§9.5.2 单链表的排序算法
    //3.  归并两条排序单链表
    //将list所有结点归并到this中，this+=list，结果在this，归并后设置list为空。一次归并算法。
    public void merge(SortedSinglyList<T> list)
    {
        //若list.asc与this.asc不同，则将list所有结点元素插入到this中，直接插入排序。省略
    	if(this.asc!=list.asc)
    	{
            for(Node<T> p=list.head.next; p!=null; p=p.next) //直接插入排序
                this.insert(p.data);             //排序单链表按值插入
            return;
    	}

        Node<T> front=this.head,  p=front.next;  //p遍历this单链表，front是p的前驱
        Node<T> q=list.head.next;                //q遍历list单链表
        while(p!=null && q!=null)                //遍历两条排序单链表
        {
            if((p.data).compareTo(q.data)<0)     //若p结点值小，则p继续前进
            {
                front = p;
                p = p.next;
            }
            else                                 //否则，将q结点插入到front结点之后
            {
                front.next = q;
                q = q.next;
                front = front.next;
                front.next = p;
            }
        }
        if(q!=null)                              //将list中剩余结点并入this尾
            front.next = q;
        list.head.next = null;                   //设置list为空单链表
    }
    
    //以下第5版未写
    //返回this和list归并后的排序单链表，不改变this。设置list为空。二次遍历，效率低
/*    public SortedSinglyList<T> mergeWith(SortedSinglyList<T> list)  
    {
        SortedSinglyList<T> slist = new SortedSinglyList<T>(this);   //单链表深拷贝this，O(n)
        slist.merge(new SortedSinglyList<T>(list));        //slist归并list，设置list为空。O(n)
        return slist;
    }*/
    
    //【实验题9-3】 
    //返回this和list归并后的排序单链表，不改变this和list。效率高，简化
    public SortedSinglyList<T> mergeWith(SortedSinglyList<T> list)  
    {
        Node<T> p=this.head.next, q=list.head.next;        //p、q分别遍历this、list单链表
        SortedSinglyList<T> result = new SortedSinglyList<T>();
        Node<T> rear = result.head;              //rear指向result单链表尾，准备插入
        while(p!=null || q!=null)                //p、q分别遍历this、list单链表
        {
            //复制this结点到result，若p结点值小，或q已结束
            if(p!=null && (q!=null && (p.data).compareTo(q.data)<=0 || q==null))
            {
                rear.next = new Node<T>(p.data,null);
                rear = rear.next;
                p = p.next;
            }
        	//否则，复制list结点到result，若q结点值小，或p已结束
            else if(q!=null && (p!=null && (p.data).compareTo(q.data)>0 || p==null))
            {
                rear.next = new Node<T>(q.data,null);
                rear = rear.next;
                q = q.next;
            }
        }
        return result;
    }
}
//@author：Yeheya。2015-4-6；2016-2-7，除夕；2019年9月15日；2020年3月19日