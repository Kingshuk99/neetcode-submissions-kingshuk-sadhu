class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();

        int i=0;
        while(i<tokens.length) {
            System.out.println(tokens[i]);
            if(tokens[i].equals("+")) {
                int a = operands.pop();
                int b = operands.pop();
                operands.push(b+a);
            }
            else if(tokens[i].equals("-")) {
                int a = operands.pop();
                int b = operands.pop();
                operands.push(b-a);
            }
            else if(tokens[i].equals("*")) {
                int a = operands.pop();
                int b = operands.pop();
                operands.push(b*a);
            }
            else if(tokens[i].equals("/")) {
                int a = operands.pop();
                int b = operands.pop();
                operands.push(b/a);
            }
            else {
                int operand = Integer.parseInt(tokens[i]);
                operands.push(operand);
            }
            i++;
        }
        return operands.peek();
    }
}
