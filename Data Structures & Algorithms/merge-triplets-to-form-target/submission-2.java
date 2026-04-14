class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> s = new HashSet<>();
        for(int[] triplet : triplets) {
            if(triplet[0] > target[0] || triplet[1] > target[1] || 
            triplet[2] > target[2]) {
                continue;
            }

            for(int i=0; i<target.length; i++) {
                if(triplet[i]==target[i]) {
                    s.add(i);
                }
            }
        }

        return s.size()==3;
    }
}
