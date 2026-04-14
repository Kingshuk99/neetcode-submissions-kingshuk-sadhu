class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) {
            return 0;
        }

        Set<String> words = new HashSet<>(wordList);
        if(words.contains(beginWord)) {
            words.remove(beginWord);
        }

        if(!words.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int ans = 0;

        while(!queue.isEmpty()) {
            ans++;
            int len = queue.size();

            for(int i=0; i<len; i++) {
                String word = queue.poll();
                StringBuilder sb = new StringBuilder(word);
                for(int j=0; j<word.length(); j++) {
                    char ch = word.charAt(j);
                    for(char c='a'; c<='z'; c++) {
                        if(ch==c) {
                            continue;
                        }
                        sb.setCharAt(j, c);
                        String s = sb.toString();
                        if(words.contains(s)) {
                            if(s.equals(endWord)) {
                                return ans+1;
                            }
                            queue.offer(s);
                            words.remove(s);
                        }
                    }
                    sb.setCharAt(j, ch);
                }
            }
        }
        return 0;
    }
}
