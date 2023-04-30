package test;

import datastructures.model.HashTable;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTest {
    private HashTable<Integer, String> hashTable;

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
    public void testHash() { //testeamos el método hash
        HashTable<Integer, String> table = new HashTable<>(10);

        // Verificar que los hashes para varias claves sean distintos
        int hash1 = table.hash(1);
        int hash2 = table.hash(2);
        int hash3 = table.hash(3);
        int hash4 = table.hash(4);

        assertNotEquals(hash1, hash2);
        assertNotEquals(hash2, hash3);
        assertNotEquals(hash3, hash4);
        assertNotEquals(hash4, hash1);

        // Verificar que el hash de la misma clave sea consistente
        int hash5 = table.hash(5);
        int hash6 = table.hash(5);

        assertEquals(hash5, hash6);
    }
    @Test
    public void testGet() { //** también probamos el get, pero en este caso insertamos valor-clave */
        HashTable<String, Integer> table = new HashTable<>(5);

        table.add("uno", 1);
        table.add("dos", 2);
        table.add("tres", 3);

        assertEquals(1, (int) table.get("uno")); //** se comprueba que se puedan recuperar los valores */
        assertEquals(2, (int) table.get("dos")); //** utilizando las claves correspondientes  */
        assertEquals(3, (int) table.get("tres"));
    }


}