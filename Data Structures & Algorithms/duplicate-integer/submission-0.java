class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> currentNums = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if(currentNums.contains(nums[i])) {
                return true;
            }
            currentNums.add(nums[i]);
        }
        return false;
    }
}
