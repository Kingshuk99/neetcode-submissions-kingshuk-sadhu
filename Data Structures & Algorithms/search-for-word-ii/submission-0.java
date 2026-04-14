class Node {
    char val;
    Node[] children;
    boolean isWord;

    public Node(char val) {
        this.val = val;
        this.children = new Node[26];
        this.isWord = false;
    }
}

class Trie {
    Node root;
    public Trie() {
        root = new Node('\0');
    }

    public void addWord(String word) {
        Node node = root;
        for(char c : word.toCharArray()) {
            if(node.children[c-'a']==null) {
                node.children[c-'a'] = new Node(c);
            }
            node = node.children[c-'a'];
        }
        node.isWord = true;
    }
}
class Solution {
    private Trie trie;
    int ROWS, COLS;
    private Set<String> res;

    public List<String> findWords(char[][] board, String[] words) {
        ROWS = board.length;
        COLS = board[0].length;
        trie = new Trie();
        res = new HashSet<>();

        for(String word : words) {
            trie.addWord(word);
        }

        for(int i=0; i<ROWS; i++) {
            for(int j=0; j<COLS; j++) {
                Node node = trie.root;
                dfs(board, i, j, "", node);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, int i, int j, String s, Node node) {
        if(i<0 || j<0 || i==ROWS || j==COLS || board[i][j]=='.' || 
        node.children[board[i][j]-'a']==null) {
            return;
        }
        char ch = board[i][j];
        board[i][j] = '.';
        node = node.children[ch-'a'];
        s += ch;
        if(node.isWord) {
            res.add(s);
        }
        dfs(board, i+1, j, s, node);
        dfs(board, i, j+1, s, node);
        dfs(board, i-1, j, s, node);
        dfs(board, i, j-1, s, node);
        board[i][j] = ch;
    }
}
