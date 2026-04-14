class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // DFS
        // Collections.sort(tickets, (a, b) -> {
        //     if(a.get(0).equals(b.get(0))) {
        //         return a.get(1).compareTo(b.get(1));
        //     }
        //     return a.get(0).compareTo(b.get(0));
        // });

        // Map<String, List<String>> adj = new HashMap<>();
        // for(List<String> ticket : tickets) {
        //     adj.computeIfAbsent(ticket.get(0), key -> new ArrayList<>())
        //     .add(ticket.get(1));
        // }

        // List<String> ans = new ArrayList<>();
        // ans.add("JFK");

        // if(dfs(adj, ans, "JFK", tickets.size()+1)) {
        //     return ans;
        // }

        // return new ArrayList<>();

        // Hierholzer's Algorithm
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for(List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), key -> new PriorityQueue<>())
            .offer(ticket.get(1));
        }

        List<String> ans = new ArrayList<>();
        hierholzerDfs(adj, ans, "JFK");
        Collections.reverse(ans);
        return ans;
    }

    private void hierholzerDfs(Map<String, PriorityQueue<String>> adj, 
    List<String> ans, String src) {
        PriorityQueue<String> minHeap = adj.get(src);
        while(minHeap!=null && !minHeap.isEmpty()) {
            String next = minHeap.poll();
            hierholzerDfs(adj, ans, next);
        }

        ans.add(src);
    }

    // private boolean dfs(Map<String, List<String>> adj, List<String> ans, 
    // String src, int stops) {
    //     if(ans.size()==stops) {
    //         return true;
    //     }

    //     if(!adj.containsKey(src)) {
    //         return false;
    //     }

    //     for(int i=0; i<adj.get(src).size(); i++) {
    //         String dst = adj.get(src).get(i);
    //         adj.get(src).remove(i);
    //         ans.add(dst);
    //         if(dfs(adj, ans, dst, stops)) {
    //             return true;
    //         }
    //         adj.get(src).add(i, dst);
    //         ans.remove(ans.size()-1);
    //     }

    //     return false;
    // }
}
