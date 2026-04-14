class LRUCache {
    class Node {
        int key;
        int val;
        Node next;
        Node prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this. next = null;
        }
    }

    private int cap;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if(!this.cache.containsKey(key)) {
            return -1;
        }
        Node node = this.cache.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(this.cache.containsKey(key)) {
            Node node = this.cache.get(key);
            node.val = value;
            remove(node);
            insert(node);
            return;
        }
        Node node = new Node(key, value);
        if(this.cap == 0) {
            Node temp = tail.prev;
            remove(temp);
            cache.remove(temp.key);
        } else {
            this.cap--;
        }
        this.cache.put(key, node);
        insert(node);
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }
}
