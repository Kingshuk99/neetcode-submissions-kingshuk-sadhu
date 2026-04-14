class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(isOpeningBracket(ch)) {
                stack.push(ch);
                continue;
            }
            char openingBracket = findOpeningBracket(ch);
            if(stack.isEmpty() || stack.peek() != openingBracket) {
                return false;
            }
            stack.pop();
        }
        if(!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    private boolean isOpeningBracket(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }

    private char findOpeningBracket(char ch) {
        if(ch == ')') {
            return '(';
        } else if(ch == '}') {
            return '{';
        } else {
            return '[';
        }
    }
}
