class PrefixTree {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean endOfWord = false;
    }

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            if(node.children[ch-'a'] == null) {
                node.children[ch-'a'] = new TrieNode();
            }
            node = node.children[ch-'a'];
        }
        node.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            if(node.children[ch-'a'] == null) {
                return false;
            }
            node = node.children[ch-'a'];
        }
        return node.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char ch : prefix.toCharArray()) {
            if(node.children[ch-'a'] == null) {
                return false;
            }
            node = node.children[ch-'a'];
        }
        return true;
    }
}
