public class Josephus2 {
	public Josephus2(int n,int start,int distanse)
	{
		if(n<=0||start<0||start>=n||distanse<=0||distanse>=n)
		{
			throw new IllegalArgumentException("n="+n+",start="+start+",distanse="+distanse);
		}
		SinglyList<String> list =new SinglyList<String>();
		for(int i=n-1; i>=0; i--)
		{
			list.insert(0,(char)('A'+i)+"");
		}
		System.out.println("Josephus("+n+","+start+","+distanse+"),"+list.toString());
		Node<String> front=list.head;
		for(int i=0;front!=null&&i<start;i++)
		{
			front=front.next;
		}
		while(n>1)
		{
			for(int i=1;i<distanse;i++)
			{
				front=front.next;
				if(front==null)
				{
					front=list.head.next;
				}
			}
			if(front.next==null)
			{
				front=list.head;
			}
			System.out.print("删除"+front.next.data.toString()+"，");
			front.next=front.next.next;
			n--;
			System.out.println(list.toString());
		}
		System.out.println("被赦免者是" +list.get(0).toString());
	}
	public static void main(String[] args)
	{
		Josephus2 a =new Josephus2(5,0,3);
	}
}