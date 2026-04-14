class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int num : nums) {
            if(ans.isEmpty() || ans.get(ans.size()-1) < num) {
                ans.add(num);
            } else {
                int low = Collections.binarySearch(ans, num); //index of number just greater than num
                if(low < 0) {
                    low = -(low+1);
                }
                ans.set(low, num);
            }
            System.out.println(ans.toString());
        }
        return ans.size();
    }
}
