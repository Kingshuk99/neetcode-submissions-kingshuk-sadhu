class Solution {
    private int n, m;
    private boolean dfs(char[][] board, int i, int j, String word, int ind) {
        if(ind==word.length()-1 && word.charAt(ind)==board[i][j]) {
            return true;
        }

        if(word.charAt(ind)!=board[i][j]) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '.';

        if(j>0 && board[i][j-1]!='.' && dfs(board, i, j-1, word, ind+1)) {
            return true;
        }

        if(i>0 && board[i-1][j]!='.' && dfs(board, i-1, j, word, ind+1)) {
            return true;
        }

        if(j<m-1 && board[i][j+1]!='.' && dfs(board, i, j+1, word, ind+1)) {
            return true;
        }

        if(i<n-1 && board[i+1][j]!='.' && dfs(board, i+1, j, word, ind+1)) {
            return true;
        }

        board[i][j] = temp;

        return false;
    }
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
}
