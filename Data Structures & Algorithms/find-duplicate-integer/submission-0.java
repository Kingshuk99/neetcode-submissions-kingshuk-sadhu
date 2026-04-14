class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        for(int i=0; i<n; i++) {
            int num = nums[i];
            if(num-1==i) {
                continue;
            }

            int temp = nums[num-1];

            if(temp==num) {
                return num;
            }

            nums[num-1] = num;
            nums[i] = temp;
        }
        return -1;
    }
}
