class MinStack {
    private Stack<Integer> stack, minValStack;

    public MinStack() {
        stack = new Stack<>();
        minValStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        minValStack.push(Math.min(minValStack.isEmpty()?val:minValStack.peek(), val));
    }
    
    public void pop() {
        stack.pop();
        minValStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minValStack.peek();
    }
}
