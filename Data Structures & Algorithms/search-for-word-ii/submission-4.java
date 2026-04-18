class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord = false;
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void addWord(String word) {
            TrieNode node = root;
            for(char ch : word.toCharArray()) {
                if(node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.isWord = true;
        }


    }

    private Trie trie;

    public List<String> findWords(char[][] board, String[] words) {
        trie = new Trie();
        for(String word : words) {
            trie.addWord(word);
        }

        Set<String> res = new HashSet<>();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, trie.root, res, "");
            }
        }

        return new ArrayList(res);
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, 
    Set<String> res, String s) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || 
        board[i][j] == '.' || node.children[board[i][j] - 'a'] == null) {
            return;
        }

        char ch = board[i][j];
        board[i][j] = '.';
        node = node.children[ch - 'a'];
        if(node.isWord) {
            res.add(s + ch);
        }

        dfs(board, i+1, j, node, res, s + ch);
        dfs(board, i-1, j, node, res, s + ch);
        dfs(board, i, j+1, node, res, s + ch);
        dfs(board, i, j-1, node, res, s + ch);

        board[i][j] = ch;
    }
}
