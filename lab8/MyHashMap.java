import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyHashMap<K,V> implements Map61B<K,V>{

    public MyHashMap(){
        this(16);
    }
    public MyHashMap(int initialSize){
        this(initialSize,0.75);
    }
    public MyHashMap(int initialSize, double loadFactor){
        keys = new HashSet<>();
        numofBucket = initialSize;
        for(int i = 0; i < numofBucket; i++){

        }
    }
    private int numofBucket;
    private HashSet<K> keys;
    private ArrayList<>
    @Override
    public void clear() {

    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public V remove(K key, V value) {
        return null;
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }
}
