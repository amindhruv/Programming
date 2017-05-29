import java.util.HashMap;

public class LRUCache {
    class QNode {
        int key, value;
        QNode prev, next;

        QNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private QNode head, tail;
    private HashMap<Integer, QNode> addressMap;

    private LRUCache(int capacity) {
        this.capacity = capacity;
        this.addressMap = new HashMap<>();
    }

    private void add(QNode node) {
        if (this.head == null) {
            this.head = this.tail = node;
            return;
        }
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
    }

    private void remove(QNode node) {
        if (this.head == null) return;
        if (this.head == this.tail && this.head == node) {
            this.head = this.tail = null;
            return;
        }
        if (this.head == node) {
            this.head.next.prev = null;
            this.head = this.head.next;
            return;
        }
        if (this.tail == node) {
            this.tail.prev.next = null;
            this.tail = this.tail.prev;
            return;
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private int get(int key) {
        if (!this.addressMap.containsKey(key)) return -1;
        QNode node = this.addressMap.get(key);
        this.moveFirst(node);
        return node.value;
    }

    private void put(int key, int value) {
        if (this.addressMap.containsKey(key)) {
            QNode node = this.addressMap.get(key);
            this.moveFirst(node);
            node.value = value;
            return;
        }
        if (this.addressMap.size() >= this.capacity) {
            int id = this.tail.key;
            this.removeLast();
            this.addressMap.remove(id);
        }
        QNode node = new QNode(key, value);
        this.addressMap.put(key, node);
        this.add(node);
    }

    private void moveFirst(QNode node) {
        this.remove(node);
        this.add(node);
    }

    private void removeLast() {
        this.remove(this.tail);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 10);
        lruCache.put(5, 12);
        System.out.println(lruCache.get(5));        //returns 12
        System.out.println(lruCache.get(1));        //returns 10
        System.out.println(lruCache.get(10));       //returns -1
        lruCache.put(6, 14);    //this pushes out key = 5 as LRU is full.
        System.out.println(lruCache.get(5));        //returns -1
    }
}