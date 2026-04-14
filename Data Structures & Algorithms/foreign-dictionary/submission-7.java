class Solution {
    public String foreignDictionary(String[] words) {
        //Topological sort
        Map<Character, Set<Character>> adj = new HashMap<>();

        for (String word : words) {
            for (char c : word.toCharArray()) {
                adj.putIfAbsent(c, new HashSet<>());
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }
            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        Map<Character, Integer> inDeg = new HashMap<>();

        for(char key : adj.keySet()) {
            if(!inDeg.containsKey(key)) {
                inDeg.put(key, 0);
            }

            for(char ch : adj.get(key)) {
                if(!inDeg.containsKey(ch)) {
                    inDeg.put(ch, 0);
                }
                inDeg.put(ch, inDeg.get(ch)+1);
            }
        }

        Queue<Character> q = new LinkedList<>();
        List<Character> res = new ArrayList<>();

        for(char key : inDeg.keySet()) {
            if(inDeg.get(key)==0) {
                q.offer(key);
            }
        }

        while(!q.isEmpty()) {
            char ch = q.poll();
            res.add(ch);

            for(char c : adj.get(ch)) {
                inDeg.put(c, inDeg.get(c)-1);
                if(inDeg.get(c)==0) {
                    q.offer(c);
                }
            }
        }

        if(res.size()!=adj.size()) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : res) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
