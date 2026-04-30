class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord) || beginWord.equals(endWord)) {
            return 0;
        }

        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> qb = new LinkedList<>(), qe = new LinkedList<>();

        int wordLen = wordList.get(0).length();

        qb.offer(beginWord);
        qe.offer(endWord);

        Map<String, Integer> fromBegin = new HashMap<>(), fromEnd = new HashMap<>();
        fromBegin.put(beginWord, 1);
        fromEnd.put(endWord, 1);

        while(!qb.isEmpty() && !qe.isEmpty()) {
            if(qb.size() > qe.size()) {
                Queue<String> tempQ = qb;
                qb = qe;
                qe = tempQ;
                Map<String, Integer> tempMap = fromBegin;
                fromBegin = fromEnd;
                fromEnd = tempMap;
            }

            int size = qb.size();
            for(int k = 0; k < size; k++) {
                String word = qb.poll();
                int steps = fromBegin.get(word);
                StringBuilder sb = new StringBuilder(word);
                for(int i = 0; i < wordLen; i++) {
                    char actChar = word.charAt(i);
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        if(sb.charAt(i) == ch) {
                            continue;
                        }
                        sb.setCharAt(i, ch);
                        String newWord = sb.toString();
                        if(!wordSet.contains(newWord)) {
                            sb.setCharAt(i, actChar);
                            continue;
                        }
                        if(fromEnd.containsKey(newWord)) {
                            return steps + fromEnd.get(newWord);
                        }
                        if(!fromBegin.containsKey(newWord)) {
                            fromBegin.put(newWord, steps + 1);
                            qb.offer(newWord);
                        }
                    }
                    sb.setCharAt(i, actChar);
                }
            }
        }
        return 0;
    }
}
