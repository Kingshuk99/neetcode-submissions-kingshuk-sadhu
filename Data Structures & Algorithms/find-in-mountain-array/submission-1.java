/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    private Map<Integer, Integer> cache = new HashMap<>();

    private int get(int ind, MountainArray mountainArr) {
        if(!cache.containsKey(ind)) {
            cache.put(ind, mountainArr.get(ind));
        }
        return cache.get(ind);
    }

    private int binarySearch(int l, int r, boolean ascending, MountainArray mountainArr, int target) {
        while (l <= r) {
            int m = (l + r) >> 1;
            int val = get(m, mountainArr);
            if (val == target) {
                return m;
            }
            if (ascending == (val < target)) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        // Find Peak
        int l = 1, r = len - 2, peak = 0;

        while(l <= r) {
            int m = l + (r - l) / 2;
            int left = get(m - 1, mountainArr), mid = get(m, mountainArr), right = get(m + 1, mountainArr);
            if(left < mid && mid > right) {
                peak = m;
                break;
            } else if(left < mid && mid < right) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        int res = binarySearch(0, peak, true, mountainArr, target);
        if (res != -1) {
            return res;
        }

        return binarySearch(peak, len - 1, false, mountainArr, target);
    }
}