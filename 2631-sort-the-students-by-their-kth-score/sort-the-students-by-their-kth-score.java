class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        

        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->score[b][k]- score[a][k]);
        for(int i=0;i<score.length;i++){
            q.offer(i);
        }
      
        int[][] res = new int[score.length][score[0].length];
        int idx=0;
        
        while(!q.isEmpty()){
            int index = q.poll();
            res[idx++] = score[index];
        }
        
        return res;
    }
}