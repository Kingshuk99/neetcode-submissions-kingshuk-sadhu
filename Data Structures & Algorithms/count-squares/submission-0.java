class CountSquares {
    List<int[]> points;
    Map<List<Integer>, Integer> count;
    public CountSquares() {
        points = new ArrayList<>();
        count = new HashMap<>();
    }
    
    public void add(int[] point) {
        points.add(point);
        List<Integer> pt = Arrays.asList(point[0], point[1]);
        if(!count.containsKey(pt)) {
            count.put(pt, 0);
        }
        count.put(pt, count.get(pt)+1);
    }
    
    public int count(int[] point) {
        int res = 0;
        for(int[] pt : points) {
            if(point[0]==pt[0] || point[1]==pt[1] || 
            Math.abs(point[0]-pt[0])!=Math.abs(point[1]-pt[1])) {
                continue;
            }
            List<Integer> pt1 = Arrays.asList(point[0], pt[1]);
            List<Integer> pt2 = Arrays.asList(pt[0], point[1]);

            if(count.containsKey(pt1) && count.containsKey(pt2)) {
                res += count.get(pt1)*count.get(pt2);
            }
        }
        return res;
    }
}
