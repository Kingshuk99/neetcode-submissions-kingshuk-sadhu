class WordDictionary {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean endOfWord = false;
    }

    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            if(node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new TrieNode();
            }
            node = node.children[ch - 'a'];
        }
        node.endOfWord = true;
    }

    public boolean search(String word) {
        return searchWord(word, 0, root);
    }

    private boolean searchWord(String word, int ind, TrieNode node) {
        if(node == null) {
            return false;
        }
        
        if(ind == word.length()) {
            return node.endOfWord;
        }

        char ch = word.charAt(ind);

        if(ch != '.') {
            if(node.children[ch - 'a'] == null) {
                return false;
            }
            return searchWord(word, ind+1, node.children[ch - 'a']);
        }

        for(int i = 0; i < 26; i++) {
            if(searchWord(word, ind+1, node.children[i])) {
                return true;
            }
        }
        return false;
    }
}
