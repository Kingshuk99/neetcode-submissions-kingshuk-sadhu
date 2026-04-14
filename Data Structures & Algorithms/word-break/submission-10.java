class Solution {
    class Node {
        Map<Character, Node> children;
        boolean isWord;

        Node() {
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }

    class Trie {
        Node root;

        Trie() {
            this.root = new Node();
        }

        public void addWord(String word) {
            Node node = root;
            for(char ch : word.toCharArray()) {
                if(!node.children.containsKey(ch)) {
                    node.children.put(ch, new Node());
                }
                node = node.children.get(ch);
            }
            node.isWord = true;
        }

        public boolean searchWord(String word, int i, int j) {
            Node node = root;
            for(int ind=i; ind<=j; ind++) {
                char ch = word.charAt(ind);
                if(!node.children.containsKey(ch)) {
                    return false;
                }
                node = node.children.get(ch);
            }
            return node.isWord;
        }
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        boolean[] dp = new boolean[s.length()+1];
        for(String word : wordDict) {
            trie.addWord(word);
        }

        dp[s.length()] = true;
        int maxLen = 0;
        for(String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }

        for(int i=s.length()-1; i>=0; i--) {
            for(int j=i; j<Math.min(i+maxLen, s.length()); j++) {
                if(trie.searchWord(s, i, j) && dp[j+1]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}
