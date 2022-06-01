public interface Queue<T> {
    boolean isEmpty();
    boolean add(T x);
    T peek();
    T poll();
}
