class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        for(int i=1; i<words.length; i++) {
            String first = words[i-1], second = words[i];
            if(first.length()>second.length() && 
            first.substring(0, second.length()).equals(second)) {
                return "";
            }
            int len = Math.min(first.length(), second.length());
            for(int j=0; j<len; j++) {
                if(first.charAt(j)==second.charAt(j)) {
                    continue;
                }
                adj.get(first.charAt(j)).add(second.charAt(j));
                break;
            }
        }

        Set<Character> vis = new HashSet<>();
        Set<Character> recStack = new HashSet<>();

        List<Character> res = new ArrayList<>();

        for(char ch : adj.keySet()) {
            if(isCyclic(adj, ch, vis, res, recStack)) {
                return "";
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : res) {
            sb.append(ch);
        }
        sb.reverse();
        return sb.toString();
    }

    private boolean isCyclic(Map<Character, Set<Character>> adj, char ch, 
    Set<Character> vis, List<Character> res, Set<Character> recStack) {
        if(recStack.contains(ch)) {
            return true;
        }

        if(vis.contains(ch)) {
            return false;
        }

        vis.add(ch);
        recStack.add(ch);
        
        for(char neigh : adj.get(ch)) {
            if(isCyclic(adj, neigh, vis, res, recStack)) {
                return true;
            }
        }

        res.add(ch);
        recStack.remove(ch);
        return false;
    }
}
