class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int ind = -1, ref = 0;
    }

    class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }

        void addWord(String word, int ind) {
            TrieNode node = root;
            node.ref++;
            for(char ch : word.toCharArray()) {
                if(node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
                node.ref++;
            }
            node.ind = ind;
        }
    }

    Trie trie = new Trie();
    public List<String> findWords(char[][] board, String[] words) { 
        for(int i = 0; i < words.length; i++) {
            trie.addWord(words[i], i);
        }

        List<String> res = new ArrayList<>();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                findWord(board, i, j, res, words, trie.root);
            }
        }

        return res;
    }

    private void findWord(char[][] board, int i, int j, List<String> res,
     String[] words, TrieNode node) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
        board[i][j] == '.' || node.children[board[i][j] - 'a'] == null) {
            return;
        }

        char ch = board[i][j];
        board[i][j] = '.';
        TrieNode prev = node;
        node = node.children[ch - 'a'];

        if(node.ind != -1) {
            res.add(words[node.ind]);
            node.ind = -1;
            node.ref--;
            if(node.ref == 0) {
                node = null;
                prev.children[ch - 'a'] = null;
                board[i][j] = ch;
                return;
            }
        }

        findWord(board, i + 1, j, res, words, node);
        findWord(board, i, j + 1, res, words, node);
        findWord(board, i - 1, j, res, words, node);
        findWord(board, i, j - 1, res, words, node);

        board[i][j] = ch;
     }
}
