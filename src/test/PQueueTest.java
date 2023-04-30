package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import datastructures.model.PQueue;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class PQueueTest {

    private PQueue<Integer> pq;

    @Test
    void testInsert() {
        PQueue<Integer> queue = new PQueue<Integer>();
        assertTrue(queue.isEmpty());
        queue.insert(3);
        queue.insert(1);
        queue.insert(4);
        queue.insert(1);
        assertFalse(queue.isEmpty());
        assertEquals(4, queue.size());
    }

    @Test
    void testRemove() {
        PQueue<Integer> queue = new PQueue<Integer>();
        queue.insert(3);
        queue.insert(1);
        queue.insert(4);
        queue.insert(1);
        assertEquals(4, queue.size());
        assertEquals(4, (int) queue.remove());
        assertEquals(3, queue.size());
        assertEquals(3, (int) queue.remove());
        assertEquals(2, queue.size());
        assertEquals(1, (int) queue.remove());
        assertEquals(1, queue.size());
        assertEquals(1, (int) queue.remove());
        assertEquals(0, queue.size());
        assertThrows(NoSuchElementException.class, () -> queue.remove());
    }
    @Test
    public void testInsertionAndRemoval() {
        PQueue<Integer> pq = new PQueue<>();
        pq.insert(7);
        pq.insert(2);
        pq.insert(5);
        pq.insert(1);
        pq.insert(10);
        pq.insert(3);

        assertEquals(6, pq.size());
        assertFalse(pq.isEmpty());

        assertEquals(10, pq.remove().intValue());
        assertEquals(7, pq.remove().intValue());
        assertEquals(5, pq.remove().intValue());
        assertEquals(3, pq.remove().intValue());
        assertEquals(2, pq.remove().intValue());
        assertEquals(1, pq.remove().intValue());

        assertTrue(pq.isEmpty());
    }
    @Test
    public void testIsEmpty() {
        assertEquals(true, pq.isEmpty());
        pq.insert(5);
        assertEquals(false, pq.isEmpty());
        pq.remove();
        assertEquals(false, pq.isEmpty());
        pq.remove();
        pq.remove();
        pq.remove();
        pq.remove();
        assertEquals(true, pq.isEmpty());
    }

    @Test
    public void testInsertionAndRemovalWithDuplicates() {
        PQueue<Integer> pq = new PQueue<>();
        pq.insert(7);
        pq.insert(2);
        pq.insert(5);
        pq.insert(1);
        pq.insert(5);
        pq.insert(10);
        pq.insert(3);
        pq.insert(7);

        assertEquals(8, pq.size());
        assertFalse(pq.isEmpty());

        assertEquals(10, pq.remove().intValue());
        assertEquals(7, pq.remove().intValue());
        assertEquals(7, pq.remove().intValue());
        assertEquals(5, pq.remove().intValue());
        assertEquals(5, pq.remove().intValue());
        assertEquals(3, pq.remove().intValue());
        assertEquals(2, pq.remove().intValue());
        assertEquals(1, pq.remove().intValue());

        assertTrue(pq.isEmpty());
    }

    @Test
    public void testRandomInsertionAndRemoval() {
        PQueue<Integer> pq = new PQueue<>();

        Random rand = new Random();
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10000);
            pq.insert(arr[i]);
        }

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            assertEquals(arr[arr.length - 1 - i], pq.remove().intValue());
        }

        assertTrue(pq.isEmpty());
    }


}

