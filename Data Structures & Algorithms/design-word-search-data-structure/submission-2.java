class WordDictionary {
    class TreeNode {
        char val;
        boolean isWord;
        TreeNode[] children;

        TreeNode(char val) {
            this.val = val;
            children = new TreeNode[26];
            this.isWord = false;
        }
    }
    private TreeNode root;
    public WordDictionary() {
        root = new TreeNode('\0');
    }

    public void addWord(String word) {
        TreeNode node = root;

        for(char ch : word.toCharArray()) {
            int ind = ch-'a';
            if(node.children[ind]==null) {
                node.children[ind] = new TreeNode(ch);
            }
            node = node.children[ind];
        }

        node.isWord = true;
    }

    public boolean search(String word) {
        return searchUtil(word, 0, root);
    }

    private boolean searchUtil(String word, int ind, TreeNode node) {
        if(node==null) {
            return false;
        }
        if(ind==word.length()) {
            return node.isWord;
        }

        if(word.charAt(ind)=='.') {
            for(int i=0; i<26; i++) {
                if(searchUtil(word, ind+1, node.children[i])) {
                    return true;
                }
            }
            return false;
        }
        
        node = node.children[word.charAt(ind)-'a'];
        return searchUtil(word, ind+1, node);
    }
}
