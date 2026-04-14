class Solution {
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();

        char[][] board = new char[n][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> ans = new ArrayList<>();
        dfs(0, n, ans, board, cols, posDiag, negDiag);
        return ans;
    }

    private void dfs(int r, int n, List<List<String>> ans, char[][] board, 
    Set<Integer> cols, Set<Integer> posDiag, Set<Integer> negDiag) {
        if(r==n) {
            List<String> res = new ArrayList<>();
            for(char[] row : board) {
                String s = new String(row);
                res.add(s);
            }
            ans.add(res);
            return;
        }

        for(int c=0; c<n; c++) {
            if(cols.contains(c) || posDiag.contains(r+c) || negDiag.contains(r-c)) {
                continue;
            }
            board[r][c] = 'Q';
            cols.add(c);
            posDiag.add(r+c);
            negDiag.add(r-c);

            dfs(r+1, n, ans, board, cols, posDiag, negDiag);

            board[r][c] = '.';
            cols.remove(c);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
        }
    }
}
