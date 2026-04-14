class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] freq = new ArrayList[nums.length + 1];
        Map<Integer, Integer> counts = new HashMap<>();
        for(int i=0; i<freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for(int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        for(int key : counts.keySet()) {
            freq[counts.get(key)].add(key);
        }

        int[] ans = new int[k];
        
        for(int i=freq.length-1; i>=0 && k>0; i--) {
            if(freq[i].size()==0) {
                continue;
            }
            
            int ind = 0;
            while(ind < freq[i].size() && k > 0) {
                k--;
                ans[k] = freq[i].get(ind++);
            }
        }

        return ans;
    }
}
