package datastructures.model;

import java.util.LinkedList;

 public class HashTable<K, V> {
     private LinkedList<Entry<K, V>>[] table;
     private int size;

     private static class Entry<K, V> {
         K key;
         V value;

         public Entry(K key, V value) {
             this.key = key;
             this.value = value;
         }
     }

     public HashTable(int capacity) {
         table = new LinkedList[capacity];
         size = 0;
     }

     public void put(K key, V value) {
         if (key == null) {
             throw new IllegalArgumentException("Key cannot be null");
         }

         int hash = key.hashCode() % table.length;

         if (table[hash] == null) {
             table[hash] = new LinkedList<>();
         }

         for (Entry<K, V> entry : table[hash]) {
             if (entry.key.equals(key)) {
                 entry.value = value;
                 return;
             }
         }

         table[hash].add(new Entry<>(key, value));
         size++;
     }


     public V get(K key) {
         int hash = key.hashCode() % table.length;

         if (table[hash] == null) {
             return null;
         }

         for (Entry<K, V> entry : table[hash]) {
             if (entry.key.equals(key)) {
                 return entry.value;
             }
         }

         return null;
     }


     public boolean containsKey(K key) {
         int hash = key.hashCode() % table.length;

         if (table[hash] == null) {
             return false;
         }

         for (Entry<K, V> entry : table[hash]) {
             if (entry.key.equals(key)) {
                 return true;
             }
         }

         return false;
     }


     public V remove(K key) {
         int hash = key.hashCode() % table.length;

         if (table[hash] == null) {
             return null;
         }

         for (Entry<K, V> entry : table[hash]) {
             if (entry.key.equals(key)) {
                 table[hash].remove(entry);
                 size--;
                 return entry.value;
             }
         }

         return null;
     }


     public int size() {
         return size;
     }


     public boolean isEmpty() {
         return size == 0;

     }
     public void clear(){
         for (int i = 0; i < table.length; i++) {
             table[i] = null;
         }

         size = 0;
     }
 }