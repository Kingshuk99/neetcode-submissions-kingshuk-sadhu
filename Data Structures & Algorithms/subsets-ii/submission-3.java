class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int ind = 0, prevInd = 0;
        ans.add(new ArrayList<>());

        for(int i = 0; i < nums.length; i++) {
            ind = (i >= 1 && nums[i] == nums[i - 1]) ? prevInd : 0;
            prevInd = ans.size();

            for(int j = ind; j < prevInd; j++) {
                List<Integer> res = new ArrayList<>(ans.get(j));
                res.add(nums[i]);
                ans.add(res);
            }
        }
        return ans;
    }
}
