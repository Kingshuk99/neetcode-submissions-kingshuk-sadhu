class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) {
            return 0;
        }
        int len = 1;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        for(int num : nums) {
            if(!set.contains(num-1)) {
                int n = 1;
                while(set.contains(num+n)) {
                    n++;
                }
                len = Math.max(len, n);
            } 
        }
        return len;
    }
}
