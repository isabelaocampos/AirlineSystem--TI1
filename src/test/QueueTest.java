package test;
import datastructures.model.Queue;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


public class QueueTest {
    @Test
    void testEnqueue() {
        // Arrange
        Queue<String> queue = new Queue<>();
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());

        // Act and Assert
        queue.enqueue("apple");
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
        assertEquals("apple", queue.peek());

        queue.enqueue("banana");
        assertFalse(queue.isEmpty());
        assertEquals(2, queue.size());
        assertEquals("apple", queue.peek());

        queue.enqueue("cherry");
        assertFalse(queue.isEmpty());
        assertEquals(3, queue.size());
        assertEquals("apple", queue.peek());
    }

    @Test
    void testEnqueueNull() {
        // Arrange
        Queue<Integer> queue = new Queue<>();

        // Act
        queue.enqueue(null);

        // Assert
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
        assertNull(queue.peek());
    }


    @Test
    void testEnqueueLargeNumber() {
        // Arrange
        Queue<Long> queue = new Queue<>();

        // Act
        queue.enqueue(Long.MAX_VALUE);

        // Assert
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
        assertEquals(Long.MAX_VALUE, queue.peek());
    }


    @Test
    void testDequeue() {
        // Arrange
        Queue<String> queue = new Queue<>();
        queue.enqueue("apple");
        queue.enqueue("banana");
        queue.enqueue("cherry");
        assertFalse(queue.isEmpty());
        assertEquals(3, queue.size());

        // Act and Assert
        String item = queue.dequeue();
        assertEquals("apple", item);
        assertFalse(queue.isEmpty());
        assertEquals(2, queue.size());
        assertEquals("banana", queue.peek());

        item = queue.dequeue();
        assertEquals("banana", item);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());
        assertEquals("cherry", queue.peek());

        item = queue.dequeue();
        assertEquals("cherry", item);
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());

    }

    @Test
    void testDequeueEmpty() {
        // Arrange
        Queue<Integer> queue = new Queue<>();

        // Act and Assert
        assertThrows(NoSuchElementException.class, () -> {
            queue.dequeue();
        });
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }



    @Test
    void testDequeueNull() {
        // Arrange
        Queue<String> queue = new Queue<>();
        queue.enqueue(null);
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());

        // Act and Assert
        String item = queue.dequeue();
        assertNull(item);
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    void testPeekEmpty() {
        // Arrange
        Queue<String> queue = new Queue<>();

        // Act and Assert
        assertThrows(NoSuchElementException.class, () -> queue.peek());
    }


    @Test
    void testPeekSingle() {
        // Arrange
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(42);

        // Act and Assert
        assertEquals(42, queue.peek());
        assertFalse(queue.isEmpty());
        assertEquals(1, queue.size());

    }

    @Test
    void testPeekMultiple() {
        // Arrange
        Queue<Character> queue = new Queue<>();
        queue.enqueue('a');
        queue.enqueue('b');
        queue.enqueue('c');

        // Act and Assert
        assertEquals('a', queue.peek());
        assertFalse(queue.isEmpty());
        assertEquals(3, queue.size());
    }


}


