class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        if(nums.length == 0) {
            return 0;
        }

        for(int num : nums) {
            set.add(num);
        }

        int len = 1;
        for(int num : nums) {
            if(set.contains(num-1)) {
                continue;
            }
            int n = 1;
            set.remove(num);
            while(set.contains(num+n)) {
                set.remove(num+n);
                n++;
            }
            len = Math.max(len, n);
        }

        return len;
    }
}
