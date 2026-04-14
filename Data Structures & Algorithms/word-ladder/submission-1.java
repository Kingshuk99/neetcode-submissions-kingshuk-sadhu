class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int ans = 0;
        if(beginWord == endWord) {
            return 0;
        }

        int n = beginWord.length();
        Set<String> set = new HashSet<>(wordList);

        if(!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();

        q.offer(beginWord);
        set.remove(beginWord);

        while(!q.isEmpty()) {
            ans++;
            int len = q.size();

            for(int i=0; i<len; i++) {
                String curr = q.poll();
                StringBuilder sb = new StringBuilder(curr);
                for(int j=0; j<n; j++) {
                    char ch = curr.charAt(j);
                    for(char c='a'; c<='z'; c++) {
                        sb.setCharAt(j, c);
                        String newCurr = sb.toString();
                        if(set.contains(newCurr)) {
                            if(endWord.equals(newCurr)) {
                                return ans+1;
                            }
                            else {
                                q.offer(newCurr);
                                set.remove(newCurr);
                            }
                        }
                    }
                    sb.setCharAt(j, ch);
                }
            }
        }

        return 0;
    }
}
