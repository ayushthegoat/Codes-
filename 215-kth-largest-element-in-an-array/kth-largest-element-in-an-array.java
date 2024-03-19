class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer>q=new PriorityQueue<Integer>((a,b)->b-a);
        for(int num:nums)q.offer(num);
        int res=0;
        while(k-->0){res=q.poll();}
        return res;
    }
}