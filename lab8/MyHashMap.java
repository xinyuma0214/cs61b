import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyHashMap<K,V> implements Map61B<K,V>{
    private int numofBucket;
    private int numofEntries = 0;
    private double num;
    private HashSet<K> keys;
    private ArrayList<ArrayList<Entry>> buckets;

    private class Entry{
        private K key;
        private V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    public MyHashMap(){
        this(16);
    }
    public MyHashMap(int initialSize){
        this(initialSize,0.75);
    }
    public MyHashMap(int initialSize, double loadFactor){
        keys = new HashSet<>();
        buckets = new ArrayList<>();
        numofBucket = initialSize;
        num = loadFactor;
        for(int i = 0; i < numofBucket; i++){
            buckets.add(new ArrayList<Entry>());
        }
    }


    @Override
    public void clear() {
        keys = new HashSet<>();
        buckets = new ArrayList<>();
        numofBucket = 0;
        numofEntries = 0;
    }
    public void resize(int capacity){
        ArrayList<ArrayList<Entry>> newBuckets = new ArrayList<>();
        for(int i = 0; i < capacity; i++){
            newBuckets.add(new ArrayList<>());
        }
        for(K key : this){
            int index = hash(key,capacity);
            newBuckets.get(index).add(new Entry(key,get(key)));
            this.numofBucket = capacity;
            this.buckets = newBuckets;
        }
    }
    @Override
    public boolean containsKey(K key) {
        return keys.contains(key);
    }

    @Override
    public V get(K key) {
        if(!containsKey(key)) {
            return null;
        }
        int index = hash(key,numofBucket);
        for(Entry entry : buckets.get(index)){
            if(entry.key.equals(key)){
                return entry.value;
            }
        }
        return null;
    }
    public int hash(K key, int capacity){
        return Math.floorMod(key.hashCode(),capacity);

    }
    public void update(K key, V value){
        int index = hash(key,numofBucket);
        for(Entry entry : buckets.get(index)){
            if(entry.key.equals(key)){
                entry.value = value;
            }
        }
    }
    @Override
    public int size() {
        return numofEntries;
    }

    @Override
    public void put(K key, V value) {
        if(containsKey(key)){
            update(key,value);
            return;
        }
        if(size() >= numofBucket * num){
            resize(numofBucket * 2);
        }
        int index = hash(key,numofBucket);
        buckets.get(index).add(new Entry(key,value));
        keys.add(key);
        numofEntries += 1;

    }

    @Override
    public Set<K> keySet() {
        return keys;
    }

    @Override
    public V remove(K key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator() {
        return keys.iterator();
    }
}
