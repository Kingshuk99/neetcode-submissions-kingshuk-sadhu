class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> set = new HashSet<>();

        for(int[] triplet : triplets) {
            boolean flag = false;
            for(int i = 0; i < triplet.length; i++) {
                if(triplet[i] > target[i]) {
                    flag = true;
                    break;
                }
            }

            if(flag) {
                continue;
            }

            for(int i = 0; i < triplet.length; i++) {
                if(triplet[i] == target[i]) {
                    set.add(i);
                }
            }
        }

        return set.size() == target.length;
    }
}
