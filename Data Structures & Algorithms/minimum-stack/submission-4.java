class MinStack {
    Stack<Long> stack;
    long min;
    public MinStack() {
        this.stack = new Stack<>();
        this.min = 0L;
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(0L);
            min = (long) val;
            return;
        }
        stack.push(val - min);
        if(val < min) {
            min = val;
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) {
            return;
        }
        long popped = stack.pop();
        if(popped < 0) {
            min = min - popped;
        }
    }
    
    public int top() {
        long top = stack.peek();
        if(top >= 0) {
            return (int) (min + top);
        }
        return (int) min;
    }
    
    public int getMin() {
        return (int) min;
    }
}
