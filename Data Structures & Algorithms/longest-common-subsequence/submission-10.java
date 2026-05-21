class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // return dfs(text1, text2, 0, 0);

        if(text1.length() < text2.length()) {
            return longestCommonSubsequence(text2, text1);
        }

        int[] prev = new int[text2.length() + 1];
        int[] curr = new int[text2.length() + 1];

        for(int i = text1.length() - 1; i >= 0; i--) {
            for(int j = text2.length() - 1; j >= 0; j--) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    curr[j] = 1 + prev[j + 1];
                    continue;
                }
                curr[j] = Math.max(prev[j], curr[j + 1]);
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }

        return prev[0];
    }

    // private int dfs(String text1, String text2, int i, int j) {
    //     if(i == text1.length() || j == text2.length()) {
    //         return 0;
    //     }

    //     if(text1.charAt(i) == text2.charAt(j)) {
    //         return 1 + dfs(text1, text2, i + 1, j + 1);
    //     }

    //     return Math.max(dfs(text1, text2, i + 1, j), 
    //     dfs(text1, text2, i + 1, j));
    // }
}
