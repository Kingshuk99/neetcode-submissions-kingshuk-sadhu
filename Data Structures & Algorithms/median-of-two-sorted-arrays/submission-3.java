class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int len = n1 + n2;
        int half = (len + 1)/2;

        if(n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int l = 0, r = n1;
        while(l<=r) {
            int i = l + (r-l)/2, j = half - i;

            int left1 = i>0 ? nums1[i-1] : Integer.MIN_VALUE;
            int left2 = j>0 ? nums2[j-1] : Integer.MIN_VALUE;
            int right1 = i<n1 ? nums1[i] : Integer.MAX_VALUE;
            int right2 = j<n2 ? nums2[j] : Integer.MAX_VALUE;

            if(left1<=right2 && left2<=right1) {
                if(len % 2 != 0) {
                    return (double) Math.max(left1, left2);
                } else {
                    return ((double)(Math.max(left1, left2) + Math.min(right1, right2)))/2;
                }
            } else if(left1 > right2) {
                r = i-1;
            } else {
                l = i+1;
            }
        }

        return -1;
    }
}
