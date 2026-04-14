class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = nums1, b = nums2;

        int total = a.length + b.length;
        int half = (total+1)/2;

        if(a.length>b.length) {
            int[] temp = a;
            a = b;
            b = temp;
        }

        int l = 0, r = a.length;

        while(l<=r) {
            int i = l+ (r-l)/2;
            int j = half-i; //a and b are indexed from 0

            int aLeft = i > 0 ? a[i - 1] : Integer.MIN_VALUE;
            int aRight = i < a.length ? a[i] : Integer.MAX_VALUE;
            int bLeft = j > 0 ? b[j - 1] : Integer.MIN_VALUE;
            int bRight = j < b.length ? b[j] : Integer.MAX_VALUE;

            if(bLeft<=aRight && aLeft<=bRight) {
                if(total%2!=0) {
                    return Math.max(aLeft, bLeft);
                }
                else {
                    return (Math.max(aLeft, bLeft)+Math.min(aRight, bRight))/2.0;
                }
            }
            else if(aLeft>bRight) {
                r = i-1;
            }
            else {
                l = i+1;
            }
        }
        return -1;
    }
}
