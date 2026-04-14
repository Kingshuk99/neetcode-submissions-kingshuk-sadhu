class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, List<String>> adj = formGraph(tickets);

        List<String> ans = new ArrayList<>();
        int ports = tickets.size()+1;
        ans.add("JFK");
        if(dfs(adj, ans, ports, "JFK")) {
            return ans;
        }
        return new ArrayList<>();
    }

    private boolean dfs(Map<String, List<String>> adj, List<String> ans, int ports, String src) {
        System.out.println(src);
        if(ans.size()==ports) {
            return true;
        }
        List<String> neigh = adj.get(src);
        for(int i=0; i<neigh.size(); i++) {
            String dst = neigh.get(i);
            ans.add(dst);
            adj.get(src).remove(i);
            if(dfs(adj, ans, ports, dst)) {
                return true;
            }
            ans.remove(ans.size()-1);
            adj.get(src).add(i, dst);
        }
        return false;
    }
    private Map<String, List<String>> formGraph(List<List<String>> tickets) {
        Collections.sort(tickets, (a, b) -> {
            if(a.get(0).compareTo(b.get(0))==0) {
                return a.get(1).compareTo(b.get(1));
            }
            return a.get(0).compareTo(b.get(0));
        });

        Map<String, List<String>> adj = new HashMap<>();

        for(List<String> ticket : tickets) {
            if(adj.get(ticket.get(0))==null) {
                adj.put(ticket.get(0), new ArrayList<>());
            }
            if(adj.get(ticket.get(1))==null) {
                adj.put(ticket.get(1), new ArrayList<>());
            }
            adj.get(ticket.get(0)).add(ticket.get(1));
        }

        return adj;
    }
}
