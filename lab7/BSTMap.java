import com.sun.jdi.Value;

import java.security.Key;
import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V>{
    private Node root;

    private class Node{
        private K key;
        private V value;
        private Node left, right;
        private int size;

        public Node(K key, V value, int size){
            this.key = key;
            this.value = value;
            this.size = size;

        }
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean containsKey(K key) {
        if (key == null){
            throw new IllegalArgumentException("argument to contains() is null");
        }
        return get(key) != null;
    }

    @Override
    public V get(K key) {
        return get(root,key);
    }

    private V get(Node x, K key){
        if (key == null){
            throw new IllegalArgumentException("argument to contains() is null");
        }
        if(x == null){
            return null;
        }
        int a1 = key.compareTo(x.key);
        if(a1 < 0){
            return get(x.left,key);
        }else if(a1 > 0){
            return get(x.right, key);
        }else{
            return x.value;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x){
        if(x == null){
            return 0;
        }else{
            return x.size;
        }
    }

    @Override
    public void put(K key, V value) {
        if(key == null || value == null){
            throw new IllegalArgumentException("null key");
        }
        root = put(root,key,value);


    }
    private Node put(Node x, K key, V value){
        if(x == null){
            return new Node(key,value,1);
        }
        int a2 = key.compareTo(x.key);
        if(a2 > 0){
            x.right = put(x.right,key,value);
        }else if(a2 < 0){
            x.left = put(x.left,key,value);
        }else{
            x.value = value;
        }
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    @Override
    public Set<K> keySet() {
        throw new UnsupportedOperationException("do not need to 'keySet'");
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException("do not need to 'remove'");
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException("do not need to 'remove'");
    }

    @Override
    public Iterator<K> iterator() {
        throw new UnsupportedOperationException("do not need to 'Iterator'");
    }
    public void printInOrder(){
        System.out.println(root);
    }
//    public void printInOrder(Node x){
//
//    }
}
