class WordDictionary {
    private Node root;
    public WordDictionary() {
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

    public boolean search(String word) {
        Node node = root;
        return find(node, word, 0);
    }

    private boolean find(Node node, String word, int ind) {
        if(ind==word.length()) {
            return node.isWord;
        }
        
        if(word.charAt(ind)=='.') {
            for(int i=0; i<26; i++) {
                if(node.children[i]!=null && find(node.children[i], word, ind+1)) {
                    return true;
                }
            }
            return false;
        }

        if(node.children[word.charAt(ind)-'a']==null) {
            return false;
        }

        return find(node.children[word.charAt(ind)-'a'], word, ind+1);
    }

    class Node {
        public char val;
        public boolean isWord;
        public Node[] children;

        public Node(char val) {
            this.val = val;
            this.isWord = false;
            this.children = new Node[26];
        }
    }
}
