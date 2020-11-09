import java.util.Deque;

public class LinkedListDeque<T> {
    private class dequenode{
        public T item;
        public dequenode next;
        public dequenode prev;

        public dequenode(T i,dequenode p,dequenode n){
            item = i;
            next = n;
            prev = p;
        }
    }
    private int size;
    public dequenode sentFront;

    /** Creates an empty LinkedListDeque. */
    public LinkedListDeque(){
        sentFront = new dequenode(null,null,null);
        size = 0;
//        dequenode p = sentFront;
//        while(p.next != null){
//            p = p.next;
//        }
//        sentBack = p;
    }
    public LinkedListDeque(T item){
        sentFront = new dequenode(null,null,null);
        sentFront.next = new dequenode(item,sentFront,sentFront);
        sentFront.prev = sentFront.next;
        size = 1;
    }
    /** add to first*/
    public void addFirst(T item){
        sentFront.next = new dequenode(item,sentFront,sentFront.next);
        sentFront.next.next.prev = sentFront.next;
        size +=1;
    }
    public void addLast(T item){
        dequenode node2 = new dequenode(item,sentFront.prev,sentFront);
        sentFront.prev.next = node2;
        sentFront.prev = node2;
        size +=1;
    }
    public boolean isEmpty(){
        return (this.size == 0);
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        dequenode p = sentFront;
        while(p != sentFront.prev){
            p = p.next;
            System.out.println(p.item);
        }
    }
    public T removeFirst(){
        T result = sentFront.next.item;
        sentFront.next.prev = sentFront;
        sentFront.next = sentFront.next.next;
        size-=1;
        return result;
    }
    public T removeLast(){
        T result = sentFront.prev.item;
        sentFront.prev.prev.next = sentFront;
        sentFront.prev = sentFront.prev.prev;
        return result;
    }
    public T get(int index){
        if(index>(size-1)){
            return null;
        }
        dequenode p =sentFront;
        for (int i = 0; i<=index;i++){
            p = p.next;
        }
        return p.item;
    }
    //using recursion
    public T getRecursiveHelp(dequenode a,int i){
        if (i ==0){
            return a.next.item;
        }else{
            a = a.next;
            i -=1;
        }
        return getRecursiveHelp(a,i);
    }
    public T getRecursive(int index){
        if (index>(size-1)){
            return null;
        }
        dequenode p = sentFront;
        return getRecursiveHelp(p,index);
    }
    public static void main(String[] args){
        LinkedListDeque DLlist = new LinkedListDeque();
        LinkedListDeque DLlist2 = new LinkedListDeque(2);
        DLlist2.addFirst(1);
        DLlist2.addLast(3);
        //System.out.println(DLlist2.size());
        //DLlist2.removeFirst();
        //DLlist2.removeLast();
        //System.out.println(DLlist2.get(1));
        //DLlist2.printDeque();
        System.out.println(DLlist2.getRecursive(2));
    }
}


