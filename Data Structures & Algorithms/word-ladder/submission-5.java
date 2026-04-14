class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord) || beginWord.equals(endWord)) {
            return 0;
        }
        
        if(words.contains(beginWord)) {
            words.remove(beginWord);
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int ans = 0;

        while(!queue.isEmpty()) {
            ans++;
            int len = queue.size();
            for(int i=0; i<len; i++) {
                String curr = queue.poll();
                if(endWord.equals(curr)) {
                    return ans;
                }
                StringBuilder sb = new StringBuilder(curr);
                for(int it=0; it<sb.length(); it++) {
                    char c = sb.charAt(it);
                    for(char ch='a'; ch<='z'; ch++) {
                        if(sb.charAt(it)==ch) {
                            continue;
                        }
                        sb.setCharAt(it, ch);
                        if(words.contains(sb.toString())) {
                            queue.offer(sb.toString());
                            words.remove(sb.toString());
                        }
                    }
                    sb.setCharAt(it, c);
                }
            }
        }
        return 0;
    }
}
