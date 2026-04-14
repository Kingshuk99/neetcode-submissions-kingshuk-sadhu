class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(isOpeningBracket(ch)) {
                stack.push(ch);
                continue;
            }
            if(stack.isEmpty() || stack.peek() != findOpening(ch)) {
                return false;
            }
            stack.pop();
        }

        return stack.isEmpty();
    }

    private boolean isOpeningBracket(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }

    private char findOpening(char ch) {
        return switch (ch) {
            case ')' -> '(';
            case '}' -> '{';
            default -> '[';
        };
    }
}
