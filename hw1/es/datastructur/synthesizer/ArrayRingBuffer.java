package es.datastructur.synthesizer;

//TODO: Make sure to that this class and all of its methods are public
//TODO: Make sure to add the override tag for all overridden methods
//TODO: Make sure to make this class implement BoundedQueue<T>

import java.util.Iterator;

public class ArrayRingBuffer<T> implements BoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Variable for the fillCount. */
    private int fillCount;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        rb = (T[]) new Object[capacity];
        first = 0;
        last = 0;
        fillCount = 0;

    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow").
     * @param x
     */
    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update
        //       last.
        if (isFull()) {
            throw new RuntimeException("Ring Buffer overflow");
        }
        if(last == capacity()){
            last = 0;
        }
        rb[last] = x;
        last +=1;
        fillCount += 1;
    }

    @Override
    public int capacity() {
        return rb.length;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }


    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    @Override
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and
        //       update first.
        if(isEmpty()){
            throw new RuntimeException("Ring buffer underflow");
        }else {
            T returnVal = rb[first];
            rb[first] = null;
            first += 1;
            fillCount -= 1;
            if (first == capacity()) {
                first = 0;
            }
            return returnVal;
        }
    }

    /**
     * Return oldest item, but don't remove it. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow").
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should
        //       change.
        if(isEmpty()){
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];

    }

    public Iterator<T> iterator(){
            return new ArrayRingBufferIterator();

    }
    private class ArrayRingBufferIterator implements Iterator<T>{
        private int pos;
        public ArrayRingBufferIterator(){
            pos = 0;
        }
        @Override
        public boolean hasNext() {
            return pos < fillCount();
        }

        @Override
        public T next() {
            T returnVal = rb[pos];
            pos += 1;
            if (pos == capacity()) {
                pos = 0;
            }
            return returnVal;
        }


        @Override
        public boolean equals(Object o){
            if(this == o){
                return true;
            }
            if(this == null){
                return false;
            }
            if(o.getClass() != this.getClass()){
                return false;
            }
//          回来看 iterator
//            ArrayRingBuffer<T> other= (ArrayRingBuffer<T>) o;
//            if (other.fillCount != this.fillCount()) {
//                return false;
//            }
//
//            Iterator<T> otherIterator = other.iterator();
//            Iterator<T> thisIterator = this.iterator();

//            while (otherIterator.hasNext() && otherIterator.hasNext()) {
//                if (thisIterator.next() != otherIterator.next()) {
//                    return false;
//                }
//            }
            return true;
        }
    }

    // TODO: When you get to part 4, implement the needed code to support
    //       iteration and equals.
}
    // TODO: Remove all comments that say TODO when you're done.
