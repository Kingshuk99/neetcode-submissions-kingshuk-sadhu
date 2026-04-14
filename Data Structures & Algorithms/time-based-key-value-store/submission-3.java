class TimeMap {
    class Data {
        String value;
        int timestamp;
        protected Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    Map<String, List<Data>> map;
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        this.map.computeIfAbsent(key, k -> new ArrayList<>())
        .add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) {
            return "";
        }
        List<Data> dataList = map.get(key);
        int low = 0, high = dataList.size()-1;
        String ans = "";
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(dataList.get(mid).timestamp <= timestamp) {
                ans = dataList.get(mid).value;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
