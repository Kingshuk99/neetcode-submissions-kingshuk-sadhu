class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        if(people[r] > limit) {
            return -1;
        }
        int boats = 0;
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