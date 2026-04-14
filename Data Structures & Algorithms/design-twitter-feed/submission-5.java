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
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0]-b[0]));
        followMap.computeIfAbsent(userId, k -> new HashSet<>())
        .add(userId);
        List<Integer> ans = new ArrayList<>();

        for(int followee : followMap.get(userId)) {
            List<int[]> tweets = tweetMap.get(followee);
            if(tweets==null || tweets.size()<1) {
                continue;
            }
            int[] tweet = tweets.get(tweets.size()-1);
            minHeap.offer(new int[]{tweet[0], tweet[1], followee, tweets.size()-1});
        }

        while(!minHeap.isEmpty() && ans.size()<10) {
            int[] tweet = minHeap.poll();
            ans.add(tweet[1]);
            int ind = tweet[3];
            int followee = tweet[2];
            if(ind > 0) {
                int[] next = tweetMap.get(followee).get(ind-1);
                minHeap.offer(new int[] {next[0], next[1], followee, ind-1});
            }
        }
        return ans;
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
