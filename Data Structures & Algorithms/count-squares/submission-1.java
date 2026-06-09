class CountSquares {
    private Map<Integer, Map<Integer, Integer>> pointsCount;
    public CountSquares() {
        pointsCount = new HashMap<>();
    }
    
    public void add(int[] point) {
        int x = point[0], y = point[1];
        pointsCount.putIfAbsent(x, new HashMap<>());
        pointsCount.get(x).put(y, pointsCount.get(x).getOrDefault(y, 0) + 1);
    }
    
    public int count(int[] point) {
        int res = 0, x1 = point[0], y1 = point[1];

        if(!pointsCount.containsKey(x1)) {
            return res;
        }

        for(int y2 : pointsCount.get(x1).keySet()) {
            int side = y2 - y1;
            if(side == 0) {
                continue;
            }
            int x3 = x1 + side, x4 = x1 - side;
            res += pointsCount.get(x1).get(y2) * pointsCount.getOrDefault(x3, 
            new HashMap<>()).getOrDefault(y1, 0) * pointsCount.getOrDefault(x3, 
            new HashMap<>()).getOrDefault(y2, 0);
            
            res += pointsCount.get(x1).get(y2) * pointsCount.getOrDefault(x4, 
            new HashMap<>()).getOrDefault(y1, 0) * pointsCount.getOrDefault(x4, 
            new HashMap<>()).getOrDefault(y2, 0);
        }
        return res;
    }
}
