class LRUCache {
    private Node head;
    int capacity;
    Map<Integer, Integer> hashMap;
    public LRUCache(int capacity) {
        this.head = new Node(-1);
        this.capacity = capacity;
        this.hashMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!hashMap.containsKey(key)) {
            return -1;
        }
        updatePosition(head, key);
        return hashMap.get(key);
    }
    
    public void put(int key, int value) {
        if(hashMap.containsKey(key)) {
            updatePosition(head, key);
            hashMap.put(key, value);
            return;
        }

        Node temp = head;
        while(temp.next!=null) {
            temp = temp.next;
        }
        temp.next = new Node(key);
        hashMap.put(key, value);
        capacity--;
        if(capacity<0) {
            capacity = 0;
            Node leastUsed = head.next;
            hashMap.remove(leastUsed.val);
            head.next = head.next.next;
        }
    }
    private void updatePosition(Node node, int key) {
        while(node.next.val!=key) {
            node = node.next;
        }

        Node curr = node.next;
        node.next = node.next.next;
        curr.next = null;

        while(node.next!=null) {
            node = node.next;
        }

        node.next = curr;
    }
    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            next = null;
        } 
    }
}
