class TrieNode {
    TrieNode[] children;
    boolean isWord;

    TrieNode() {
        this.children = new TrieNode[26];
        this.isWord = false;
    }
}
class Trie {
    TrieNode root;

    Trie() {
        this.root = new TrieNode();
    }

    void addWord(String s) {
        TrieNode node = root;
        for(char ch : s.toCharArray()) {
            int ind = ch - 'a';
            if(node.children[ind] == null) {
                node.children[ind] = new TrieNode();
            }
            node = node.children[ind];
        }
        node.isWord = true;
    }

    boolean isWord(String s, int i, int j) {
        TrieNode node = root;
        for(int ind = i; ind < j; ind++) {
            int idx = s.charAt(ind) - 'a';
            if(node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
        }
        return node.isWord;
    }
}
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int maxLen = 0;
        Trie trie = new Trie();

        for(String word : wordDict) {
            trie.addWord(word);
            maxLen = Math.max(maxLen, word.length());
        }

        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i + 1; j <= Math.min(s.length(), i + maxLen); 
            j++) {
                if(trie.isWord(s, i, j) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[0];
    }
}
