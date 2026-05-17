class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adj = new HashMap<>();

        for(List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            adj.computeIfAbsent(src, key -> new PriorityQueue<>())
            .offer(dst);
        }

        List<String> ans = new ArrayList<>();
        dfs(adj, "JFK", ans);

        Collections.reverse(ans);
        return ans;
    }

    private void dfs(Map<String, PriorityQueue<String>> adj, 
    String src, List<String> ans) {
        PriorityQueue<String> queue = adj.get(src);

        while(queue != null && !queue.isEmpty()) {
            String dst = queue.poll();
            dfs(adj, dst, ans);
        }

        ans.add(src);
    }
}
