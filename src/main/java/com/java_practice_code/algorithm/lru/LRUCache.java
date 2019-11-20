package com.java_practice_code.algorithm.lru;

import java.util.HashMap;

/**
 * description: Least Recently Used(最近最少使用),LRU缓存算法的java实现，参考资料：https://www.jianshu.com/p/95b6f10ed1f3
 *
 * @author lujingxiao
 */
public class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<>();
    private Node head = null;
    private Node end = null;

    LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            list();
            return n.value;
        }
        System.out.println("error, key " + key + " is not exists");
        return -1;
    }

    private void remove(Node n) {
        if (n.pre != null) {
            n.pre.next = n.next;
        } else {
            head = n.next;
        }

        if (n.next != null) {
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }
    }

    private void setHead(Node n) {
        n.next = head;
        n.pre = null;
        if (head != null) {
            head.pre = n;
        }
        head = n;
        if (end == null) {
            end = head;
        }
    }

    void set(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node created = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
                setHead(created);
            } else {
                setHead(created);
            }
            map.put(key, created);
        }
        list();
    }

    private void list() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.value + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    class Node {
        int key;
        int value;
        private Node pre;
        private Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
