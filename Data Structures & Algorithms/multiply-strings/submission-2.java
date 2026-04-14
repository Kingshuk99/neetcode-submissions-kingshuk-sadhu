class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        int[] res = new int[num1.length() + num2.length()];
        for(int i=0; i<num1.length(); i++) {
            for(int j=0; j<num2.length(); j++) {
                int n1 = num1.charAt(i)-'0';
                int n2 = num2.charAt(j)-'0';
                res[i+j] += n1*n2;
                res[i+j+1] += res[i+j]/10;
                res[i+j] %= 10;
            }
        }

        int n = res.length-1;
        while(n>=0 && res[n]==0) {
            n--;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=n; i>=0; i--) {
            sb.append(res[i]);
        }

        return sb.toString();
    }
}
