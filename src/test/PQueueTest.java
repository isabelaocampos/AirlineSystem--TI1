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
    public void testIsEmpty() {
        PQueue<Integer> pq = new PQueue<>();
        assertTrue(pq.isEmpty());

        pq.insert(1);
        assertFalse(pq.isEmpty());
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

