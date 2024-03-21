class RecentCounter {
    Queue<Integer>q;

    public RecentCounter() {
       q=new LinkedList<Integer>();
    }
    
    public int ping(int t) {
        if(q.isEmpty()){
            q.offer(t);
            return q.size();
        }
        int start = t - 3000;
        int end = t;
        q.offer(t);
        while(!q.isEmpty() && q.peek()<start){
            q.poll();
        }
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */