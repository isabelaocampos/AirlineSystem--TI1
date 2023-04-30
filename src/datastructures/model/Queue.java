package datastructures.model;

import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Collections;

public class Queue<T> {
    private ArrayList<T> queue;

    public Queue() {
        queue = new ArrayList<>();
    }

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {

        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return queue.remove(0);
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return queue.get(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void print() {
        System.out.print("\nTurist Class:\n");
        for (T item : queue) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

}


