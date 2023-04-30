package datastructures.model;

import java.util.LinkedList;

 public class HashTable<K extends Comparable<K>, V> {
     private HashNode<K, V>[] table;
     private int size;

     public HashTable(int size) {
         table = new HashNode[size];
         this.size = size;
     }

     public V get(K key){
        int index = hash(key);
        HashNode<K,V> node = table[index];
        while(node != null){
            if(node.getKey().compareTo(key)==0){
                return node.getValue();
            }
            node = node.getNext();
        }
        return  null;
     }


     public void add(K key, V value){
         int index = hash(key);
         HashNode<K,V> node = new HashNode<K, V>(key,value);
         if(table[index] != null){
             table[index].setPrev(node);
             node.setNext(table[index]);
         }
         table[index]= node;
     }





     public void remove(K key) {
         int index=hash(key);
         HashNode<K,V> current = table[index];
         while(current != null){
             if(current.getKey().equals(key)){
                 if(current.getPrevious() == null){
                     table[index] = current.getNext();
                 }else {
                     current.getPrevious().setNext(current.getNext());
                 }
                 if (current.getNext() != null) {
                     current.getNext().setPrev(current.getPrevious());
                 }
                 return;
             }
             current = current.getNext();
         }
     }


     public int size() {

         return size;
     }
     public String print() {
         String msj = "";
         for (int i = 0; i < size; i++) {
             msj += "[ ";
             if (table[i] != null) {
                 HashNode<K, V> node = table[i];
                 while (node != null) {
                     if (node.getNext() == null) {
                         msj += node.getValue().toString() + ". ";
                     } else {
                         msj += node.getValue().toString() + ", ";
                     }
                     node = node.getNext();
                 }

             }
             msj += "]\n";

         }
         return msj;
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

     public void setSize(int size){
         this.size =size;
     }

     public HashNode<K, V>[] getList() {
         return table;
     }

     public void setList(HashNode<K, V>[] table) {
         this.table = table;
     }

     public int hash(K key){
         int hash = key.hashCode();
         hash = hash < 0 ? -hash : hash;
         return hash % size;
     }
 }