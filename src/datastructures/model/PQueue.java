package datastructures.model;
import java.util.*;

public class PQueue<T extends Comparable<T>> {
    
    private ArrayList<T> heap;
    
    public PQueue() {
        heap = new ArrayList<T>();
    }
    
    public void insert(T value) {
        heap.add(value);
        int index = heap.size() - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) > 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }
    
    public T remove() {
        if (heap.size() == 0) {
            throw new NoSuchElementException();
        }
        T result = heap.get(0);
        if (heap.size() == 1) {
            heap.remove(0);
            return result;
        }
        heap.set(0, heap.remove(heap.size() - 1));
        int index = 0;
        while (true) {
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = index * 2 + 2;
            if (leftChildIndex >= heap.size()) {
                break;
            }
            int maxChildIndex = leftChildIndex;
            if (rightChildIndex < heap.size() && heap.get(rightChildIndex).compareTo(heap.get(leftChildIndex)) > 0) {
                maxChildIndex = rightChildIndex;
            }
            if (heap.get(maxChildIndex).compareTo(heap.get(index)) > 0) {
                swap(index, maxChildIndex);
                index = maxChildIndex;
            } else {
                break;
            }
        }
        return result;
    }
    
    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void print(){
        System.out.println("First class \n");
        for(T value: heap){
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    
    public int size() {
        return heap.size();
    }
    
}