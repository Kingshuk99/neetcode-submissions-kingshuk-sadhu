class TimeMap {
    private Map<String, List<Pair<Integer, String>>> hash;
    public TimeMap() {
        this.hash = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!hash.containsKey(key)) {
            hash.put(key, new ArrayList<>());
        }
        hash.get(key).add(new Pair<>(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!hash.containsKey(key)) {
            return "";
        }

        List<Pair<Integer, String>> data = hash.get(key);
        int left = 0, right = data.size()-1;
        String ans = "";

        while(left <= right) {
            int mid = left + (right-left)/2;
            if(data.get(mid).key <= timestamp) {
                ans = data.get(mid).val;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    class Pair<K, V> {
        K key;
        V val;

        public Pair(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
}
