class Solution {
    class Node {
        char val;
        boolean isWord;
        Node[] children;

        Node(char val) {
            this.val = val;
            this.isWord = false;
            this.children = new Node[26];
        }
    }

    class Trie {
        Node root;
        Trie() {
            this.root = new Node('\0');
        }

        public void addWord(String word) {
            Node node = root;
            for(char ch : word.toCharArray()) {
                if(node.children[ch-'a']==null) {
                    node.children[ch-'a'] = new Node(ch);
                }
                node = node.children[ch-'a'];
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

        Set<String> ans = new HashSet<>();

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                dfs(board, i, j, ans, trie.root, "");
            }
        }
        return new ArrayList<>(ans);
    }

    private void dfs(char[][] board, int i, int j, Set<String> ans, Node node, 
    String s) {
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || 
        board[i][j]=='.' || node.children[board[i][j]-'a']==null) {
            return;
        }
        char ch = board[i][j];
        board[i][j] = '.';
        node = node.children[ch-'a'];
        if(node.isWord) {
            ans.add(s+ch);
        }

        dfs(board, i+1, j, ans, node, s+ch);
        dfs(board, i-1, j, ans, node, s+ch);
        dfs(board, i, j+1, ans, node, s+ch);
        dfs(board, i, j-1, ans, node, s+ch);

        board[i][j] = ch;
    }
}
