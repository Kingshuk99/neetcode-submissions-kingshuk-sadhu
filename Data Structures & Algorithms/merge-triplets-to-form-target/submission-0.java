class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> good = new HashSet<>();
        for(int[] triplet : triplets) {
            if(triplet[0] > target[0] || triplet[1] > target[1] || 
            triplet[2] > target[2]) {
                continue;
            }
            for(int i=0; i<triplet.length; i++) {
                if(target[i] == triplet[i]) {
                    good.add(i);
                }
            }
        }

        return good.size() == 3;
    }
}
