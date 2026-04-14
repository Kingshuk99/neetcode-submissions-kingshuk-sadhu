class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();
        Collections.sort(tickets, (a, b) -> {
            if(a.get(0).equals(b.get(0))) {
                return a.get(1).compareTo(b.get(1));
            }
            return a.get(0).compareTo(b.get(0));
        });
        for(List<String> ticket : tickets) {
            adj.computeIfAbsent(ticket.get(0), k -> new ArrayList<>())
            .add(ticket.get(1));
        }

        int stops = tickets.size()+1;
        List<String> ans = new ArrayList<>();
        ans.add("JFK");
        if(dfs(adj, ans, stops, "JFK")) {
            return ans;
        }

        return new ArrayList<>();
    }

    private boolean dfs(Map<String, List<String>> adj, List<String> ans, int stops, 
    String src) {
        if(ans.size()==stops) {
            return true;
        }

        if(!adj.containsKey(src)) {
            return false;
        }
        
        for(int i=0; i<adj.get(src).size(); i++) {
            String dst = adj.get(src).get(i);
            ans.add(dst);
            adj.get(src).remove(i);
            if(dfs(adj, ans, stops, dst)) {
                return true;
            }
            adj.get(src).add(i, dst);
            ans.remove(ans.size()-1);
        }

        return false;
    }
}
