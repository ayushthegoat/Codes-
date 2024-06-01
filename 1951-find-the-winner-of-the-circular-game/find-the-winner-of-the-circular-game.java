class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList();
        for (int i = 1; i <=n; i++) {
            q.offer(i);
        }

        int num = 0;
        while (q.size()>1) {
            num++;
            if (num % k == 0) {
                q.poll();
            } else {
                q.offer(q.poll());
            }
        
        }
        return q.peek();
    }
}