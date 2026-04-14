class MinStack {
    Stack<Long> stack;
    long min;
    public MinStack() {
        this.stack = new Stack<>();
        this.min = 0;
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(0L);
            min = val;
        } else {
            stack.push(val - min);
            if(val < min) min = val;
        }
    }
    
    public void pop() {
        if(stack.isEmpty()) return;
        long element = stack.pop();
        if(element < 0) {
            min = min - element;
        }
    }
    
    public int top() {
        long top = stack.peek();
        if(top >= 0) {
            return (int)(min + top);
        } else {
            return (int)min;
        }
    }
    
    public int getMin() {
        return (int) min;
    }
}
