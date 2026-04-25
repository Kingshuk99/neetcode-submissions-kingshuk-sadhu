class Twitter {
    private int count;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, List<int[]>> tweetMap; 
    public Twitter() {
        this.count = 0;
        this.followMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.computeIfAbsent(userId, key -> new ArrayList<>())
        .add(new int[]{count--, tweetId});
        if(tweetMap.get(userId).size() > 10) {
            tweetMap.get(userId).remove(0);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        followMap.computeIfAbsent(userId, key -> new HashSet<>())
        .add(userId);

        if(followMap.get(userId).size() >= 10) {
            PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b[0], a[0])
            );

            for(int followeeId : followMap.get(userId)) {
                if(!tweetMap.containsKey(followeeId)) {
                    continue;
                }
                List<int[]> tweets = tweetMap.get(followeeId);
                int ind = tweets.size() - 1;
                int[] tweet = tweets.get(0);
                maxHeap.offer(new int[]{tweet[0], tweet[1], followeeId, ind - 1});

                if(maxHeap.size() > 10) {
                    maxHeap.poll();
                }
            }

            while(!maxHeap.isEmpty()) {
                int[] top = maxHeap.poll();
                minHeap.offer(new int[]{top[0], top[1], top[2], top[3]});
            }
        } else {
            for(int followeeId : followMap.get(userId)) {
                if(!tweetMap.containsKey(followeeId)) {
                    continue;
                }
                List<int[]> tweets = tweetMap.get(followeeId);
                int ind = tweets.size() - 1;
                int[] tweet = tweets.get(ind);
                minHeap.offer(new int[]{tweet[0], tweet[1], 
                followeeId, ind - 1});
            }
        }

        while(!minHeap.isEmpty() && ans.size() < 10) {
            int[] tweet = minHeap.poll();
            ans.add(tweet[1]);
            int nextInd = tweet[3];
            if(nextInd >= 0) {
                List<int[]> tweets = tweetMap.get(tweet[2]);
                int[] nextTweet = tweets.get(nextInd);
                minHeap.offer(new int[]{nextTweet[0], nextTweet[1], tweet[2], nextInd - 1});
            }
        }

        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        followMap.computeIfAbsent(followerId, key -> new HashSet<>())
        .add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.computeIfPresent(followerId, (key, val) -> {
            val.remove(followeeId);
            return val;
        });
    }
}
