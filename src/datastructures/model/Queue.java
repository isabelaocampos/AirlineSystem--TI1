package datastructures.model;

import java.util.LinkedList;

public class Queue<E> {
    private LinkedList<E> list;

    public Queue() {
        list = new LinkedList<>();
    }


    public void enqueue(E element) {
        list.addLast(element);
    }


    public E dequeue() {
        if (isEmpty()) {
            return null;
        }

        return list.removeFirst();
    }

    public E peek() {
        if (isEmpty()) {
            return null;
        }

        return list.getFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }


    public int size() {
        return list.size();
    }
}


