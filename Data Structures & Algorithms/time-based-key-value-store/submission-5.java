class TimeMap {
    class MetaData {
        String data;
        int timestamp;
        MetaData(String data, int timestamp) {
            this.data = data;
            this.timestamp = timestamp;
        }
    }
    private Map<String, List<MetaData>> store;
    public TimeMap() {
        this.store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new ArrayList<>()).add(new MetaData(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<MetaData> values = store.getOrDefault(key, new ArrayList<>());

        int l = 0, h = values.size() - 1;
        String value = "";

        while(l <= h) {
            int m = l + (h - l)/2;
            if(values.get(m).timestamp <= timestamp) {
                value = values.get(m).data;
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        return value;
    }
}
