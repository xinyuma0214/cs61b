public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private ArrayDeque front;

    public ArrayDeque(){
        items = (T[]) new Object [8];
        size = 0;
    }
    public ArrayDeque(ArrayDeque other){

    }
    public void addFirst(T x){
        if (x==null){
            //throw new Exception();
        }
    }
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
}
