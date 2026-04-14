class Twitter {
    private int count;
    private Map<Integer, List<int[]>> tweetMap;
    private Map<Integer, Set<Integer>> followMap;
    public Twitter() {
        count = 0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, k -> new ArrayList<>())
        .add(new int[]{count--, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        followMap.computeIfAbsent(userId, k -> new HashSet<>())
        .add(userId);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0]-b[0]));
        for(int followee : followMap.get(userId)) {
            if(tweetMap.containsKey(followee)) {
                List<int[]> tweets = tweetMap.get(followee);
                int index = tweetMap.get(followee).size() - 1;
                int[] tweet = tweets.get(index);
                minHeap.offer(new int[] {tweet[0], tweet[1], index, followee});
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!minHeap.isEmpty() && res.size() < 10) {
            int[] curr = minHeap.poll();
            res.add(curr[1]);
            int index = curr[2];
            int followee = curr[3];
            if(index > 0) {
                int[] tweet = tweetMap.get(followee).get(index - 1);
                minHeap.offer(new int[] {tweet[0], tweet[1], index - 1, followee});
            }
        }

        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, k -> new HashSet<>())
        .add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.computeIfPresent(followerId, (k, v) -> {
            v.remove(followeeId);
            return v;
        });
    }
}