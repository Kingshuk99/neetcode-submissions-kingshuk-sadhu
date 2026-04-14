class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();
        List<String> ans = new ArrayList<>();

        int totalStops = tickets.size()+1;

        Collections.sort(tickets, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> a, List<String> b) {
                if(a.get(0).compareTo(b.get(0))==0) {
                    return a.get(1).compareTo(b.get(1));
                }
                return a.get(0).compareTo(b.get(0));
            }
        });

        for(List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            adj.computeIfAbsent(src, key -> new ArrayList<>());
            adj.get(src).add(dst);
        }
        ans.add("JFK");
        dfs(adj, totalStops, ans, "JFK");
        return ans;
    }

    public boolean dfs(Map<String, List<String>> adj, int stops, 
    List<String> ans, String src) {
        if(ans.size()==stops) {
            return true;
        }

        List<String> neighbors = adj.get(src);
        if(neighbors==null) {
            return false;
        }

        for(int i=0; i<neighbors.size(); i++) {
            String dst = neighbors.get(i);
            adj.get(src).remove(i);

            ans.add(dst);

            if(dfs(adj, stops, ans, dst)) {
                return true;
            }

            ans.remove(ans.size()-1);
            adj.get(src).add(i, dst);
        }

        return false;
    }
}
