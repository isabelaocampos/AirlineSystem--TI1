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
<<<<<<< HEAD
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
=======
    public void testPutIncrementsSize() {
        // arrange
        hashTable.add(1, "value1");
        hashTable.add(2, "value2");

        // assert
        assertEquals(2, hashTable.size());

        // arrange
        hashTable.add(3, "value3");

        // assert
        assertEquals(3, hashTable.size());
    }

    @Test
    public void testPutUpdatesValue() {
        // arrange
        hashTable.add(1, "value1");

        // act
        hashTable.add(1, "new_value1");

        // assert
        assertEquals("new_value1", hashTable.get(1));
>>>>>>> 3a0bb16f52c3a302a35feec53633c60471c146f1
    }
    @Test
<<<<<<< HEAD
    public void testIsEmpty() {
        HashTable<String, Integer> table = new HashTable<>(5);
        assertTrue(table.isEmpty());
        table.add("a", 1);
        table.add("b", 2);
        table.add("c", 3);
        assertFalse(table.isEmpty());
        table.clear();
        assertTrue(table.isEmpty());
=======
    public void testPutSameHash() {
        // arrange
        hashTable.add(1, "value1");
        hashTable.add(11, "value11");

        // assert
        assertEquals("value1", hashTable.get(1));
        assertEquals("value11", hashTable.get(11));
>>>>>>> 3a0bb16f52c3a302a35feec53633c60471c146f1
    }
    @Test
<<<<<<< HEAD
    public void testNullKeyAndValue() {
        HashTable<String, Integer> table = new HashTable<>(5);
        table.add("a", null);
        assertNull(table.get("a"));
        table.add(null, 1);
        assertEquals(Integer.valueOf(1), table.get(null));
        table.add(null, null);
        assertNull(table.get(null));
=======
    public void testGetExistingKey() {
        //Arrange
        hashTable.add(1, "value1");

        //Assert
        assertEquals("value1", hashTable.get(1));
>>>>>>> 3a0bb16f52c3a302a35feec53633c60471c146f1
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
<<<<<<< HEAD
    public void testAddAndGetElement() {
        HashTable<String, Integer> hashTable = new HashTable<>(5);
        hashTable.add("a", 1);
        assertEquals(Integer.valueOf(1), hashTable.get("a"));
=======
    public void testGetSameHash() {
        //Arrange
        hashTable.add(1, "value1");
        hashTable.add(11, "value11");

        //Assert
        assertEquals("value1", hashTable.get(1));
        assertEquals("value11", hashTable.get(11));
>>>>>>> 3a0bb16f52c3a302a35feec53633c60471c146f1
    }
    @Test
<<<<<<< HEAD
    public void testAddMultipleElementsSameKey() {
        HashTable<String, Integer> hashTable = new HashTable<>(5);
        hashTable.add("a", 1);
        hashTable.add("b", 2);
        hashTable.add("c", 3);
        hashTable.add("a", 4);
        assertEquals(Integer.valueOf(4), hashTable.get("a"));
=======
    public void testContainsKeyExisting() {
        //Arrange
        hashTable.add(1, "value1");

        //Assert
        assertTrue(hashTable.containsKey(1));
>>>>>>> 3a0bb16f52c3a302a35feec53633c60471c146f1
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

