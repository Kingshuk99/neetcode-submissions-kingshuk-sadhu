class WordDictionary {
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
    private Node root;
    public WordDictionary() {
        root = new Node('\0');
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

    public boolean search(String word) {
        return searchUtil(root, word, 0);
    }

    private boolean searchUtil(Node node, String word, int ind) {
        if(ind==word.length()) {
            return node.isWord;
        }

        if(word.charAt(ind)=='.') {
            for(int i=0; i<26; i++) {
                if(node.children[i]!=null && 
                searchUtil(node.children[i], word, ind+1)) {
                    return true;
                }
            }
            return false;
        }

        if(node.children[word.charAt(ind)-'a']==null) {
            return false;
        }
        return searchUtil(node.children[word.charAt(ind)-'a'], word, ind+1);
    }
}
