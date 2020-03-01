package com.java_practice_code.util.map;


public class MyHashMap<K, V> {
    private Node<K, V>[] nodes;
    private int size;
    private int capacity = 8;

    private MyHashMap() {
        nodes = (Node<K, V>[]) new Node[capacity];
    }

    public int size() {
        return size;
    }

    public V put(K key, V value) {
        int index = key.hashCode() % nodes.length;
        for (Node<K, V> e = nodes[index]; e != null; e = e.next) {
            if (e.key.hashCode() == key.hashCode() && key.equals(e)) {
                V tmp = e.value;
                e.value = value;
                return tmp;
            }
        }
        nodes[index] = new Node<>(key, value, nodes[index]);
        size++;
        return value;
    }

    public V get(K key) {
        int index = key.hashCode() % capacity;
        Node<K, V> node = nodes[index];
        for (Node<K, V> e = node; e != null; e = e.next) {
            if (e.hashCode() == key.hashCode() && key.equals(e.key)) {
                return e.value;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        myHashMap.put(3, 3);
        myHashMap.put(4, 4);
        myHashMap.put(5, 5);
        myHashMap.put(6, 6);
        myHashMap.put(7, 7);
        myHashMap.put(8, 8);
        myHashMap.put(9, 9);
        System.out.println(myHashMap);
    }

    private class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        private Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }
    }
}
