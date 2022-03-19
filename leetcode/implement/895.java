class FreqStack {
Map<Integer, Integer> freq;
    Map<Integer, Stack <Integer>> group; 
    int maxfreq;
    
    
    public FreqStack() {
     freq   = new HashMap();
        group = new HashMap();
        maxfreq = 0;
    }
    
    public void push(int val) {
        int a = freq.getOrDefault(val, 0)+1;
        freq.put(val, a);
        if(a > maxfreq)
            maxfreq = a;
        
        group.computeIfAbsent(a, z-> (new Stack())).push(val);//없으면 스택 만듬.
        
    }
    
    public int pop() {
        int a = group.get(maxfreq).pop(); //stack값에는 count 아닌 Integer있음.
        freq.put(a, freq.get(a)-1);//최신화해줍니다. 
        if(group.get(maxfreq).size() == 0)//만약 hash맵의 top 스택이 비어있으면. 한칸 내립니다. 
            maxfreq--;
        return a;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */