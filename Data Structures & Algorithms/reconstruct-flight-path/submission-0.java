class Solution {
    List<String> res = new ArrayList<>();
    Map<String, List<String>> adj = new HashMap<>();
    int n = 0;

    public List<String> findItinerary(List<List<String>> tickets) {
        n = tickets.size();
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
            String src = ticket.get(0);
            String dst = ticket.get(1);

            if(adj.get(src)==null) {
                adj.put(src, new ArrayList<>());
            }
            adj.get(src).add(dst);
        }

        res.add("JFK");

        dfs("JFK");
        return res;
    }

    private boolean dfs(String src) {
        if(res.size()==n+1) {
            return true;
        }

        if(!adj.containsKey(src)) {
            return false;
        }

        List<String> destinations = new ArrayList<>(adj.get(src));

        for(int i=0; i<destinations.size(); i++) {
            res.add(destinations.get(i));
            adj.get(src).remove(i);
            if(dfs(destinations.get(i))) {
                return true;
            }
            adj.get(src).add(i, destinations.get(i));
            res.remove(res.size()-1);
        }
        return false;
    }
}
