package _0146_Solution;

import java.util.Map;

/**
 * @author YeYaqiao
 * 146. LRU 缓存
 */

//自定义的双向链表
class MyList {
   private int key;
   private int value;
   private MyList pre;
   private MyList next;

    public MyList() {
    }

    public MyList(int key, int value) {
        this.key = key;
        this.value = value;
    }

    //注意，顺序不能乱，引用指向顺序乱了会导致对象丢失
    private void addToHead(MyList node, MyList head) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(MyList node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void moveToHead(MyList node, MyList head) {
        removeNode(node);
        addToHead(node, head);
    }

    private MyList removeTail(MyList tail) {
        MyList res = tail.pre;
        removeNode(res);
        return res;
    }
}

public class Solution {


    class LRUCache {

        private Map<Integer, MyList> cache;
        private int capacity;
        private MyList head, tail;
        private MyList list=new MyList();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new MyList();
            tail = new MyList();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            MyList node=cache.get(key);
            if(node==null)
                return -1;
            list.re
        }

        public void put(int key, int value) {

        }

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
//                    return cache.size() == capacity;
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
