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
    }

    @Test
    public void testPutSameHash() {
        // arrange
        hashTable.add(1, "value1");
        hashTable.add(11, "value11");

        // assert
        assertEquals("value1", hashTable.get(1));
        assertEquals("value11", hashTable.get(11));
    }


    @Test
    public void testGetExistingKey() {
        //Arrange
        hashTable.add(1, "value1");

        //Assert
        assertEquals("value1", hashTable.get(1));
    }

    @Test
    public void testGetNonExistingKey() {
        //Assert: se verifica que la clave 1 no existe en la tabla hash
        assertNull(hashTable.get(1));
    }

    @Test
    public void testGetSameHash() {
        //Arrange
        hashTable.add(1, "value1");
        hashTable.add(11, "value11");

        //Assert
        assertEquals("value1", hashTable.get(1));
        assertEquals("value11", hashTable.get(11));
    }

    @Test
    public void testContainsKeyExisting() {
        //Arrange
        hashTable.add(1, "value1");

        //Assert
        assertTrue(hashTable.containsKey(1));
    }


    @Test
    public void testContainsKeyNonExisting() {
        //Assert
        assertFalse(hashTable.containsKey(1));
    }

    @Test
    public void testContainsKeySameHash() {
        //Arrange
        hashTable.put(1, "value1");
        hashTable.put(11, "value11");

        //Assert
        assertTrue(hashTable.containsKey(1));
        assertTrue(hashTable.containsKey(11));
    }

    @Test
    public void testClearNonEmptyTable() {
        //Arrange
        hashTable.put(1, "value1");
        hashTable.put(2, "value2");

        //Act
        hashTable.clear();

        //Assert
        assertEquals(0, hashTable.size());
        assertNull(hashTable.get(1));
        assertNull(hashTable.get(2));
    }

    @Test
    public void testClearEmptyTable() {
        //Act
        hashTable.clear();

        //Assert
        assertEquals(0, hashTable.size());
    }


    @Test
    public void testRemoveExistingKey() {
        //Arrange
        hashTable.put(1, "value1");

        //Act
        String removedValue = hashTable.remove(1);

        //Assert
        assertEquals("value1", removedValue);
        //Assert
        assertNull(hashTable.get(1));
        //Assert
        assertEquals(0, hashTable.size());
    }

    @Test
    public void testRemoveNonExistingKey() {
        //Assert: se verifica que intentar remover una clave que no existe, para que devuelva null
        assertNull(hashTable.remove(1));
    }

    @Test
    public void testRemoveSameHash() {
        //Arrange
        hashTable.put(1, "value1");
        hashTable.put(11, "value11");

        //Act
        String removedValue = hashTable.remove(1);

        //Assert
        assertEquals("value1", removedValue);
        //Assert
        assertNull(hashTable.get(1));
        //Assert
        assertEquals("value11", hashTable.get(11));
        //Assert
        assertEquals(1, hashTable.size());
    }

}
