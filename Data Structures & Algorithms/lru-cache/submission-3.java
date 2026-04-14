class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        protected Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }
    private Map<Integer, Node> cache;
    private int capacity;
    private Node head;
    private Node tail;
    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        remove(node);
        insert(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            node.value = value;
            insert(node);
            return;
        }
        Node node = new Node(key, value);
        insert(node);
        cache.put(key, node);
        if(cache.size()>capacity) {
            node = head.next;
            cache.remove(node.key);
            remove(node);
        }
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node) {
        Node prev = tail.prev;
        prev.next = node;
        node.prev = prev;
        node.next = tail;
        tail.prev = node;
    }
}
