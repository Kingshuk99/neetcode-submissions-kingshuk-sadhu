class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = drawEdges(words);
        if(adj==null) {
            return "";
        }

        Map<Character, Boolean> visited = new HashMap<>();
        List<Character> res = new ArrayList<>();

        for(char ch : adj.keySet()) {
            if(isCyclic(ch, visited, res, adj)) {
                return "";
            }
        }

        Collections.reverse(res);
        StringBuilder sb = new StringBuilder();
        for(char ch : res) {
            sb.append(ch);
        }

        return sb.toString();
    }

    private Map<Character, Set<Character>> drawEdges(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        for(int i=0; i<words.length-1; i++) {
            String word1 = words[i], word2 = words[i+1];
            int minLen = Math.min(word1.length(), word2.length());

            if(word1.length()>word2.length() && 
            word1.substring(0, minLen).equals(word2.substring(0, minLen))) {
                return null;
            }

            for(int j=0; j<minLen; j++) {
                if(word1.charAt(j)!=word2.charAt(j)) {
                    adj.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }

        return adj;
    }

    private boolean isCyclic(char ch, Map<Character, Boolean> visited, 
    List<Character> res, Map<Character, Set<Character>> adj) {
        if(visited.containsKey(ch)) {
            return visited.get(ch);
        }

        visited.put(ch, true);
        for(char c : adj.get(ch)) {
            if(isCyclic(c, visited, res, adj)) {
                return true;
            }
        }
        res.add(ch);
        visited.put(ch, false);
        return false;
    }
}
