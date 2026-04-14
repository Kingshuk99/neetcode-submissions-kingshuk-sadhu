class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while(!visited.contains(n)) {
            visited.add(n);
            n = sumOfSquareDigits(n);
            if(n==1) {
                return true;
            }
        }
        return false;
    }

    private int sumOfSquareDigits(int n) {
        int sum = 0;
        while(n!=0) {
            int digit = n%10;
            sum += digit*digit;
            n /= 10;
        }

        return sum;
    }
}
