class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;

        if(n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int l = 0, h = n1, len = (n1 + n2);
        int half = (len + 1) / 2;

        while(l <= h) {
            int i = l + (h - l)/2, j = half - i;

            int left1 = i > 0 ? nums1[i - 1] : Integer.MIN_VALUE;
            int left2 = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;
            int right1 = i < n1 ? nums1[i] : Integer.MAX_VALUE;
            int right2 = j < n2 ? nums2[j] : Integer.MAX_VALUE;

            if(left1 <= right2 && left2 <= right1) {
                if(len % 2 == 0) {
                    return (double) ((double) Integer.max(left1, left2) + 
                    (double) Integer.min(right1, right2)) / 2.0;
                } else {
                    return (double) Math.max(left1, left2);
                }
            } else if (left1 >= right2){
                h = i - 1;
            } else {
                l = i + 1;
            }
        }
        return -1;
    }
}
