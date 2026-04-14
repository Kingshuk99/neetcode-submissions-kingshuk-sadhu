class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0)+1);
        }

        List<Integer>[] freqArr = new List[nums.length+1];

        for(int i=0; i<freqArr.length; i++) {
            freqArr[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry:freq.entrySet()) {
            freqArr[entry.getValue()].add(entry.getKey());
        }

        int[] ans = new int[k];

        int index = 0;

        for(int i=freqArr.length-1; i>0 && index<k; i--) {
            for(int n:freqArr[i]) {
                ans[index++] = n;
                if(index==k) {
                    return ans;
                }
            }
        }

        return ans;
    }
}
