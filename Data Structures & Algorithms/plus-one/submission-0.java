class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> res = new ArrayList<>();
        for (int digit : digits) {
            res.add(digit);
        }
        Collections.reverse(res);

        int carry = 1;
        for(int i=0; i<res.size(); i++) {
            int num = res.get(i);
            num += carry;
            carry = num/10;
            num %= 10;
            res.set(i, num);
        }
        if(carry!=0) {
            res.add(carry);
        }
        Collections.reverse(res);
        int[] ans = new int[res.size()];

        for(int i=0; i<res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}
