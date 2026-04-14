class TimeMap {
    class Data {
        private String value;
        private int timestamp;
        Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
        String getValue() {
            return this.value;
        }
        int getTimestamp() {
            return this.timestamp;
        }
    }
    private Map<String, List<Data>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        this.map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Data> values = this.map.getOrDefault(key, new ArrayList<>());
        int l = 0, h = values.size()-1;
        String ans = "";
        while(l <= h) {
            int mid = l + (h-l)/2;
            if (values.get(mid).getTimestamp() <= timestamp) {
                ans = values.get(mid).getValue();
                l = mid+1;
            } else {
                h = mid-1;
            }
        }
        return ans;
    }
}
