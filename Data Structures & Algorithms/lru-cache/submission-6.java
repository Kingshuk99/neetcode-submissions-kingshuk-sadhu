class LRUCache {
    private Map<Integer, Integer> cache;
    public LRUCache(int capacity) {
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }
    
    public int get(int key) {
        return this.cache.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        this.cache.put(key, value);
    }
}
