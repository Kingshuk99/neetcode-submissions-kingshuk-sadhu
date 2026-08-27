class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int maxWeight = 0;
        for(int person : people) {
            maxWeight = Math.max(maxWeight, person);
        }

        if(maxWeight > limit) {
            return -1;
        }

        int[] counts = new int[maxWeight + 1];
        for(int person : people) {
            counts[person]++;
        }

        int idx = 0, i = 1;
        while(idx < people.length) {
            while(counts[i] == 0) {
                i++;
            }
            people[idx++] = i;
            counts[i]--;
        }

        int boats = 0, l = 0, r = people.length - 1;
        while(l < r) {
            int curr = people[l] + people[r];
            if(curr <= limit) {
                l++;
            }
            r--;
            boats++;
        }
        if(l == r) {
            boats++;
        }
        return boats;
    }
}