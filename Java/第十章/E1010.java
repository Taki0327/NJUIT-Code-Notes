public class E1010 {
    public static void main(String[] args) {
        Queue queue = new Queue();
        for (int i = 1; i <= 20; i++)
            queue.enqueue(i);

        while (!queue.empty())
            System.out.print(queue.dequeue() + " ");
        System.out.print(queue.empty());
    }
}
class Queue {
    private int[] elements;
    private int size;

    public Queue() {
        elements = new int[8];
    }
    public void enqueue(int value) {
        if (size >= elements.length) {
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        elements[size++] = value;
    }
    public int dequeue() {
        int v = elements[0];
        for (int i = 0; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return v;
    }
    public boolean empty() {
        return size == 0;
    }
    public int getSize() {
        return size;
    }
}