public class ABC {
    public static void main(String[] args) {
        LinkedQueue<Integer> test1=new LinkedQueue<Integer>();  
        System.out.println(test1.isEmpty());
        test1.add(1);
        System.out.println(test1.toString());
        test1.add(2);
        System.out.println(test1.toString());
        test1.add(3);
        System.out.println(test1.toString());
        System.out.println( test1.peek());
        test1.poll();
        System.out.println(test1.toString());
        
    }
}
