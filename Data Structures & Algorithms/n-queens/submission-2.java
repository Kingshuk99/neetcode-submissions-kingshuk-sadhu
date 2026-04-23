class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[] visited = new int[]{0, 0, 0};
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        dfs(board, 0, n, visited, ans);
        return ans;
    }

    private void dfs(char[][] board, int r, int n, int[] visited, 
    List<List<String>> ans) {
        if(r == n) {
            List<String> res = new ArrayList<>();
            for(char[] row : board) {
                res.add(new String(row));
            }
            ans.add(res);
            return;
        }

        for(int c = 0; c < n; c++) {
            if((visited[0] & (1 << c)) > 0 || (visited[1] & (1 << (r + c))) 
            > 0 || (visited[2] & (1 << (r - c + n))) > 0) {
                continue;
            }
            board[r][c] = 'Q';
            visited[0] ^= (1 << c);
            visited[1] ^= (1 << (r + c));
            visited[2] ^= (1 << (r - c + n));

            dfs(board, r + 1, n, visited, ans);

            board[r][c] = '.';
            visited[0] ^= (1 << c);
            visited[1] ^= (1 << (r + c));
            visited[2] ^= (1 << (r - c + n));
        }
    }
}
