class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int i=0;
        while(i<s.length()) {
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[') {
                stack.push(s.charAt(i));
                i++;
                continue;
            }
            if((s.charAt(i)==')' && (stack.isEmpty() || stack.peek()!='(')) || 
            (s.charAt(i)=='}' && (stack.isEmpty() || stack.peek()!='{')) || 
            (s.charAt(i)==']' && (stack.isEmpty() || stack.peek()!='['))) {
                return false;
            }
            else {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
