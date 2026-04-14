class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens) {
            if(isOperator(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(operate(a, b, token));
                continue;
            }
            stack.push(Integer.parseInt(token));
        }

        return stack.peek();
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int operate(int a, int b, String operator) {
        return switch(operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
    }
}
