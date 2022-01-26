public class Pair<T, K> {
    private final T x;
    private final K y;

    public Pair(T element1, K element2) {
        x = element1;
        y = element2;
    }

    public T getX() {
        return x;
    }

    public K getY() {
        return y;
    }
}
