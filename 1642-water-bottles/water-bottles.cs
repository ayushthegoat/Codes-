public class Solution {
    public int NumWaterBottles(int numBottles, int numExchange) {
        Queue<int>q = new Queue<int>();
        int count = numBottles;
        for(int i = 1;i<=numBottles;i++) {
            q.Enqueue(1);
        }
        int currCount = 0;
        while(q.Count > 0) {
            currCount++;
            if(currCount == numExchange) {
                count++;
                currCount = 0;
                q.Enqueue(1);

            }
            q.Dequeue();
        }

        return count;
    }
}