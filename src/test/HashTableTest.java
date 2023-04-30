package test;

import datastructures.model.HashTable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

 public class HashTableTest {
    private HashTable<Integer, String> hashTable;

    @Before
    public void setUp() {
        hashTable = new HashTable<>(10);
    }

    @Test
    public void testAddAndGet() {
        HashTable<String, Integer> table = new HashTable<>(5);
        table.add("a", 1);
        table.add("b", 2);
        table.add("c", 3);
        assertEquals(Integer.valueOf(1), table.get("a"));
        assertEquals(Integer.valueOf(2), table.get("b"));
        assertEquals(Integer.valueOf(3), table.get("c"));
    }

    @Test
    public void testRemove() {
        HashTable<String, Integer> table = new HashTable<>(5);
        table.add("a", 1);
        table.add("b", 2);
        table.add("c", 3);
        table.remove("b");
        assertNull(table.get("b"));
        assertEquals(Integer.valueOf(1), table.get("a"));
        assertEquals(Integer.valueOf(3), table.get("c"));
    }
    @Test
    public void testIsEmpty() {
        HashTable<String, Integer> table = new HashTable<>(5);
        assertTrue(table.isEmpty());
        table.add("a", 1);
        table.add("b", 2);
        table.add("c", 3);
        assertFalse(table.isEmpty());
        table.clear();
        assertTrue(table.isEmpty());
    }
    @Test
    public void testNullKeyAndValue() {
        HashTable<String, Integer> table = new HashTable<>(5);
        table.add("a", null);
        assertNull(table.get("a"));
        table.add(null, 1);
        assertEquals(Integer.valueOf(1), table.get(null));
        table.add(null, null);
        assertNull(table.get(null));
    }
    @Test
    public void testAddMultipleElements() {
        HashTable<String, Integer> hashTable = new HashTable<>(5);
        hashTable.add("a", 1);
        hashTable.add("b", 2);
        hashTable.add("c", 3);
        hashTable.add("d", 4);
        hashTable.add("e", 5);
        assertEquals(5, hashTable.size());
    }
    @Test
    public void testAddAndGetElement() {
        HashTable<String, Integer> hashTable = new HashTable<>(5);
        hashTable.add("a", 1);
        assertEquals(Integer.valueOf(1), hashTable.get("a"));
    }
    @Test
    public void testAddMultipleElementsSameKey() {
        HashTable<String, Integer> hashTable = new HashTable<>(5);
        hashTable.add("a", 1);
        hashTable.add("b", 2);
        hashTable.add("c", 3);
        hashTable.add("a", 4);
        assertEquals(Integer.valueOf(4), hashTable.get("a"));
    }
    @Test
    public void testAddAndRemoveElement() {
        HashTable<String, Integer> hashTable = new HashTable<>(5);
        hashTable.add("a", 1);
        hashTable.remove("a");
        assertEquals(0, hashTable.size());
    }
    @Test
    public void testPrintElements() {
        HashTable<String,Integer> hashTable = new HashTable<>(5);
        hashTable.add("a", 1);
        hashTable.add("b", 2);
        hashTable.add("c", 3);
        hashTable.add("d", 4);
        hashTable.add("e", 5);
        String expectedOutput = "[ 5, 4, 3, 2, 1 ]\n[ ]\n[ ]\n[ ]\n[ ]\n";
        assertEquals(expectedOutput, hashTable.print());
    }

}

