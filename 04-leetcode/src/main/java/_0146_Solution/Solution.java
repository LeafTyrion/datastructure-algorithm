package _0146_Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YeYaqiao
 * 146. LRU 缓存
 */

//自定义的双向链表


class Node {
    int key;
    int value;
    Node pre;
    Node next;

    public Node() {
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    int capacity;
    int size;
    Node head;
    Node tail;
    Map<Integer, Node> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        this.cache = new HashMap<>(capacity);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;
        Node node = cache.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            Node node = new Node(key, value);
            if (size == capacity) {
                int delKey = removeTailNode();
                cache.remove(delKey);
                size--;
            }
            cache.put(key, node);
            addToHead(node);
            size++;
        }
    }

    private int removeTailNode() {
        Node node = tail.pre;
        node.pre.next = tail;
        tail.pre = node.pre;
        return node.key;
    }

    private void addToHead(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    //需要注意不要使用辅助变量
    private void moveToHead(Node node) {
         node.pre.next = node.next;
         node.next.pre = node.pre;
         addToHead(node);
    }
}

public class Solution {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        cache.get(1);
        cache.get(2);
    }


    //利用 linkedHashMap api
//    class LRUCache {
//        int capacity;
//        LinkedHashMap<Integer, Integer> cache;
//
//        public LRUCache(int capacity) {
//            //是否按照访问顺序插入
//            this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
//                @Override
//                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//                    return cache.size() > capacity;
//                }
//            };
//            this.capacity = capacity;
//        }
//
//        public int get(int key) {
//            return cache.getOrDefault(key, -1);
//        }
//
//        public void put(int key, int value) {
//            cache.put(key, value);
//        }
//    }
}
