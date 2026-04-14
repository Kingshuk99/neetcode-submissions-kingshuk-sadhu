class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private void dfs(int[] nums, List<Integer> res) {
        int n = nums.length;
        if(n==1) {
            res.add(nums[0]);
            ans.add(new ArrayList<>(res));
            res.remove(res.size()-1);
            return;
        }

        for(int i=0; i<n; i++) {
            res.add(nums[i]);
            int[] remainingNums = new int[n-1];
            int ind = 0;
            for(int j=0; j<n; j++) {
                if(i!=j) {
                    remainingNums[ind++] = nums[j];
                }
            }
            dfs(remainingNums, res);
            res.remove(res.size()-1);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> res = new ArrayList<>();
        dfs(nums, res);
        return ans;
    }
}
