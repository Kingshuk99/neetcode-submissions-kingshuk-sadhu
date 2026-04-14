class TimeMap {
    class Data {
        String value;
        int timestamp;
        public Data(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
    private Map<String, List<Data>> map;
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
        int l = 0, r = dataList.size()-1;
        if(dataList.get(l).timestamp > timestamp) {
            return "";
        }
        String data = "";
        while(l<=r) {
            int m = l+(r-l)/2;
            if(dataList.get(m).timestamp <= timestamp) {
                data = dataList.get(m).value;
                l = m+1;
            } else {
                r = m-1;
            }
        }

        return data;
    }
}
