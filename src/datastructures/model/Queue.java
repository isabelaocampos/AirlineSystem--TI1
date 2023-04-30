package datastructures.model;

import java.util.NoSuchElementException;

public class Queue<T> {

    private Node<T> front;
    private Node<T> rear;
    private int size;

    private static class Node<T> {
        private T item;
        private Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

    public Queue() {
        front = rear = null;
        size = 0;
    }


    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item, null);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }


    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T item = front.item;
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
        }
        size--;
        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return front.item;
    }


    public boolean isEmpty() {
        return front == null;
    }


    public int size() {
        return size;
    }
}


