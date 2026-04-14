class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int x:nums) {
            set.add(x);
        }

        int maxLength = 0;

        for(int x:set) {
            if(set.contains(x-1)) {
                continue;
            }
            int currentLength = 1;
            while(set.contains(x+currentLength)) {
                currentLength++;
            }
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }
}
