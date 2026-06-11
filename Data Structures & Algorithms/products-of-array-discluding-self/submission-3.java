class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        int multiplier = 1;

        for(int i = 0; i < nums.length; i++) {
            products[i] = multiplier;
            multiplier *= nums[i];
        }

        multiplier = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            products[i] *= multiplier;
            multiplier *= nums[i];
        }

        return products;
    }
}  
