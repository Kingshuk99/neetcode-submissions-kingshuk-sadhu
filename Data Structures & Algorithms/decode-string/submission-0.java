class Solution {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> strs = new Stack<>();

        StringBuilder curr = new StringBuilder();
        int k = 0;

        for(char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                strs.push(curr.toString());
                counts.push(k);
                k = 0;
                curr = new StringBuilder();
            } else if (ch == ']') {
                String temp = curr.toString();
                curr = new StringBuilder(strs.pop());

                int count = counts.pop();
                for(int i = 0; i < count; i++) {
                    curr.append(temp);
                }
            } else {
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}