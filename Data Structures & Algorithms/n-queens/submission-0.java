class Solution {
    Set<Integer> col = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    List<List<String>> ans = new ArrayList<>();
    char[][] board;

    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];

        for(char[] row : board) {
            Arrays.fill(row, '.');
        }

        dfs(0, n);

        return ans;
    }

    private void dfs(int r, int n) {
        if(r == n) {
            List<String> res = new ArrayList<>();
            for(char[] row : board) {
                res.add(new String(row));
            }

            ans.add(res);
            return;
        }

        for(int c=0; c<n; c++) {
            if(col.contains(c) || posDiag.contains(r+c) || negDiag.contains(r-c)) {
                continue;
            }
            board[r][c] = 'Q';
            col.add(c);
            posDiag.add(r+c);
            negDiag.add(r-c);

            dfs(r+1, n);

            board[r][c] = '.';
            col.remove(c);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
        }
    }
}
