class FreqStack {
    private Map<Integer, Integer> counts;
    private List<Stack<Integer>> stacks;

    public FreqStack() {
        this.counts = new HashMap<>();
        this.stacks = new ArrayList<>();
        this.stacks.add(new Stack<>());
    }
    
    public void push(int val) {
        int count = counts.getOrDefault(val, 0) + 1;
        counts.put(val, count);
        if(count == stacks.size()) {
            stacks.add(new Stack<>());
        }
        stacks.get(count).push(val);
    }
    
    public int pop() {
        Stack<Integer> topStack = stacks.get(stacks.size() - 1);
        int res = topStack.pop();
        counts.put(res, counts.get(res) - 1);
        if(topStack.isEmpty()) {
            stacks.remove(stacks.size() - 1);
        }
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */