class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        if(sum%2!=0) {
            return false;
        }

        sum /= 2;

        Set<Integer> dp = new HashSet<>();
        dp.add(0);

        for(int num : nums) {
            Set<Integer> newDp = new HashSet<>();
            for(int val : dp) {
                if(val + num == sum) {
                    return true;
                }
                newDp.add(val);
                newDp.add(val + num);
            }
            dp = newDp;
        }

        return false;
    }
}
