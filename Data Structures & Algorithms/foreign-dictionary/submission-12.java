class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, List<Character>> adj = new HashMap<>();
        Map<Character, Integer> indeg = new HashMap<>();
        for(String word : words) {
            for(char ch : word.toCharArray()) {
                adj.putIfAbsent(ch, new ArrayList<>());
                indeg.putIfAbsent(ch, 0);
            }
        }

        for(int i = 0; i < words.length - 1; i++) {
            String word1 = words[i], word2 = words[i + 1];
            int n1 = word1.length(), n2 = word2.length();

            if(n1 > n2 && word1.substring(0, n2).equals(word2)) {
                return "";
            }

            for(int j = 0; j < Math.min(n1, n2); j++) {
                if(word1.charAt(j) == word2.charAt(j)) {
                    continue;
                }
                adj.get(word1.charAt(j)).add(word2.charAt(j));
                char ch = word2.charAt(j);
                indeg.put(ch, indeg.get(ch) + 1);
                break;
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for(char ch : indeg.keySet()) {
            if(indeg.get(ch) == 0) {
                queue.offer(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()) {
            char ch = queue.poll();
            sb.append(ch);
            for(char neigh : adj.get(ch)) {
                indeg.put(neigh, indeg.get(neigh) - 1);
                if(indeg.get(neigh) == 0) {
                    queue.offer(neigh);
                }
            }
        }

        return sb.length() == indeg.size() ? sb.toString() : "";
    }
}
