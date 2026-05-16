class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) {
            return false;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for(int num : hand) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for(int num : hand) {
            int start = num;
            while(count.getOrDefault(start - 1, 0) > 0) {
                start--;
            }

            while(start <= num) {
                while(count.getOrDefault(start, 0) > 0) {
                    int minCount = count.get(start);
                    for(int i = start; i < start + groupSize; i++) {
                        if(count.getOrDefault(i, 0) < minCount) {
                            return false;
                        }
                        count.put(i, count.get(i) - minCount);
                    }
                }
                start++;
            }
        }
        return true;
    }
}
