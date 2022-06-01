public class josephus1 {
	public josephus1(int n,int start,int distanse)
	{
		if(n<=0||start<0||start>=n||distanse<=0||distanse>=n)
		{
			throw new IllegalArgumentException("n="+n+",start="+start+",distanse="+distanse);
		}
		System.out.print("Josephus("+n+","+start+","+distanse+"),");
		SeqList<String> list =new SeqList<String>(n);
		for(int i=0; i<n; i++)
		{
			list.insert((char)('A'+i)+"");
		}
		System.out.println(list.toString());
		while(n>1)
		{
			start =(start+distanse-1) %n;
			System.out.println("删除"+list.remove(start).toString()+" "+list.toString());
			n--;
			
		}
		System.out.println("被赦免者是" +list.get(0).toString());
	}
	public static void main(String[] args)
	{
		new josephus1(5,1,3);
	}
}