public abstract class AbstractGraph<T> implements Graph<T>
{
    protected static final int MAX_WEIGHT = 0x00ffffff;
    protected SeqList<T> vertexlist;

    public AbstractGraph() {
        this.vertexlist = new SeqList<T>();
    }

    public int vertexCount() {
        return this.vertexlist.size();
    }

    public String toString() {
        return "顶点集合" + this.vertexlist.toString() + "\n";
    }

    public T get(int i) {
        return this.vertexlist.get(i);
    }

    public void set(int i, T x) {
        this.vertexlist.set(i, x);
    }

    public int search(T key) {
        return this.vertexlist.search(key);
    }

    public T remove(T key) {
        return this.remove(this.search(key));
    }

    protected abstract int next(int i, int j);
}
