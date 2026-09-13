class Solution {
    private int binarySearch(int[] arr, int ele) {
        int l = 0, r = arr.length - 1, ind = r;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(arr[mid] >= ele) {
                ind = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(ind);
        return ind;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(k >= arr.length) {
            List<Integer> list = new ArrayList<>(arr.length);
            for (int num : arr) {
                list.add(num);
            }
            return list;
        }
        int findInd = binarySearch(arr, x);
        int l = findInd, r = findInd;

        while(r - l < k + 1) {
            if(l >= 0 && r < arr.length) {
                if(Math.abs(arr[l] - x) <= Math.abs(arr[r] - x)) {
                    l--;
                } else {
                    r++;
                }
            } else if(l >= 0) {
                l--;
            } else {
                r++;
            }
        }

        List<Integer> closests = new ArrayList<>();

        for(int i = l + 1; i < r; i++) {
            closests.add(arr[i]);
        }

        return closests;
    }
}